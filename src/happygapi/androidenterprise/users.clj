(ns happygapi.androidenterprise.users
  "Google Play EMM API: users.
  Manages the deployment of apps to Android for Work users.
  See: https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/users"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/users/get
  
  Required parameters: enterpriseId, userId
  
  Optional parameters: none
  Retrieves a user's details."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth args]
  {:pre [(util/has-keys? args #{:enterpriseId :userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/users/{userId}"
     #{:enterpriseId :userId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/users/insert
  
  Required parameters: enterpriseId
  
  Optional parameters: none
  
  Body: 
  
  {:accountIdentifier string,
   :accountType string,
   :displayName string,
   :id string,
   :kind string,
   :managementType string,
   :primaryEmail string}
  
  Creates a new EMM-managed user.
  
  The Users resource passed in the body of the request should include an accountIdentifier and an accountType.
  If a corresponding user already exists with the same account identifier, the user will be updated with the resource. In this case only the displayName field can be changed."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:enterpriseId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/users"
     #{:enterpriseId}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn generateToken$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/users/generateToken
  
  Required parameters: enterpriseId, userId
  
  Optional parameters: none
  Generates a token (activation code) to allow this user to configure their managed account in the Android Setup Wizard. Revokes any previously generated token.
  
  This call only works with Google managed accounts."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth args]
  {:pre [(util/has-keys? args #{:enterpriseId :userId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/users/{userId}/token"
     #{:enterpriseId :userId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn generateAuthenticationToken$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/users/generateAuthenticationToken
  
  Required parameters: enterpriseId, userId
  
  Optional parameters: none
  Generates an authentication token which the device policy client can use to provision the given EMM-managed user account on a device. The generated token is single-use and expires after a few minutes.
  
  You can provision a maximum of 10 devices per user.
  
  This call only works with EMM-managed accounts."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth args]
  {:pre [(util/has-keys? args #{:enterpriseId :userId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/users/{userId}/authenticationToken"
     #{:enterpriseId :userId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/users/update
  
  Required parameters: enterpriseId, userId
  
  Optional parameters: none
  
  Body: 
  
  {:accountIdentifier string,
   :accountType string,
   :displayName string,
   :id string,
   :kind string,
   :managementType string,
   :primaryEmail string}
  
  Updates the details of an EMM-managed user.
  
  Can be used with EMM-managed users only (not Google managed users). Pass the new details in the Users resource in the request body. Only the displayName field can be changed. Other fields must either be unset or have the currently active value."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:enterpriseId :userId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/users/{userId}"
     #{:enterpriseId :userId}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/users/delete
  
  Required parameters: enterpriseId, userId
  
  Optional parameters: none
  Deleted an EMM-managed user."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth args]
  {:pre [(util/has-keys? args #{:enterpriseId :userId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/users/{userId}"
     #{:enterpriseId :userId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn revokeDeviceAccess$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/users/revokeDeviceAccess
  
  Required parameters: enterpriseId, userId
  
  Optional parameters: none
  Revokes access to all devices currently provisioned to the user. The user will no longer be able to use the managed Play store on any of their managed devices.
  
  This call only works with EMM-managed accounts."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth args]
  {:pre [(util/has-keys? args #{:enterpriseId :userId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/users/{userId}/deviceAccess"
     #{:enterpriseId :userId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/users/list
  
  Required parameters: email, enterpriseId
  
  Optional parameters: none
  Looks up a user by primary email address. This is only supported for Google-managed users. Lookup of the id is not needed for EMM-managed users because the id is already returned in the result of the Users.insert call."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth args]
  {:pre [(util/has-keys? args #{:email :enterpriseId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/users"
     #{:email :enterpriseId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn getAvailableProductSet$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/users/getAvailableProductSet
  
  Required parameters: enterpriseId, userId
  
  Optional parameters: none
  Retrieves the set of products a user is entitled to access."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth args]
  {:pre [(util/has-keys? args #{:enterpriseId :userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/users/{userId}/availableProductSet"
     #{:enterpriseId :userId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn revokeToken$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/users/revokeToken
  
  Required parameters: enterpriseId, userId
  
  Optional parameters: none
  Revokes a previously generated token (activation code) for the user."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth args]
  {:pre [(util/has-keys? args #{:enterpriseId :userId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/users/{userId}/token"
     #{:enterpriseId :userId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn setAvailableProductSet$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/users/setAvailableProductSet
  
  Required parameters: enterpriseId, userId
  
  Optional parameters: none
  
  Body: 
  
  {:kind string,
   :productId [string],
   :productSetBehavior string,
   :productVisibility [{:productId string,
                        :trackIds [string],
                        :tracks [string]}]}
  
  Modifies the set of products that a user is entitled to access (referred to as whitelisted products). Only products that are approved or products that were previously approved (products with revoked approval) can be whitelisted."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:enterpriseId :userId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/users/{userId}/availableProductSet"
     #{:enterpriseId :userId}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
