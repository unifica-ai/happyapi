(ns happygapi.adsense.savedadstyles
  "AdSense Management API: savedadstyles.
  Accesses AdSense publishers' inventory and generates performance reports.
  See: https://developers.google.com/adsense/management/api/reference/rest/v1.4/savedadstyles"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/adsense/management/api/reference/rest/v1.4/savedadstyles/get
  
  Required parameters: savedAdStyleId
  
  Optional parameters: none
  Get a specific saved ad style from the user's account."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:savedAdStyleId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "savedadstyles/{savedAdStyleId}"
     #{:savedAdStyleId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/adsense/management/api/reference/rest/v1.4/savedadstyles/list
  
  Required parameters: none
  
  Optional parameters: maxResults, pageToken
  List all saved ad styles in the user's account."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "savedadstyles"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
