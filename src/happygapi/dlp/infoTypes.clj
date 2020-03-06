(ns happygapi.dlp.infoTypes
  "Cloud Data Loss Prevention (DLP) API: infoTypes.
  Provides methods for detection, risk analysis, and de-identification of privacy-sensitive fragments in text, images, and Google Cloud Platform storage repositories.
  See: https://cloud.google.com/dlp/docs/api/reference/rest/v2/infoTypes"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/infoTypes/list
  
  Required parameters: none
  
  Optional parameters: languageCode, filter, locationId
  Returns a list of the sensitive information types that the DLP API
  supports. See https://cloud.google.com/dlp/docs/infotypes-reference to
  learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/infoTypes"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
