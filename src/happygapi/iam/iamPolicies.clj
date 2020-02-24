(ns happygapi.iam.iamPolicies
  "Identity and Access Management (IAM) API
  Manages identity and access control for Google Cloud Platform resources, including the creation of service accounts, which you can use to authenticate to Google and make API calls.
  See: https://cloud.google.com/iam/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn lintPolicy$
  "Required parameters: none
  
  Lints a Cloud IAM policy object or its sub fields. Currently supports
  google.iam.v1.Binding.condition.
  
  Each lint operation consists of multiple lint validation units.
  Each unit inspects the input object in regard to a particular linting
  aspect and issues a google.iam.admin.v1.LintResult disclosing the
  result.
  
  The set of applicable validation units is determined by the Cloud IAM
  server and is not configurable.
  
  Regardless of any lint issues or their severities, successful calls to
  `lintPolicy` return an HTTP 200 OK status code."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/iamPolicies:lintPolicy"
     #{}
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

(defn queryAuditableServices$
  "Required parameters: none
  
  Returns a list of services that support service level audit logging
  configuration for the given resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/iamPolicies:queryAuditableServices"
     #{}
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
