(ns happygapi.cloudbuild.projects
  "Cloud Build API: projects.
  Creates and manages builds on Google Cloud Platform.
  See: https://cloud.google.com/cloud-build/docs/api/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn builds-get$
  "https://cloud.google.com/cloud-build/docs/api/reference/rest/v1/projects/builds/get
  
  Required parameters: projectId, id
  
  Optional parameters: none
  Returns information about a previously requested build.
  
  The `Build` that is returned includes its status (such as `SUCCESS`,
  `FAILURE`, or `WORKING`), and timing information."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:id :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v1/projects/{projectId}/builds/{id}"
     #{:id :projectId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn builds-list$
  "https://cloud.google.com/cloud-build/docs/api/reference/rest/v1/projects/builds/list
  
  Required parameters: projectId
  
  Optional parameters: pageToken, pageSize, filter
  Lists previously requested builds.
  
  Previously requested builds may still be in-progress, or may have finished
  successfully or unsuccessfully."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v1/projects/{projectId}/builds"
     #{:projectId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn builds-create$
  "https://cloud.google.com/cloud-build/docs/api/reference/rest/v1/projects/builds/create
  
  Required parameters: projectId
  
  Optional parameters: none
  
  Body: 
  
  {:tags [string],
   :statusDetail string,
   :logsBucket string,
   :startTime string,
   :buildTriggerId string,
   :images [string],
   :secrets [{:kmsKeyName string, :secretEnv {}}],
   :steps [{:args [string],
            :waitFor [string],
            :dir string,
            :name string,
            :pullTiming TimeSpan,
            :env [string],
            :volumes [Volume],
            :status string,
            :id string,
            :secretEnv [string],
            :timing TimeSpan,
            :entrypoint string,
            :timeout string}],
   :createTime string,
   :substitutions {},
   :source {:storageSource StorageSource, :repoSource RepoSource},
   :logUrl string,
   :finishTime string,
   :status string,
   :id string,
   :timing {},
   :sourceProvenance {:fileHashes {},
                      :resolvedRepoSource RepoSource,
                      :resolvedStorageSource StorageSource},
   :projectId string,
   :options {:sourceProvenanceHash [string],
             :machineType string,
             :env [string],
             :volumes [Volume],
             :logging string,
             :secretEnv [string],
             :diskSizeGb string,
             :logStreamingOption string,
             :workerPool string,
             :substitutionOption string,
             :requestedVerifyOption string},
   :timeout string,
   :artifacts {:images [string], :objects ArtifactObjects},
   :results {:artifactTiming TimeSpan,
             :buildStepOutputs [string],
             :images [BuiltImage],
             :numArtifacts string,
             :artifactManifest string,
             :buildStepImages [string]}}
  
  Starts a build with the specified configuration.
  
  This method returns a long-running `Operation`, which includes the build
  ID. Pass the build ID to `GetBuild` to determine the build status (such as
  `SUCCESS` or `FAILURE`)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v1/projects/{projectId}/builds"
     #{:projectId}
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

(defn builds-cancel$
  "https://cloud.google.com/cloud-build/docs/api/reference/rest/v1/projects/builds/cancel
  
  Required parameters: projectId, id
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Cancels a build in progress."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:id :projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v1/projects/{projectId}/builds/{id}:cancel"
     #{:id :projectId}
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

(defn builds-retry$
  "https://cloud.google.com/cloud-build/docs/api/reference/rest/v1/projects/builds/retry
  
  Required parameters: projectId, id
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Creates a new build based on the specified build.
  
  This method creates a new build using the original build request, which may
  or may not result in an identical build.
  
  For triggered builds:
  
  * Triggered builds resolve to a precise revision; therefore a retry of a
  triggered build will result in a build that uses the same revision.
  
  For non-triggered builds that specify `RepoSource`:
  
  * If the original build built from the tip of a branch, the retried build
  will build from the tip of that branch, which may not be the same revision
  as the original build.
  * If the original build specified a commit sha or revision ID, the retried
  build will use the identical source.
  
  For builds that specify `StorageSource`:
  
  * If the original build pulled source from Google Cloud Storage without
  specifying the generation of the object, the new build will use the current
  object, which may be different from the original build source.
  * If the original build pulled source from Cloud Storage and specified the
  generation of the object, the new build will attempt to use the same
  object, which may or may not be available depending on the bucket's
  lifecycle management settings."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:id :projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v1/projects/{projectId}/builds/{id}:retry"
     #{:id :projectId}
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

(defn triggers-delete$
  "https://cloud.google.com/cloud-build/docs/api/reference/rest/v1/projects/triggers/delete
  
  Required parameters: projectId, triggerId
  
  Optional parameters: none
  Deletes a `BuildTrigger` by its project ID and trigger ID.
  
  This API is experimental."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:triggerId :projectId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v1/projects/{projectId}/triggers/{triggerId}"
     #{:triggerId :projectId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn triggers-list$
  "https://cloud.google.com/cloud-build/docs/api/reference/rest/v1/projects/triggers/list
  
  Required parameters: projectId
  
  Optional parameters: pageToken, pageSize
  Lists existing `BuildTrigger`s.
  
  This API is experimental."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v1/projects/{projectId}/triggers"
     #{:projectId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn triggers-create$
  "https://cloud.google.com/cloud-build/docs/api/reference/rest/v1/projects/triggers/create
  
  Required parameters: projectId
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :tags [string],
   :github {:pullRequest PullRequestFilter,
            :push PushFilter,
            :installationId string,
            :owner string,
            :name string},
   :disabled boolean,
   :name string,
   :createTime string,
   :ignoredFiles [string],
   :substitutions {},
   :includedFiles [string],
   :filename string,
   :build {:tags [string],
           :statusDetail string,
           :logsBucket string,
           :startTime string,
           :buildTriggerId string,
           :images [string],
           :secrets [Secret],
           :steps [BuildStep],
           :createTime string,
           :substitutions {},
           :source Source,
           :logUrl string,
           :finishTime string,
           :status string,
           :id string,
           :timing {},
           :sourceProvenance SourceProvenance,
           :projectId string,
           :options BuildOptions,
           :timeout string,
           :artifacts Artifacts,
           :results Results},
   :id string,
   :triggerTemplate {:tagName string,
                     :projectId string,
                     :repoName string,
                     :commitSha string,
                     :substitutions {},
                     :branchName string,
                     :dir string}}
  
  Creates a new `BuildTrigger`.
  
  This API is experimental."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v1/projects/{projectId}/triggers"
     #{:projectId}
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

(defn triggers-run$
  "https://cloud.google.com/cloud-build/docs/api/reference/rest/v1/projects/triggers/run
  
  Required parameters: triggerId, projectId
  
  Optional parameters: none
  
  Body: 
  
  {:tagName string,
   :projectId string,
   :repoName string,
   :commitSha string,
   :substitutions {},
   :branchName string,
   :dir string}
  
  Runs a `BuildTrigger` at a particular source revision."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:triggerId :projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v1/projects/{projectId}/triggers/{triggerId}:run"
     #{:triggerId :projectId}
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

(defn triggers-patch$
  "https://cloud.google.com/cloud-build/docs/api/reference/rest/v1/projects/triggers/patch
  
  Required parameters: triggerId, projectId
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :tags [string],
   :github {:pullRequest PullRequestFilter,
            :push PushFilter,
            :installationId string,
            :owner string,
            :name string},
   :disabled boolean,
   :name string,
   :createTime string,
   :ignoredFiles [string],
   :substitutions {},
   :includedFiles [string],
   :filename string,
   :build {:tags [string],
           :statusDetail string,
           :logsBucket string,
           :startTime string,
           :buildTriggerId string,
           :images [string],
           :secrets [Secret],
           :steps [BuildStep],
           :createTime string,
           :substitutions {},
           :source Source,
           :logUrl string,
           :finishTime string,
           :status string,
           :id string,
           :timing {},
           :sourceProvenance SourceProvenance,
           :projectId string,
           :options BuildOptions,
           :timeout string,
           :artifacts Artifacts,
           :results Results},
   :id string,
   :triggerTemplate {:tagName string,
                     :projectId string,
                     :repoName string,
                     :commitSha string,
                     :substitutions {},
                     :branchName string,
                     :dir string}}
  
  Updates a `BuildTrigger` by its project ID and trigger ID.
  
  This API is experimental."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:triggerId :projectId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v1/projects/{projectId}/triggers/{triggerId}"
     #{:triggerId :projectId}
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

(defn triggers-get$
  "https://cloud.google.com/cloud-build/docs/api/reference/rest/v1/projects/triggers/get
  
  Required parameters: triggerId, projectId
  
  Optional parameters: none
  Returns information about a `BuildTrigger`.
  
  This API is experimental."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:triggerId :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v1/projects/{projectId}/triggers/{triggerId}"
     #{:triggerId :projectId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
