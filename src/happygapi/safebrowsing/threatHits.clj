(ns happygapi.safebrowsing.threatHits
  "Safe Browsing API
  Enables client applications to check web resources (most commonly URLs) against Google-generated lists of unsafe web resources. The Safe Browsing APIs are for non-commercial use only. If you need to use APIs to detect malicious URLs for commercial purposes – meaning “for sale or revenue-generating purposes” – please refer to the Web Risk API.
  See: https://developers.google.com/safe-browsing/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "safebrowsing_schema.edn"))))

(defn create$
  "Required parameters: none
  
  Optional parameters: none
  
  Reports a Safe Browsing threat list hit to Google. Only projects with
  TRUSTED_REPORTER visibility can use this method."
  {:scopes nil}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://safebrowsing.googleapis.com/"
     "v4/threatHits"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))
