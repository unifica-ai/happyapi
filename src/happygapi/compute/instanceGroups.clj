(ns happygapi.compute.instanceGroups
  "Compute Engine API
  Creates and runs virtual machines on Google Cloud Platform.
  See: https://developers.google.com/compute/docs/reference/latest/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn get$
  "Required parameters: instanceGroup,project,zone
  
  Returns the specified instance group. Gets a list of available instance groups by making a list() request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"project" "zone" "instanceGroup"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instanceGroups/{instanceGroup}"
     #{"project" "zone" "instanceGroup"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "Required parameters: project,zone
  
  Creates an instance group in the specified project using the parameters that are included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"project" "zone"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instanceGroups"
     #{"project" "zone"}
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

(defn addInstances$
  "Required parameters: instanceGroup,project,zone
  
  Adds a list of instances to the specified instance group. All of the instances in the instance group must be in the same network/subnetwork. Read  Adding instances for more information."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"project" "zone" "instanceGroup"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instanceGroups/{instanceGroup}/addInstances"
     #{"project" "zone" "instanceGroup"}
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

(defn aggregatedList$
  "Required parameters: project
  
  Retrieves the list of instance groups and sorts them by zone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"project"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/aggregated/instanceGroups"
     #{"project"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "Required parameters: instanceGroup,project,zone
  
  Deletes the specified instance group. The instances in the group are not deleted. Note that instance group must not belong to a backend service. Read  Deleting an instance group for more information."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth args]
  {:pre [(util/has-keys? args #{"project" "zone" "instanceGroup"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instanceGroups/{instanceGroup}"
     #{"project" "zone" "instanceGroup"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn setNamedPorts$
  "Required parameters: instanceGroup,project,zone
  
  Sets the named ports for the specified instance group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"project" "zone" "instanceGroup"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instanceGroups/{instanceGroup}/setNamedPorts"
     #{"project" "zone" "instanceGroup"}
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
  "Required parameters: project,zone
  
  Retrieves the list of instance groups that are located in the specified project and zone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"project" "zone"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instanceGroups"
     #{"project" "zone"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn listInstances$
  "Required parameters: instanceGroup,project,zone
  
  Lists the instances in the specified instance group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"project" "zone" "instanceGroup"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instanceGroups/{instanceGroup}/listInstances"
     #{"project" "zone" "instanceGroup"}
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

(defn removeInstances$
  "Required parameters: instanceGroup,project,zone
  
  Removes one or more instances from the specified instance group, but does not delete those instances.
  
  If the group is part of a backend service that has enabled connection draining, it can take up to 60 seconds after the connection draining duration before the VM instance is removed or deleted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"project" "zone" "instanceGroup"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instanceGroups/{instanceGroup}/removeInstances"
     #{"project" "zone" "instanceGroup"}
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
