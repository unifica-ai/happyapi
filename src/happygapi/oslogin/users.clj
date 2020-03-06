(ns happygapi.oslogin.users
  "Cloud OS Login API: users.
  You can use OS Login to manage access to your VM instances using IAM roles.
  See: https://cloud.google.com/compute/docs/oslogin/api/reference/rest/v1/users"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn importSshPublicKey$
  "https://cloud.google.com/compute/docs/oslogin/api/reference/rest/v1/users/importSshPublicKey
  
  Required parameters: parent
  
  Optional parameters: projectId
  
  Body: 
  
  {:key string,
   :name string,
   :expirationTimeUsec string,
   :fingerprint string}
  
  Adds an SSH public key and returns the profile information. Default POSIX
  account information is set when no username and UID exist as part of the
  login profile."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://oslogin.googleapis.com/"
     "v1/{+parent}:importSshPublicKey"
     #{:parent}
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

(defn getLoginProfile$
  "https://cloud.google.com/compute/docs/oslogin/api/reference/rest/v1/users/getLoginProfile
  
  Required parameters: name
  
  Optional parameters: projectId, systemId
  Retrieves the profile information used for logging in to a virtual machine
  on Google Compute Engine."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://oslogin.googleapis.com/"
     "v1/{+name}/loginProfile"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn sshPublicKeys-delete$
  "https://cloud.google.com/compute/docs/oslogin/api/reference/rest/v1/users/sshPublicKeys/delete
  
  Required parameters: name
  
  Optional parameters: none
  Deletes an SSH public key."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://oslogin.googleapis.com/"
     "v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn sshPublicKeys-get$
  "https://cloud.google.com/compute/docs/oslogin/api/reference/rest/v1/users/sshPublicKeys/get
  
  Required parameters: name
  
  Optional parameters: none
  Retrieves an SSH public key."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://oslogin.googleapis.com/"
     "v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn sshPublicKeys-patch$
  "https://cloud.google.com/compute/docs/oslogin/api/reference/rest/v1/users/sshPublicKeys/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:key string,
   :name string,
   :expirationTimeUsec string,
   :fingerprint string}
  
  Updates an SSH public key and returns the profile information. This method
  supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://oslogin.googleapis.com/"
     "v1/{+name}"
     #{:name}
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

(defn projects-delete$
  "https://cloud.google.com/compute/docs/oslogin/api/reference/rest/v1/users/projects/delete
  
  Required parameters: name
  
  Optional parameters: none
  Deletes a POSIX account."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://oslogin.googleapis.com/"
     "v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
