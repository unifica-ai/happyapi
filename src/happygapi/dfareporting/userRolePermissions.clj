(ns happygapi.dfareporting.userRolePermissions
  "DCM/DFA Reporting And Trafficking API
  Manages your DoubleClick Campaign Manager ad campaigns and reports.
  See: https://developers.google.com/doubleclick-advertisers/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn get$
  "Required parameters: id,profileId
  
  Gets one user role permission by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args]
  {:pre [(util/has-keys? args #{"id" "profileId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/userRolePermissions/{id}"
     #{"id" "profileId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "Required parameters: profileId
  
  Gets a list of user role permissions, possibly filtered."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args]
  {:pre [(util/has-keys? args #{"profileId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/userRolePermissions"
     #{"profileId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
