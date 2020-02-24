(ns happygapi.safebrowsing.encodedFullHashes
  "Safe Browsing API
  Enables client applications to check web resources (most commonly URLs) against Google-generated lists of unsafe web resources. The Safe Browsing APIs are for non-commercial use only. If you need to use APIs to detect malicious URLs for commercial purposes – meaning “for sale or revenue-generating purposes” – please refer to the Web Risk API.
  See: https://developers.google.com/safe-browsing/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn get$
  "Required parameters: encodedRequest
  
  "
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{"encodedRequest"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://safebrowsing.googleapis.com/"
     "v4/encodedFullHashes/{encodedRequest}"
     #{"encodedRequest"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
