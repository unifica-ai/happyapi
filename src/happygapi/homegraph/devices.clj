(ns happygapi.homegraph.devices
  "HomeGraph API
  
  See: https://developers.google.com/actions/smarthome/create-app#request-sync"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "homegraph_schema.edn"))))

(defn requestSync$
  "Required parameters: none
  
  Optional parameters: none
  
  Requests a `SYNC` call from Google to a 3p partner's home control agent for
  a user.
  
  
  The third-party user's identity is passed in as `agent_user_id`
  (see RequestSyncDevicesRequest) and forwarded back to the agent.
  The agent is identified by the API key or JWT signed by the partner's
  service account."
  {:scopes nil}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://homegraph.googleapis.com/"
     "v1/devices:requestSync"
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

(defn query$
  "Required parameters: none
  
  Optional parameters: none
  
  Gets the device states for the devices in QueryRequest.
  The third-party user's identity is passed in as `agent_user_id`. The agent
  is identified by the JWT signed by the third-party partner's service
  account."
  {:scopes nil}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://homegraph.googleapis.com/"
     "v1/devices:query"
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

(defn sync$
  "Required parameters: none
  
  Optional parameters: none
  
  Gets all the devices associated with the given third-party user.
  The third-party user's identity is passed in as `agent_user_id`. The agent
  is identified by the JWT signed by the third-party partner's service
  account."
  {:scopes nil}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://homegraph.googleapis.com/"
     "v1/devices:sync"
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

(defn reportStateAndNotification$
  "Required parameters: none
  
  Optional parameters: none
  
  Reports device state and optionally sends device notifications. Called by
  an agent when the device state of a third-party changes or the agent wants
  to send a notification about the device. See
  [Implement Report State](/actions/smarthome/report-state) for more
  information.
  This method updates a predefined set of states for a device, which all
  devices have according to their prescribed traits (for example, a light
  will have the [OnOff](/actions/smarthome/traits/onoff) trait that reports
  the state `on` as a boolean value).
  A new state may not be created and an INVALID_ARGUMENT code will be thrown
  if so. It also optionally takes in a list of Notifications that may be
  created, which are associated to this state change.
  
  The third-party user's identity is passed in as `agent_user_id`.
  The agent is identified by the JWT signed by the partner's service account."
  {:scopes nil}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://homegraph.googleapis.com/"
     "v1/devices:reportStateAndNotification"
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
