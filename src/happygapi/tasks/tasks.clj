(ns happygapi.tasks.tasks
  "Tasks API: tasks.
  Manages your tasks and task lists.
  See: https://developers.google.com/google-apps/tasks/firstappapi/reference/rest/v1/tasks"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn clear$
  "https://developers.google.com/google-apps/tasks/firstappapi/reference/rest/v1/tasks/clear
  
  Required parameters: tasklist
  
  Optional parameters: none
  Clears all completed tasks from the specified task list. The affected tasks will be marked as 'hidden' and no longer be returned by default when retrieving all tasks for a task list."
  {:scopes ["https://www.googleapis.com/auth/tasks"]}
  [auth args]
  {:pre [(util/has-keys? args #{:tasklist})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/tasks/v1/"
     "lists/{tasklist}/clear"
     #{:tasklist}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://developers.google.com/google-apps/tasks/firstappapi/reference/rest/v1/tasks/delete
  
  Required parameters: task, tasklist
  
  Optional parameters: none
  Deletes the specified task from the task list."
  {:scopes ["https://www.googleapis.com/auth/tasks"]}
  [auth args]
  {:pre [(util/has-keys? args #{:task :tasklist})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/tasks/v1/"
     "lists/{tasklist}/tasks/{task}"
     #{:task :tasklist}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/google-apps/tasks/firstappapi/reference/rest/v1/tasks/get
  
  Required parameters: task, tasklist
  
  Optional parameters: none
  Returns the specified task."
  {:scopes ["https://www.googleapis.com/auth/tasks"
            "https://www.googleapis.com/auth/tasks.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:task :tasklist})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/tasks/v1/"
     "lists/{tasklist}/tasks/{task}"
     #{:task :tasklist}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/google-apps/tasks/firstappapi/reference/rest/v1/tasks/insert
  
  Required parameters: tasklist
  
  Optional parameters: parent, previous
  
  Body: 
  
  {:deleted boolean,
   :parent string,
   :updated string,
   :completed string,
   :selfLink string,
   :etag string,
   :due string,
   :title string,
   :status string,
   :hidden boolean,
   :id string,
   :kind string,
   :notes string,
   :position string,
   :links [{:description string, :link string, :type string}]}
  
  Creates a new task on the specified task list. Fails with HTTP code 403 or 429 after reaching the storage limit of 100,000 tasks per account."
  {:scopes ["https://www.googleapis.com/auth/tasks"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:tasklist})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/tasks/v1/"
     "lists/{tasklist}/tasks"
     #{:tasklist}
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
  "https://developers.google.com/google-apps/tasks/firstappapi/reference/rest/v1/tasks/list
  
  Required parameters: tasklist
  
  Optional parameters: completedMin, showCompleted, completedMax, pageToken, showHidden, dueMin, showDeleted, updatedMin, dueMax, maxResults
  Returns all tasks in the specified task list."
  {:scopes ["https://www.googleapis.com/auth/tasks"
            "https://www.googleapis.com/auth/tasks.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:tasklist})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/tasks/v1/"
     "lists/{tasklist}/tasks"
     #{:tasklist}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn move$
  "https://developers.google.com/google-apps/tasks/firstappapi/reference/rest/v1/tasks/move
  
  Required parameters: task, tasklist
  
  Optional parameters: parent, previous
  Moves the specified task to another position in the task list. This can include putting it as a child task under a new parent and/or move it to a different position among its sibling tasks."
  {:scopes ["https://www.googleapis.com/auth/tasks"]}
  [auth args]
  {:pre [(util/has-keys? args #{:task :tasklist})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/tasks/v1/"
     "lists/{tasklist}/tasks/{task}/move"
     #{:task :tasklist}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/google-apps/tasks/firstappapi/reference/rest/v1/tasks/patch
  
  Required parameters: task, tasklist
  
  Optional parameters: none
  
  Body: 
  
  {:deleted boolean,
   :parent string,
   :updated string,
   :completed string,
   :selfLink string,
   :etag string,
   :due string,
   :title string,
   :status string,
   :hidden boolean,
   :id string,
   :kind string,
   :notes string,
   :position string,
   :links [{:description string, :link string, :type string}]}
  
  Updates the specified task. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/tasks"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:task :tasklist})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/tasks/v1/"
     "lists/{tasklist}/tasks/{task}"
     #{:task :tasklist}
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
  "https://developers.google.com/google-apps/tasks/firstappapi/reference/rest/v1/tasks/update
  
  Required parameters: task, tasklist
  
  Optional parameters: none
  
  Body: 
  
  {:deleted boolean,
   :parent string,
   :updated string,
   :completed string,
   :selfLink string,
   :etag string,
   :due string,
   :title string,
   :status string,
   :hidden boolean,
   :id string,
   :kind string,
   :notes string,
   :position string,
   :links [{:description string, :link string, :type string}]}
  
  Updates the specified task."
  {:scopes ["https://www.googleapis.com/auth/tasks"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:task :tasklist})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/tasks/v1/"
     "lists/{tasklist}/tasks/{task}"
     #{:task :tasklist}
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
