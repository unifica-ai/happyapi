(ns happygapi.billingbudgets.billingAccounts
  "Cloud Billing Budget API: billingAccounts.
  The Cloud Billing Budget API stores Cloud Billing budgets, which define a budget plan and the rules to execute as spend is tracked against that plan.
  See: https://cloud.google.com/billing/docs/how-to/budget-api-overviewapi/reference/rest/v1beta1/billingAccounts"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn budgets-delete$
  "https://cloud.google.com/billing/docs/how-to/budget-api-overviewapi/reference/rest/v1beta1/billingAccounts/budgets/delete
  
  Required parameters: name
  
  Optional parameters: none
  Deletes a budget. Returns successfully if already deleted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://billingbudgets.googleapis.com/"
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

(defn budgets-patch$
  "https://cloud.google.com/billing/docs/how-to/budget-api-overviewapi/reference/rest/v1beta1/billingAccounts/budgets/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:updateMask string,
   :budget {:allUpdatesRule GoogleCloudBillingBudgetsV1beta1AllUpdatesRule,
            :displayName string,
            :etag string,
            :thresholdRules [GoogleCloudBillingBudgetsV1beta1ThresholdRule],
            :name string,
            :amount GoogleCloudBillingBudgetsV1beta1BudgetAmount,
            :budgetFilter GoogleCloudBillingBudgetsV1beta1Filter}}
  
  Updates a budget and returns the updated budget.
  
  WARNING: There are some fields exposed on the Google Cloud Console that
  aren’t available on this API. Budget fields that are not exposed in
  this API will not be changed by this method."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://billingbudgets.googleapis.com/"
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

(defn budgets-get$
  "https://cloud.google.com/billing/docs/how-to/budget-api-overviewapi/reference/rest/v1beta1/billingAccounts/budgets/get
  
  Required parameters: name
  
  Optional parameters: none
  Returns a budget.
  
  WARNING: There are some fields exposed on the Google Cloud Console that
  aren’t available on this API. When reading from the API, you will not
  see these fields in the return value, though they may have been set
  in the cloud console."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://billingbudgets.googleapis.com/"
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

(defn budgets-list$
  "https://cloud.google.com/billing/docs/how-to/budget-api-overviewapi/reference/rest/v1beta1/billingAccounts/budgets/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  Returns a list of budgets for a billing account.
  
  WARNING: There are some fields exposed on the Google Cloud Console that
  aren’t available on this API. When reading from the API, you will not
  see these fields in the return value, though they may have been set
  in the cloud console."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://billingbudgets.googleapis.com/"
     "v1beta1/{+parent}/budgets"
     #{:parent}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn budgets-create$
  "https://cloud.google.com/billing/docs/how-to/budget-api-overviewapi/reference/rest/v1beta1/billingAccounts/budgets/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:budget {:allUpdatesRule GoogleCloudBillingBudgetsV1beta1AllUpdatesRule,
            :displayName string,
            :etag string,
            :thresholdRules [GoogleCloudBillingBudgetsV1beta1ThresholdRule],
            :name string,
            :amount GoogleCloudBillingBudgetsV1beta1BudgetAmount,
            :budgetFilter GoogleCloudBillingBudgetsV1beta1Filter}}
  
  Creates a new budget. See
  <a href=\"https://cloud.google.com/billing/quotas\">Quotas and limits</a>
  for more information on the limits of the number of budgets you can create."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://billingbudgets.googleapis.com/"
     "v1beta1/{+parent}/budgets"
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
