(ns happygapi.remotebuildexecution.blobs
  "Remote Build Execution API: blobs.
  Supplies a Remote Execution API service for tools such as bazel.
  See: https://cloud.google.com/remote-build-execution/docs/api/reference/rest/v2/blobs"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn getTree$
  "https://cloud.google.com/remote-build-execution/docs/api/reference/rest/v2/blobs/getTree
  
  Required parameters: sizeBytes, instanceName, hash
  
  Optional parameters: pageToken, pageSize
  Fetch the entire directory tree rooted at a node.
  
  This request must be targeted at a
  Directory stored in the
  ContentAddressableStorage
  (CAS). The server will enumerate the `Directory` tree recursively and
  return every node descended from the root.
  
  The GetTreeRequest.page_token parameter can be used to skip ahead in
  the stream (e.g. when retrying a partially completed and aborted request),
  by setting it to a value taken from GetTreeResponse.next_page_token of the
  last successfully processed GetTreeResponse).
  
  The exact traversal order is unspecified and, unless retrieving subsequent
  pages from an earlier request, is not guaranteed to be stable across
  multiple invocations of `GetTree`.
  
  If part of the tree is missing from the CAS, the server will return the
  portion present and omit the rest.
  
  * `NOT_FOUND`: The requested tree root is not present in the CAS."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:hash :instanceName :sizeBytes})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://remotebuildexecution.googleapis.com/"
     "v2/{+instanceName}/blobs/{hash}/{sizeBytes}:getTree"
     #{:hash :instanceName :sizeBytes}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn findMissing$
  "https://cloud.google.com/remote-build-execution/docs/api/reference/rest/v2/blobs/findMissing
  
  Required parameters: instanceName
  
  Optional parameters: none
  
  Body: 
  
  {:blobDigests [{:hash string, :sizeBytes string}]}
  
  Determine if blobs are present in the CAS.
  
  Clients can use this API before uploading blobs to determine which ones are
  already present in the CAS and do not need to be uploaded again.
  
  There are no method-specific errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:instanceName})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://remotebuildexecution.googleapis.com/"
     "v2/{+instanceName}/blobs:findMissing"
     #{:instanceName}
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

(defn batchUpdate$
  "https://cloud.google.com/remote-build-execution/docs/api/reference/rest/v2/blobs/batchUpdate
  
  Required parameters: instanceName
  
  Optional parameters: none
  
  Body: 
  
  {:requests [{:data string, :digest BuildBazelRemoteExecutionV2Digest}]}
  
  Upload many blobs at once.
  
  The server may enforce a limit of the combined total size of blobs
  to be uploaded using this API. This limit may be obtained using the
  Capabilities API.
  Requests exceeding the limit should either be split into smaller
  chunks or uploaded using the
  ByteStream API, as appropriate.
  
  This request is equivalent to calling a Bytestream `Write` request
  on each individual blob, in parallel. The requests may succeed or fail
  independently.
  
  Errors:
  
  * `INVALID_ARGUMENT`: The client attempted to upload more than the
    server supported limit.
  
  Individual requests may return the following errors, additionally:
  
  * `RESOURCE_EXHAUSTED`: There is insufficient disk quota to store the blob.
  * `INVALID_ARGUMENT`: The
  Digest does not match the
  provided data."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:instanceName})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://remotebuildexecution.googleapis.com/"
     "v2/{+instanceName}/blobs:batchUpdate"
     #{:instanceName}
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

(defn batchRead$
  "https://cloud.google.com/remote-build-execution/docs/api/reference/rest/v2/blobs/batchRead
  
  Required parameters: instanceName
  
  Optional parameters: none
  
  Body: 
  
  {:digests [{:hash string, :sizeBytes string}]}
  
  Download many blobs at once.
  
  The server may enforce a limit of the combined total size of blobs
  to be downloaded using this API. This limit may be obtained using the
  Capabilities API.
  Requests exceeding the limit should either be split into smaller
  chunks or downloaded using the
  ByteStream API, as appropriate.
  
  This request is equivalent to calling a Bytestream `Read` request
  on each individual blob, in parallel. The requests may succeed or fail
  independently.
  
  Errors:
  
  * `INVALID_ARGUMENT`: The client attempted to read more than the
    server supported limit.
  
  Every error on individual read will be returned in the corresponding digest
  status."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:instanceName})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://remotebuildexecution.googleapis.com/"
     "v2/{+instanceName}/blobs:batchRead"
     #{:instanceName}
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
