(ns happygapi.vision.images
  "Cloud Vision API
  Integrates Google Vision features, including image labeling, face, logo, and landmark detection, optical character recognition (OCR), and detection of explicit content, into applications.
  See: https://cloud.google.com/vision/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "vision_schema.edn"))))

(defn asyncBatchAnnotate$
  "Required parameters: none
  
  Optional parameters: none
  
  Run asynchronous image detection and annotation for a list of images.
  
  Progress and results can be retrieved through the
  `google.longrunning.Operations` interface.
  `Operation.metadata` contains `OperationMetadata` (metadata).
  `Operation.response` contains `AsyncBatchAnnotateImagesResponse` (results).
  
  This service will write image annotation outputs to json files in customer
  GCS bucket, each json file containing BatchAnnotateImagesResponse proto."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-vision"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vision.googleapis.com/"
     "v1/images:asyncBatchAnnotate"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn annotate$
  "Required parameters: none
  
  Optional parameters: none
  
  Run image detection and annotation for a batch of images."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-vision"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vision.googleapis.com/"
     "v1/images:annotate"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))
