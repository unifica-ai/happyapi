(ns happygapi.youtube.videos
  "YouTube Data API
  Supports core YouTube features, such as uploading videos, creating and managing playlists, searching for content, and much more.
  See: https://developers.google.com/youtube/v3"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn delete$
  "Required parameters: id
  
  Deletes a YouTube video."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth args]
  {:pre [(util/has-keys? args #{"id"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "videos"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn getRating$
  "Required parameters: id
  
  Retrieves the ratings that the authorized user gave to a list of specified videos."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth args]
  {:pre [(util/has-keys? args #{"id"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "videos/getRating"
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
  "Required parameters: part
  
  Uploads a video to YouTube and optionally sets the video's metadata."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtube.upload"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"part"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "videos"
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

(defn list$
  "Required parameters: part
  
  Returns a list of videos that match the API request parameters."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtube.readonly"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth args]
  {:pre [(util/has-keys? args #{"part"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "videos"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn rate$
  "Required parameters: id,rating
  
  Add a like or dislike rating to a video or remove a rating from a video."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"id" "rating"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "videos/rate"
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

(defn reportAbuse$
  "Required parameters: none
  
  Report abuse for a video."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "videos/reportAbuse"
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

(defn update$
  "Required parameters: part
  
  Updates a video's metadata."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth args]
  {:pre [(util/has-keys? args #{"part"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "videos"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
