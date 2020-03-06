(ns happygapi.domainsrdap.domain
  "Domains RDAP API: domain.
  Read-only public API that lets users search for information about domain names.
  See: https://developers.google.com/domains/rdap/api/reference/rest/v1/domain"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/domains/rdap/api/reference/rest/v1/domain/get
  
  Required parameters: domainName
  
  Optional parameters: none
  Look up RDAP information for a domain by name."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{:domainName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://domainsrdap.googleapis.com/"
     "v1/domain/{+domainName}"
     #{:domainName}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
