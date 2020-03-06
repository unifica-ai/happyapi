(ns happygapi.networkmanagement.projects
  "Network Management API: projects.
  The Network Management API provides a collection of network performance monitoring and diagnostic capabilities.
  See: https://cloud.google.com/api/reference/rest/v1beta1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: pageToken, pageSize, filter
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkmanagement.googleapis.com/"
     "v1beta1/{+name}/locations"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-get$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkmanagement.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-global-operations-cancel$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/global/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Starts asynchronous cancellation on a long-running operation.  The server
  makes a best effort to cancel the operation, but success is not
  guaranteed.  If the server doesn't support this method, it returns
  `google.rpc.Code.UNIMPLEMENTED`.  Clients can use
  Operations.GetOperation or
  other methods to check whether the cancellation succeeded or whether the
  operation completed despite cancellation. On successful cancellation,
  the operation is not deleted; instead, it becomes an operation with
  an Operation.error value with a google.rpc.Status.code of 1,
  corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networkmanagement.googleapis.com/"
     "v1beta1/{+name}:cancel"
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

(defn locations-global-operations-delete$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/global/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  Deletes a long-running operation. This method indicates that the client is
  no longer interested in the operation result. It does not cancel the
  operation. If the server doesn't support this method, it returns
  `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://networkmanagement.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-global-operations-list$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/global/operations/list
  
  Required parameters: name
  
  Optional parameters: pageToken, pageSize, filter
  Lists operations that match the specified filter in the request. If the
  server doesn't support this method, it returns `UNIMPLEMENTED`.
  
  NOTE: the `name` binding allows API services to override the binding
  to use different resource name schemes, such as `users/*/operations`. To
  override the binding, API services can add a binding such as
  `\"/v1/{name=users/*}/operations\"` to their service configuration.
  For backwards compatibility, the default name includes the operations
  collection id, however overriding users must ensure the name binding
  is the parent resource, without the operations collection id."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkmanagement.googleapis.com/"
     "v1beta1/{+name}/operations"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-global-operations-get$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/global/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  Gets the latest state of a long-running operation.  Clients can use this
  method to poll the operation result at intervals as recommended by the API
  service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkmanagement.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-global-connectivityTests-get$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/global/connectivityTests/get
  
  Required parameters: name
  
  Optional parameters: none
  Gets the details of a specific Connectivity Test."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkmanagement.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-global-connectivityTests-setIamPolicy$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/global/connectivityTests/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:bindings [Binding],
            :etag string,
            :version integer,
            :auditConfigs [AuditConfig]},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any
  existing policy.
  
  Can return Public Errors: NOT_FOUND, INVALID_ARGUMENT and PERMISSION_DENIED"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networkmanagement.googleapis.com/"
     "v1beta1/{+resource}:setIamPolicy"
     #{:resource}
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

(defn locations-global-connectivityTests-patch$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/global/connectivityTests/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :labels {},
   :protocol string,
   :displayName string,
   :name string,
   :createTime string,
   :relatedProjects [string],
   :source {:port integer,
            :network string,
            :networkType string,
            :ipAddress string,
            :instance string,
            :projectId string},
   :updateTime string,
   :reachabilityDetails {:traces [Trace],
                         :result string,
                         :error Status,
                         :verifyTime string},
   :destination {:port integer,
                 :network string,
                 :networkType string,
                 :ipAddress string,
                 :instance string,
                 :projectId string}}
  
  Updates the configuration of an existing `ConnectivityTest`.
  After you update a test, the reachability analysis is performed as part
  of the long running operation, which completes when the analysis completes.
  The Reachability state in the test resource is updated with the new result.
  
  If the endpoint specifications in `ConnectivityTest` are invalid
  (for example, they contain non-existent resources in the network, or the
  user does not have read permissions to the network configurations of
  listed projects), then the reachability result returns a value of
  <code>UNKNOWN</code>.
  
  If the endpoint specifications in `ConnectivityTest` are incomplete, the
  reachability result returns a value of `AMBIGUOUS`. See the documentation
  in `ConnectivityTest` for for more details."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://networkmanagement.googleapis.com/"
     "v1beta1/{+name}"
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

(defn locations-global-connectivityTests-testIamPermissions$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/global/connectivityTests/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource.
  If the resource does not exist, this will return an empty set of
  permissions, not a NOT_FOUND error.
  
  Note: This operation is designed to be used for building permission-aware
  UIs and command-line tools, not for authorization checking. This operation
  may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networkmanagement.googleapis.com/"
     "v1beta1/{+resource}:testIamPermissions"
     #{:resource}
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

(defn locations-global-connectivityTests-create$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/global/connectivityTests/create
  
  Required parameters: parent
  
  Optional parameters: testId
  
  Body: 
  
  {:description string,
   :labels {},
   :protocol string,
   :displayName string,
   :name string,
   :createTime string,
   :relatedProjects [string],
   :source {:port integer,
            :network string,
            :networkType string,
            :ipAddress string,
            :instance string,
            :projectId string},
   :updateTime string,
   :reachabilityDetails {:traces [Trace],
                         :result string,
                         :error Status,
                         :verifyTime string},
   :destination {:port integer,
                 :network string,
                 :networkType string,
                 :ipAddress string,
                 :instance string,
                 :projectId string}}
  
  Creates a new Connectivity Test.
  After you create a test, the reachability analysis is performed as part
  of the long running operation, which completes when the analysis completes.
  
  If the endpoint specifications in `ConnectivityTest` are invalid
  (for example, containing non-existent resources in the network, or you
  don't have read permissions to the network configurations of listed
  projects), then the reachability result returns a value of `UNKNOWN`.
  
  If the endpoint specifications in `ConnectivityTest` are
  incomplete, the reachability result returns a value of
  <code>AMBIGUOUS</code>. For more information,
  see the Connectivity Test documentation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networkmanagement.googleapis.com/"
     "v1beta1/{+parent}/connectivityTests"
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

(defn locations-global-connectivityTests-delete$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/global/connectivityTests/delete
  
  Required parameters: name
  
  Optional parameters: none
  Deletes a specific `ConnectivityTest`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://networkmanagement.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-global-connectivityTests-getIamPolicy$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/global/connectivityTests/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  Gets the access control policy for a resource.
  Returns an empty policy if the resource exists and does not have a policy
  set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkmanagement.googleapis.com/"
     "v1beta1/{+resource}:getIamPolicy"
     #{:resource}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-global-connectivityTests-list$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/global/connectivityTests/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageToken, orderBy, pageSize
  Lists all Connectivity Tests owned by a project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkmanagement.googleapis.com/"
     "v1beta1/{+parent}/connectivityTests"
     #{:parent}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-global-connectivityTests-rerun$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/global/connectivityTests/rerun
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Rerun an existing `ConnectivityTest`.
  After the user triggers the rerun, the reachability analysis is performed
  as part of the long running operation, which completes when the analysis
  completes.
  
  Even though the test configuration remains the same, the reachability
  result may change due to underlying network configuration changes.
  
  If the endpoint specifications in `ConnectivityTest` become invalid (for
  example, specified resources are deleted in the network, or you lost
  read permissions to the network configurations of listed projects), then
  the reachability result returns a value of `UNKNOWN`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networkmanagement.googleapis.com/"
     "v1beta1/{+name}:rerun"
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
