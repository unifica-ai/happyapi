(ns happygapi.youtubeAnalytics.groupItems
  "YouTube Analytics API: groupItems.
  Retrieves your YouTube Analytics data.
  See: https://developers.google.com/youtube/analyticsapi/reference/rest/v2/groupItems"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/youtube/analyticsapi/reference/rest/v2/groupItems/delete
  
  Required parameters: none
  
  Optional parameters: onBehalfOfContentOwner, id
  Removes an item from a group."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.readonly"
            "https://www.googleapis.com/auth/youtubepartner"
            "https://www.googleapis.com/auth/yt-analytics-monetary.readonly"
            "https://www.googleapis.com/auth/yt-analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://youtubeanalytics.googleapis.com/"
     "v2/groupItems"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/youtube/analyticsapi/reference/rest/v2/groupItems/insert
  
  Required parameters: none
  
  Optional parameters: onBehalfOfContentOwner
  
  Body: 
  
  {:etag string,
   :resource {:kind string, :id string},
   :groupId string,
   :id string,
   :errors {:error [ErrorProto], :code string, :requestId string},
   :kind string}
  
  Creates a group item."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.readonly"
            "https://www.googleapis.com/auth/youtubepartner"
            "https://www.googleapis.com/auth/yt-analytics-monetary.readonly"
            "https://www.googleapis.com/auth/yt-analytics.readonly"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://youtubeanalytics.googleapis.com/"
     "v2/groupItems"
     #{}
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
  "https://developers.google.com/youtube/analyticsapi/reference/rest/v2/groupItems/list
  
  Required parameters: none
  
  Optional parameters: onBehalfOfContentOwner, groupId
  Returns a collection of group items that match the API request parameters."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.readonly"
            "https://www.googleapis.com/auth/youtubepartner"
            "https://www.googleapis.com/auth/yt-analytics-monetary.readonly"
            "https://www.googleapis.com/auth/yt-analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://youtubeanalytics.googleapis.com/"
     "v2/groupItems"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
