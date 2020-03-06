(ns happygapi.iamcredentials.projects
  "IAM Service Account Credentials API: projects.
  Creates short-lived, limited-privilege credentials for IAM service accounts.
  See: https://cloud.google.com/iam/docs/creating-short-lived-service-account-credentialsapi/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn serviceAccounts-signBlob$
  "https://cloud.google.com/iam/docs/creating-short-lived-service-account-credentialsapi/reference/rest/v1/projects/serviceAccounts/signBlob
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:payload string, :delegates [string]}
  
  Signs a blob using a service account's system-managed private key."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iamcredentials.googleapis.com/"
     "v1/{+name}:signBlob"
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

(defn serviceAccounts-signJwt$
  "https://cloud.google.com/iam/docs/creating-short-lived-service-account-credentialsapi/reference/rest/v1/projects/serviceAccounts/signJwt
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:payload string, :delegates [string]}
  
  Signs a JWT using a service account's system-managed private key."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iamcredentials.googleapis.com/"
     "v1/{+name}:signJwt"
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

(defn serviceAccounts-generateAccessToken$
  "https://cloud.google.com/iam/docs/creating-short-lived-service-account-credentialsapi/reference/rest/v1/projects/serviceAccounts/generateAccessToken
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:lifetime string, :scope [string], :delegates [string]}
  
  Generates an OAuth 2.0 access token for a service account."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iamcredentials.googleapis.com/"
     "v1/{+name}:generateAccessToken"
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

(defn serviceAccounts-generateIdToken$
  "https://cloud.google.com/iam/docs/creating-short-lived-service-account-credentialsapi/reference/rest/v1/projects/serviceAccounts/generateIdToken
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:audience string, :includeEmail boolean, :delegates [string]}
  
  Generates an OpenID Connect ID token for a service account."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iamcredentials.googleapis.com/"
     "v1/{+name}:generateIdToken"
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
