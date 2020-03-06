(ns happygapi.dfareporting.eventTags
  "DCM/DFA Reporting And Trafficking API: eventTags.
  Manages your DoubleClick Campaign Manager ad campaigns and reports.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/eventTags"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/eventTags/delete
  
  Required parameters: id, profileId
  
  Optional parameters: none
  Deletes an existing event tag."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args]
  {:pre [(util/has-keys? args #{:id :profileId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/eventTags/{id}"
     #{:id :profileId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/eventTags/get
  
  Required parameters: id, profileId
  
  Optional parameters: none
  Gets one event tag by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args]
  {:pre [(util/has-keys? args #{:id :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/eventTags/{id}"
     #{:id :profileId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/eventTags/insert
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:sslCompliant boolean,
   :advertiserIdDimensionValue {:dimensionName string,
                                :etag string,
                                :id string,
                                :kind string,
                                :matchType string,
                                :value string},
   :name string,
   :campaignId string,
   :urlEscapeLevels integer,
   :type string,
   :siteFilterType string,
   :campaignIdDimensionValue {:dimensionName string,
                              :etag string,
                              :id string,
                              :kind string,
                              :matchType string,
                              :value string},
   :excludeFromAdxRequests boolean,
   :advertiserId string,
   :status string,
   :id string,
   :kind string,
   :url string,
   :enabledByDefault boolean,
   :subaccountId string,
   :accountId string,
   :siteIds [string]}
  
  Inserts a new event tag."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/eventTags"
     #{:profileId}
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/eventTags/list
  
  Required parameters: profileId
  
  Optional parameters: adId, campaignId, ids, searchString, eventTagTypes, sortField, definitionsOnly, advertiserId, sortOrder, enabled
  Retrieves a list of event tags, possibly filtered."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args]
  {:pre [(util/has-keys? args #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/eventTags"
     #{:profileId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/eventTags/patch
  
  Required parameters: id, profileId
  
  Optional parameters: none
  
  Body: 
  
  {:sslCompliant boolean,
   :advertiserIdDimensionValue {:dimensionName string,
                                :etag string,
                                :id string,
                                :kind string,
                                :matchType string,
                                :value string},
   :name string,
   :campaignId string,
   :urlEscapeLevels integer,
   :type string,
   :siteFilterType string,
   :campaignIdDimensionValue {:dimensionName string,
                              :etag string,
                              :id string,
                              :kind string,
                              :matchType string,
                              :value string},
   :excludeFromAdxRequests boolean,
   :advertiserId string,
   :status string,
   :id string,
   :kind string,
   :url string,
   :enabledByDefault boolean,
   :subaccountId string,
   :accountId string,
   :siteIds [string]}
  
  Updates an existing event tag. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:id :profileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/eventTags"
     #{:id :profileId}
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/eventTags/update
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:sslCompliant boolean,
   :advertiserIdDimensionValue {:dimensionName string,
                                :etag string,
                                :id string,
                                :kind string,
                                :matchType string,
                                :value string},
   :name string,
   :campaignId string,
   :urlEscapeLevels integer,
   :type string,
   :siteFilterType string,
   :campaignIdDimensionValue {:dimensionName string,
                              :etag string,
                              :id string,
                              :kind string,
                              :matchType string,
                              :value string},
   :excludeFromAdxRequests boolean,
   :advertiserId string,
   :status string,
   :id string,
   :kind string,
   :url string,
   :enabledByDefault boolean,
   :subaccountId string,
   :accountId string,
   :siteIds [string]}
  
  Updates an existing event tag."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:profileId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/eventTags"
     #{:profileId}
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
