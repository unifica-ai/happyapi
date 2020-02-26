(ns happygapi.container.projects
  "Kubernetes Engine API
  Builds and manages container-based applications, powered by the open source Kubernetes technology.
  See: https://cloud.google.com/container-engine/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "container_schema.edn"))))

(defn locations-getServerConfig$
  "Required parameters: name
  
  Optional parameters: projectId, zone
  
  Returns configuration info about the Google Kubernetes Engine service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+name}/serverConfig"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-clusters-getJwks$
  "Required parameters: parent
  
  Optional parameters: none
  
  Gets the public component of the cluster signing keys in
  JSON Web Key format.
  This API is not yet intended for general use, and is not available for all
  clusters."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+parent}/jwks"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-clusters-updateMaster$
  "Required parameters: name
  
  Optional parameters: none
  
  Updates the master for a specific cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+name}:updateMaster"
     #{"name"}
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

(defn locations-clusters-get$
  "Required parameters: name
  
  Optional parameters: projectId, zone, clusterId
  
  Gets the details of a specific cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-clusters-setResourceLabels$
  "Required parameters: name
  
  Optional parameters: none
  
  Sets labels on a cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+name}:setResourceLabels"
     #{"name"}
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

(defn locations-clusters-create$
  "Required parameters: parent
  
  Optional parameters: none
  
  Creates a cluster, consisting of the specified number and type of Google
  Compute Engine instances.
  
  By default, the cluster is created in the project's
  [default network](/compute/docs/networks-and-firewalls#networks).
  
  One firewall is added for the cluster. After cluster creation,
  the Kubelet creates routes for each node to allow the containers
  on that node to communicate with all other instances in the
  cluster.
  
  Finally, an entry is added to the project's global metadata indicating
  which CIDR range the cluster is using."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+parent}/clusters"
     #{"parent"}
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

(defn locations-clusters-setAddons$
  "Required parameters: name
  
  Optional parameters: none
  
  Sets the addons for a specific cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+name}:setAddons"
     #{"name"}
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

(defn locations-clusters-update$
  "Required parameters: name
  
  Optional parameters: none
  
  Updates the settings of a specific cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+name}"
     #{"name"}
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

(defn locations-clusters-delete$
  "Required parameters: name
  
  Optional parameters: projectId, zone, clusterId
  
  Deletes the cluster, including the Kubernetes endpoint and all worker
  nodes.
  
  Firewalls and routes that were configured during cluster creation
  are also deleted.
  
  Other Google Compute Engine resources that might be in use by the cluster,
  such as load balancer resources, are not deleted if they weren't present
  when the cluster was initially created."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-clusters-setLogging$
  "Required parameters: name
  
  Optional parameters: none
  
  Sets the logging service for a specific cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+name}:setLogging"
     #{"name"}
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

(defn locations-clusters-setMasterAuth$
  "Required parameters: name
  
  Optional parameters: none
  
  Sets master auth materials. Currently supports changing the admin password
  or a specific cluster, either via password generation or explicitly setting
  the password."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+name}:setMasterAuth"
     #{"name"}
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

(defn locations-clusters-list$
  "Required parameters: parent
  
  Optional parameters: projectId, zone
  
  Lists all clusters owned by a project in either the specified zone or all
  zones."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+parent}/clusters"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-clusters-setNetworkPolicy$
  "Required parameters: name
  
  Optional parameters: none
  
  Enables or disables Network Policy for a cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+name}:setNetworkPolicy"
     #{"name"}
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

(defn locations-clusters-setMonitoring$
  "Required parameters: name
  
  Optional parameters: none
  
  Sets the monitoring service for a specific cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+name}:setMonitoring"
     #{"name"}
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

(defn locations-clusters-startIpRotation$
  "Required parameters: name
  
  Optional parameters: none
  
  Starts master IP rotation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+name}:startIpRotation"
     #{"name"}
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

(defn locations-clusters-completeIpRotation$
  "Required parameters: name
  
  Optional parameters: none
  
  Completes master IP rotation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+name}:completeIpRotation"
     #{"name"}
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

(defn locations-clusters-setLocations$
  "Required parameters: name
  
  Optional parameters: none
  
  Sets the locations for a specific cluster.
  Deprecated. Use
  [projects.locations.clusters.update](/kubernetes-engine/docs/reference/rest/v1/projects.locations.clusters.update)
  instead."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+name}:setLocations"
     #{"name"}
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

(defn locations-clusters-setLegacyAbac$
  "Required parameters: name
  
  Optional parameters: none
  
  Enables or disables the ABAC authorization mechanism on a cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+name}:setLegacyAbac"
     #{"name"}
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

(defn locations-clusters-setMaintenancePolicy$
  "Required parameters: name
  
  Optional parameters: none
  
  Sets the maintenance policy for a cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+name}:setMaintenancePolicy"
     #{"name"}
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

(defn locations-clusters-well-known-getOpenid-configuration$
  "Required parameters: parent
  
  Optional parameters: none
  
  Gets the OIDC discovery document for the cluster.
  See the
  [OpenID Connect Discovery 1.0
  specification](https://openid.net/specs/openid-connect-discovery-1_0.html)
  for details.
  This API is not yet intended for general use, and is not available for all
  clusters."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+parent}/.well-known/openid-configuration"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-clusters-nodePools-rollback$
  "Required parameters: name
  
  Optional parameters: none
  
  Rolls back a previously Aborted or Failed NodePool upgrade.
  This makes no changes if the last upgrade successfully completed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+name}:rollback"
     #{"name"}
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

(defn locations-clusters-nodePools-get$
  "Required parameters: name
  
  Optional parameters: projectId, zone, clusterId, nodePoolId
  
  Retrieves the requested node pool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-clusters-nodePools-create$
  "Required parameters: parent
  
  Optional parameters: none
  
  Creates a node pool for a cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+parent}/nodePools"
     #{"parent"}
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

(defn locations-clusters-nodePools-setAutoscaling$
  "Required parameters: name
  
  Optional parameters: none
  
  Sets the autoscaling settings for the specified node pool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+name}:setAutoscaling"
     #{"name"}
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

(defn locations-clusters-nodePools-setManagement$
  "Required parameters: name
  
  Optional parameters: none
  
  Sets the NodeManagement options for a node pool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+name}:setManagement"
     #{"name"}
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

(defn locations-clusters-nodePools-update$
  "Required parameters: name
  
  Optional parameters: none
  
  Updates the version and/or image type for the specified node pool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+name}"
     #{"name"}
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

(defn locations-clusters-nodePools-delete$
  "Required parameters: name
  
  Optional parameters: projectId, zone, clusterId, nodePoolId
  
  Deletes a node pool from a cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-clusters-nodePools-setSize$
  "Required parameters: name
  
  Optional parameters: none
  
  Sets the size for a specific node pool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+name}:setSize"
     #{"name"}
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

(defn locations-clusters-nodePools-list$
  "Required parameters: parent
  
  Optional parameters: projectId, zone, clusterId
  
  Lists the node pools for a cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+parent}/nodePools"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-operations-list$
  "Required parameters: parent
  
  Optional parameters: projectId, zone
  
  Lists all operations in a project in a specific zone or all zones."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+parent}/operations"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-operations-get$
  "Required parameters: name
  
  Optional parameters: operationId, projectId, zone
  
  Gets the specified operation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-operations-cancel$
  "Required parameters: name
  
  Optional parameters: none
  
  Cancels the specified operation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+name}:cancel"
     #{"name"}
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

(defn aggregated-usableSubnetworks-list$
  "Required parameters: parent
  
  Optional parameters: pageToken, pageSize, filter
  
  Lists subnetworks that are usable for creating clusters in a project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+parent}/aggregated/usableSubnetworks"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn zones-getServerconfig$
  "Required parameters: projectId, zone
  
  Optional parameters: name
  
  Returns configuration info about the Google Kubernetes Engine service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"zone" "projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/serverconfig"
     #{"zone" "projectId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn zones-clusters-monitoring$
  "Required parameters: projectId, zone, clusterId
  
  Optional parameters: none
  
  Sets the monitoring service for a specific cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"clusterId" "zone" "projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/monitoring"
     #{"clusterId" "zone" "projectId"}
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

(defn zones-clusters-get$
  "Required parameters: projectId, zone, clusterId
  
  Optional parameters: name
  
  Gets the details of a specific cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"clusterId" "zone" "projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}"
     #{"clusterId" "zone" "projectId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn zones-clusters-create$
  "Required parameters: projectId, zone
  
  Optional parameters: none
  
  Creates a cluster, consisting of the specified number and type of Google
  Compute Engine instances.
  
  By default, the cluster is created in the project's
  [default network](/compute/docs/networks-and-firewalls#networks).
  
  One firewall is added for the cluster. After cluster creation,
  the Kubelet creates routes for each node to allow the containers
  on that node to communicate with all other instances in the
  cluster.
  
  Finally, an entry is added to the project's global metadata indicating
  which CIDR range the cluster is using."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"zone" "projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters"
     #{"zone" "projectId"}
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

(defn zones-clusters-update$
  "Required parameters: projectId, zone, clusterId
  
  Optional parameters: none
  
  Updates the settings of a specific cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"clusterId" "zone" "projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}"
     #{"clusterId" "zone" "projectId"}
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

(defn zones-clusters-delete$
  "Required parameters: projectId, zone, clusterId
  
  Optional parameters: name
  
  Deletes the cluster, including the Kubernetes endpoint and all worker
  nodes.
  
  Firewalls and routes that were configured during cluster creation
  are also deleted.
  
  Other Google Compute Engine resources that might be in use by the cluster,
  such as load balancer resources, are not deleted if they weren't present
  when the cluster was initially created."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"clusterId" "zone" "projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}"
     #{"clusterId" "zone" "projectId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn zones-clusters-legacyAbac$
  "Required parameters: projectId, zone, clusterId
  
  Optional parameters: none
  
  Enables or disables the ABAC authorization mechanism on a cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"clusterId" "zone" "projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/legacyAbac"
     #{"clusterId" "zone" "projectId"}
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

(defn zones-clusters-locations$
  "Required parameters: clusterId, projectId, zone
  
  Optional parameters: none
  
  Sets the locations for a specific cluster.
  Deprecated. Use
  [projects.locations.clusters.update](/kubernetes-engine/docs/reference/rest/v1/projects.locations.clusters.update)
  instead."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"clusterId" "zone" "projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/locations"
     #{"clusterId" "zone" "projectId"}
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

(defn zones-clusters-logging$
  "Required parameters: projectId, zone, clusterId
  
  Optional parameters: none
  
  Sets the logging service for a specific cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"clusterId" "zone" "projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/logging"
     #{"clusterId" "zone" "projectId"}
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

(defn zones-clusters-resourceLabels$
  "Required parameters: projectId, zone, clusterId
  
  Optional parameters: none
  
  Sets labels on a cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"clusterId" "zone" "projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/resourceLabels"
     #{"clusterId" "zone" "projectId"}
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

(defn zones-clusters-setMasterAuth$
  "Required parameters: projectId, zone, clusterId
  
  Optional parameters: none
  
  Sets master auth materials. Currently supports changing the admin password
  or a specific cluster, either via password generation or explicitly setting
  the password."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"clusterId" "zone" "projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}:setMasterAuth"
     #{"clusterId" "zone" "projectId"}
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

(defn zones-clusters-list$
  "Required parameters: projectId, zone
  
  Optional parameters: parent
  
  Lists all clusters owned by a project in either the specified zone or all
  zones."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"zone" "projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters"
     #{"zone" "projectId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn zones-clusters-setNetworkPolicy$
  "Required parameters: projectId, zone, clusterId
  
  Optional parameters: none
  
  Enables or disables Network Policy for a cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"clusterId" "zone" "projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}:setNetworkPolicy"
     #{"clusterId" "zone" "projectId"}
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

(defn zones-clusters-addons$
  "Required parameters: projectId, zone, clusterId
  
  Optional parameters: none
  
  Sets the addons for a specific cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"clusterId" "zone" "projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/addons"
     #{"clusterId" "zone" "projectId"}
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

(defn zones-clusters-startIpRotation$
  "Required parameters: projectId, zone, clusterId
  
  Optional parameters: none
  
  Starts master IP rotation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"clusterId" "zone" "projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}:startIpRotation"
     #{"clusterId" "zone" "projectId"}
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

(defn zones-clusters-completeIpRotation$
  "Required parameters: projectId, zone, clusterId
  
  Optional parameters: none
  
  Completes master IP rotation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"clusterId" "zone" "projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}:completeIpRotation"
     #{"clusterId" "zone" "projectId"}
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

(defn zones-clusters-master$
  "Required parameters: clusterId, projectId, zone
  
  Optional parameters: none
  
  Updates the master for a specific cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"clusterId" "zone" "projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/master"
     #{"clusterId" "zone" "projectId"}
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

(defn zones-clusters-setMaintenancePolicy$
  "Required parameters: projectId, zone, clusterId
  
  Optional parameters: none
  
  Sets the maintenance policy for a cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"clusterId" "zone" "projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}:setMaintenancePolicy"
     #{"clusterId" "zone" "projectId"}
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

(defn zones-clusters-nodePools-rollback$
  "Required parameters: projectId, zone, clusterId, nodePoolId
  
  Optional parameters: none
  
  Rolls back a previously Aborted or Failed NodePool upgrade.
  This makes no changes if the last upgrade successfully completed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys?
          args
          #{"clusterId" "zone" "nodePoolId" "projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/nodePools/{nodePoolId}:rollback"
     #{"clusterId" "zone" "nodePoolId" "projectId"}
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

(defn zones-clusters-nodePools-get$
  "Required parameters: projectId, zone, clusterId, nodePoolId
  
  Optional parameters: name
  
  Retrieves the requested node pool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"clusterId" "zone" "nodePoolId" "projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/nodePools/{nodePoolId}"
     #{"clusterId" "zone" "nodePoolId" "projectId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn zones-clusters-nodePools-autoscaling$
  "Required parameters: projectId, zone, clusterId, nodePoolId
  
  Optional parameters: none
  
  Sets the autoscaling settings for the specified node pool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys?
          args
          #{"clusterId" "zone" "nodePoolId" "projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/nodePools/{nodePoolId}/autoscaling"
     #{"clusterId" "zone" "nodePoolId" "projectId"}
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

(defn zones-clusters-nodePools-create$
  "Required parameters: projectId, zone, clusterId
  
  Optional parameters: none
  
  Creates a node pool for a cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"clusterId" "zone" "projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/nodePools"
     #{"clusterId" "zone" "projectId"}
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

(defn zones-clusters-nodePools-setManagement$
  "Required parameters: projectId, zone, clusterId, nodePoolId
  
  Optional parameters: none
  
  Sets the NodeManagement options for a node pool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys?
          args
          #{"clusterId" "zone" "nodePoolId" "projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/nodePools/{nodePoolId}/setManagement"
     #{"clusterId" "zone" "nodePoolId" "projectId"}
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

(defn zones-clusters-nodePools-update$
  "Required parameters: projectId, zone, clusterId, nodePoolId
  
  Optional parameters: none
  
  Updates the version and/or image type for the specified node pool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys?
          args
          #{"clusterId" "zone" "nodePoolId" "projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/nodePools/{nodePoolId}/update"
     #{"clusterId" "zone" "nodePoolId" "projectId"}
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

(defn zones-clusters-nodePools-delete$
  "Required parameters: clusterId, nodePoolId, projectId, zone
  
  Optional parameters: name
  
  Deletes a node pool from a cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"clusterId" "zone" "nodePoolId" "projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/nodePools/{nodePoolId}"
     #{"clusterId" "zone" "nodePoolId" "projectId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn zones-clusters-nodePools-setSize$
  "Required parameters: projectId, zone, clusterId, nodePoolId
  
  Optional parameters: none
  
  Sets the size for a specific node pool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys?
          args
          #{"clusterId" "zone" "nodePoolId" "projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/nodePools/{nodePoolId}/setSize"
     #{"clusterId" "zone" "nodePoolId" "projectId"}
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

(defn zones-clusters-nodePools-list$
  "Required parameters: projectId, zone, clusterId
  
  Optional parameters: parent
  
  Lists the node pools for a cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"clusterId" "zone" "projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/nodePools"
     #{"clusterId" "zone" "projectId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn zones-operations-cancel$
  "Required parameters: operationId, projectId, zone
  
  Optional parameters: none
  
  Cancels the specified operation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"operationId" "zone" "projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/operations/{operationId}:cancel"
     #{"operationId" "zone" "projectId"}
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

(defn zones-operations-list$
  "Required parameters: projectId, zone
  
  Optional parameters: parent
  
  Lists all operations in a project in a specific zone or all zones."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"zone" "projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/operations"
     #{"zone" "projectId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn zones-operations-get$
  "Required parameters: projectId, zone, operationId
  
  Optional parameters: name
  
  Gets the specified operation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"operationId" "zone" "projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/operations/{operationId}"
     #{"operationId" "zone" "projectId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
