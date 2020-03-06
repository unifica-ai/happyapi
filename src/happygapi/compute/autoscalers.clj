(ns happygapi.compute.autoscalers
  "Compute Engine API: autoscalers.
  Creates and runs virtual machines on Google Cloud Platform.
  See: https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/autoscalers"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn aggregatedList$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/autoscalers/aggregatedList
  
  Required parameters: project
  
  Optional parameters: filter, maxResults, orderBy, pageToken
  Retrieves an aggregated list of autoscalers."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/aggregated/autoscalers"
     #{:project}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/autoscalers/delete
  
  Required parameters: autoscaler, project, zone
  
  Optional parameters: requestId
  Deletes the specified autoscaler."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth args]
  {:pre [(util/has-keys? args #{:zone :project :autoscaler})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/autoscalers/{autoscaler}"
     #{:zone :project :autoscaler}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/autoscalers/get
  
  Required parameters: autoscaler, project, zone
  
  Optional parameters: none
  Returns the specified autoscaler resource. Gets a list of available autoscalers by making a list() request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:zone :project :autoscaler})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/autoscalers/{autoscaler}"
     #{:zone :project :autoscaler}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/autoscalers/insert
  
  Required parameters: project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :statusDetails [{:message string, :type string}],
   :creationTimestamp string,
   :zone string,
   :name string,
   :selfLink string,
   :region string,
   :recommendedSize integer,
   :status string,
   :id string,
   :kind string,
   :autoscalingPolicy {:coolDownPeriodSec integer,
                       :cpuUtilization AutoscalingPolicyCpuUtilization,
                       :customMetricUtilizations [AutoscalingPolicyCustomMetricUtilization],
                       :loadBalancingUtilization AutoscalingPolicyLoadBalancingUtilization,
                       :maxNumReplicas integer,
                       :minNumReplicas integer,
                       :mode string},
   :target string}
  
  Creates an autoscaler in the specified project using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:zone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/autoscalers"
     #{:zone :project}
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

(defn list$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/autoscalers/list
  
  Required parameters: project, zone
  
  Optional parameters: filter, maxResults, orderBy, pageToken
  Retrieves a list of autoscalers contained within the specified zone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:zone :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/autoscalers"
     #{:zone :project}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/autoscalers/patch
  
  Required parameters: project, zone
  
  Optional parameters: autoscaler, requestId
  
  Body: 
  
  {:description string,
   :statusDetails [{:message string, :type string}],
   :creationTimestamp string,
   :zone string,
   :name string,
   :selfLink string,
   :region string,
   :recommendedSize integer,
   :status string,
   :id string,
   :kind string,
   :autoscalingPolicy {:coolDownPeriodSec integer,
                       :cpuUtilization AutoscalingPolicyCpuUtilization,
                       :customMetricUtilizations [AutoscalingPolicyCustomMetricUtilization],
                       :loadBalancingUtilization AutoscalingPolicyLoadBalancingUtilization,
                       :maxNumReplicas integer,
                       :minNumReplicas integer,
                       :mode string},
   :target string}
  
  Updates an autoscaler in the specified project using the data included in the request. This method supports PATCH semantics and uses the JSON merge patch format and processing rules."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:zone :project})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/autoscalers"
     #{:zone :project}
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

(defn update$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/autoscalers/update
  
  Required parameters: project, zone
  
  Optional parameters: autoscaler, requestId
  
  Body: 
  
  {:description string,
   :statusDetails [{:message string, :type string}],
   :creationTimestamp string,
   :zone string,
   :name string,
   :selfLink string,
   :region string,
   :recommendedSize integer,
   :status string,
   :id string,
   :kind string,
   :autoscalingPolicy {:coolDownPeriodSec integer,
                       :cpuUtilization AutoscalingPolicyCpuUtilization,
                       :customMetricUtilizations [AutoscalingPolicyCustomMetricUtilization],
                       :loadBalancingUtilization AutoscalingPolicyLoadBalancingUtilization,
                       :maxNumReplicas integer,
                       :minNumReplicas integer,
                       :mode string},
   :target string}
  
  Updates an autoscaler in the specified project using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:zone :project})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/autoscalers"
     #{:zone :project}
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
