(ns happygapi.drive.comments
  "Drive API: comments.
  Manages files in Drive including uploading, downloading, searching, detecting changes, and updating sharing permissions.
  See: https://developers.google.com/drive/api/reference/rest/v3/comments"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn create$
  "https://developers.google.com/drive/api/reference/rest/v3/comments/create
  
  Required parameters: fileId
  
  Optional parameters: none
  
  Body: 
  
  {:htmlContent string,
   :deleted boolean,
   :modifiedTime string,
   :content string,
   :resolved boolean,
   :author {:displayName string,
            :emailAddress string,
            :kind string,
            :me boolean,
            :permissionId string,
            :photoLink string},
   :replies [{:htmlContent string,
              :deleted boolean,
              :modifiedTime string,
              :content string,
              :author User,
              :createdTime string,
              :id string,
              :kind string,
              :action string}],
   :createdTime string,
   :quotedFileContent {:mimeType string, :value string},
   :id string,
   :kind string,
   :anchor string}
  
  Creates a new comment on a file."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:fileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "files/{fileId}/comments"
     #{:fileId}
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

(defn delete$
  "https://developers.google.com/drive/api/reference/rest/v3/comments/delete
  
  Required parameters: commentId, fileId
  
  Optional parameters: none
  Deletes a comment."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"]}
  [auth args]
  {:pre [(util/has-keys? args #{:commentId :fileId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "files/{fileId}/comments/{commentId}"
     #{:commentId :fileId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/drive/api/reference/rest/v3/comments/get
  
  Required parameters: commentId, fileId
  
  Optional parameters: includeDeleted
  Gets a comment by ID."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:commentId :fileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "files/{fileId}/comments/{commentId}"
     #{:commentId :fileId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/drive/api/reference/rest/v3/comments/list
  
  Required parameters: fileId
  
  Optional parameters: includeDeleted, pageSize, pageToken, startModifiedTime
  Lists a file's comments."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:fileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "files/{fileId}/comments"
     #{:fileId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/drive/api/reference/rest/v3/comments/update
  
  Required parameters: commentId, fileId
  
  Optional parameters: none
  
  Body: 
  
  {:htmlContent string,
   :deleted boolean,
   :modifiedTime string,
   :content string,
   :resolved boolean,
   :author {:displayName string,
            :emailAddress string,
            :kind string,
            :me boolean,
            :permissionId string,
            :photoLink string},
   :replies [{:htmlContent string,
              :deleted boolean,
              :modifiedTime string,
              :content string,
              :author User,
              :createdTime string,
              :id string,
              :kind string,
              :action string}],
   :createdTime string,
   :quotedFileContent {:mimeType string, :value string},
   :id string,
   :kind string,
   :anchor string}
  
  Updates a comment with patch semantics."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:commentId :fileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "files/{fileId}/comments/{commentId}"
     #{:commentId :fileId}
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
