(ns happygapi.compute.licenses
  "Compute Engine API
  Creates and runs virtual machines on Google Cloud Platform.
  See: https://developers.google.com/compute/docs/reference/latest/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn delete$
  "Required parameters: license,project
  
  Deletes the specified license."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth args]
  {:pre [(util/has-keys? args #{"license" "project"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/licenses/{license}"
     #{"license" "project"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "Required parameters: license,project
  
  Returns the specified License resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"license" "project"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/licenses/{license}"
     #{"license" "project"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn getIamPolicy$
  "Required parameters: project,resource
  
  Gets the access control policy for a resource. May be empty if no such policy or resource exists."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"resource" "project"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/licenses/{resource}/getIamPolicy"
     #{"resource" "project"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "Required parameters: project
  
  Create a License resource in the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_only"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"project"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/licenses"
     #{"project"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn list$
  "Required parameters: project
  
  Retrieves the list of licenses available in the specified project. This method does not get any licenses that belong to other projects, including licenses attached to publicly-available images, like Debian 9. If you want to get a list of publicly-available licenses, use this method to make a request to the respective image project, such as debian-cloud or windows-cloud."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"project"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/licenses"
     #{"project"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn setIamPolicy$
  "Required parameters: project,resource
  
  Sets the access control policy on the specified resource. Replaces any existing policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource" "project"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/licenses/{resource}/setIamPolicy"
     #{"resource" "project"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn testIamPermissions$
  "Required parameters: project,resource
  
  Returns permissions that a caller has on the specified resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource" "project"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/licenses/{resource}/testIamPermissions"
     #{"resource" "project"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))
