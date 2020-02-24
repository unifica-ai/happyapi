(ns happygapi.blogger.pages
  "Blogger API
  API for access to the data within Blogger.
  See: https://developers.google.com/blogger/docs/3.0/getting_started"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn delete$
  "Required parameters: blogId,pageId
  
  Delete a page by ID."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth args]
  {:pre [(util/has-keys? args #{"pageId" "blogId"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/pages/{pageId}"
     #{"pageId" "blogId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "Required parameters: blogId,pageId
  
  Gets one blog page by ID."
  {:scopes ["https://www.googleapis.com/auth/blogger"
            "https://www.googleapis.com/auth/blogger.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"pageId" "blogId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/pages/{pageId}"
     #{"pageId" "blogId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "Required parameters: blogId
  
  Add a page."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"blogId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/pages"
     #{"blogId"}
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
  "Required parameters: blogId
  
  Retrieves the pages for a blog, optionally including non-LIVE statuses."
  {:scopes ["https://www.googleapis.com/auth/blogger"
            "https://www.googleapis.com/auth/blogger.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"blogId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/pages"
     #{"blogId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "Required parameters: blogId,pageId
  
  Update a page. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth args]
  {:pre [(util/has-keys? args #{"pageId" "blogId"})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/pages/{pageId}"
     #{"pageId" "blogId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn publish$
  "Required parameters: blogId,pageId
  
  Publishes a draft page."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"pageId" "blogId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/pages/{pageId}/publish"
     #{"pageId" "blogId"}
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

(defn revert$
  "Required parameters: blogId,pageId
  
  Revert a published or scheduled page to draft state."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"pageId" "blogId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/pages/{pageId}/revert"
     #{"pageId" "blogId"}
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
  "Required parameters: blogId,pageId
  
  Update a page."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth args]
  {:pre [(util/has-keys? args #{"pageId" "blogId"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/pages/{pageId}"
     #{"pageId" "blogId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
