(ns happy.beaver
  "Builds code forms for calling the remote APIs."
  (:require [clojure.string :as str]
            [fipp.clojure :as pprint]
            [meander.strategy.epsilon :as s]
            [meander.epsilon :as m]))

(def out-ns "happygapi")

(defn method-name
  "To avoid collisions with clojure.core, methods are named like `get$`.
  Where they are a sub-resource, they are named like `parent-get$`"
  [id]
  (str (str/join \- (drop 2 (str/split id #"\."))) \$))

(defn doc-path [id]
  (str/join \/ (rest (str/split id #"\."))))

(defn summarize-schema [schema request depth]
  (m/rewrite request
    {:type                 "object"
     :id                   ?id
     :additionalProperties ?ap
     :properties           (m/seqable [!property !item] ...)}
    ;;>
    {& ([!property (m/app #(summarize-schema schema % depth) !item)] ...)}

    {:type  "array"
     :items ?item}
    ;;>
    [~(summarize-schema schema ?item depth)]

    {:type (m/pred string? ?type)}
    ;;>
    (m/app symbol ?type)

    {:$ref (m/pred string? ?ref)}
    ;;>
    ~(if (> depth 2)
       (symbol ?ref)
       (summarize-schema schema (get schema (keyword ?ref)) (inc depth)))))

(def extract-method
  (s/rewrite
    [{:baseUrl ?base-url
      :schemas ?schemas
      :documentationLink ?documentationLink
      :version ?version}
     {:id          ?id
      :path        ?path
      :parameters  (m/seqable (m/or [!required-parameters {:required true}]
                                    [!optional-parameters {}]) ...)
      :description ?description
      :scopes      ?scopes
      :httpMethod  ?httpMethod
      :request     (m/and ?request (m/or nil !request))}]
    ;;>
    (defn ~(symbol (method-name ?id))
      ~(str ?documentationLink "api/reference/rest/" ?version "/" (doc-path ?id)
            \newline \newline
            "Required parameters: " (if (seq !required-parameters)
                                      (str/join ", " (map name !required-parameters))
                                      "none")
            \newline \newline
            "Optional parameters: " (if (seq !optional-parameters)
                                      (str/join ", " (map name !optional-parameters))
                                      "none")
            (when (seq ?request)
              (str \newline \newline "Body: " \newline \newline
                   (with-out-str (pprint/pprint (summarize-schema ?schemas ?request 1)))))
            \newline
            ?description)
      {:scopes ?scopes}
      ~(if ?request
         '[auth args body]
         '[auth args])
      {:pre [(util/has-keys? args ~(set !required-parameters))]}
      (util/get-response
        (~(symbol "http" (str/lower-case ?httpMethod))
          (util/get-url ?base-url ?path ~(set !required-parameters) args)
          (merge-with merge
                      {:throw-exceptions false
                       :query-params     args
                       :accept           :json
                       :as               :json
                       &                 ~(when ?request
                                            '{:content-type :json
                                              :body         (json/generate-string body)})}
                      auth))))
    ;;
    ?else ~(throw (ex-info "FAIL" {:input ?else}))))

(def extract-resource-methods
  (s/rewrite
    (m/with [%resource {:methods   (m/seqable [_ !methods] ...)
                        :resources (m/seqable [_ %resource] ...)}]
      [?api %resource])
    ;;>
    ((m/app extract-method [?api !methods]) ...)
    ;;
    ?else ~(throw (ex-info "FAIL" {:input ?else}))))

(def build-ns
  "Takes an API description and returns a namespace."
  (s/rewrite
    [{:as                ?api
      :name              ?api-name
      :title             ?title
      :description       ?description
      :documentationLink ?documentationLink
      :version           ?version
      :id ?id}
     ?resource-name
     ?resource]
    ;;>
    [?resource-name
     ((ns ~(symbol (str out-ns \. ?api-name \. ?resource-name))
        ~(str ?title ": " ?resource-name "." \newline
              ?description \newline
              "See: " ?documentationLink "api/reference/rest/" ?version "/" ?resource-name)
        (:require
          [cheshire.core ~:as json]
          [clj-http.client ~:as http]
          [happy.util ~:as util]))
      & ~(extract-resource-methods [?api ?resource]))]
    ;;
    ?else ~(throw (ex-info "FAIL" {:input ?else}))))

(def build-nss
  (s/rewrite
    {:resources {& (m/seqable [!resource-names !resources] ...)}
     :as        ?api}
    ;;>
    ((m/app build-ns [?api (m/app name !resource-names) !resources]) ...)
    ;;
    ?else ~(throw (ex-info "FAIL" {:input ?else}))))
