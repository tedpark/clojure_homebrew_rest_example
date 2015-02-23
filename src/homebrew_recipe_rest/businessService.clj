(ns homebrew-recipe-rest.businessService
  (:use compojure.core)
  (:use ring.middleware.json-params)
  (:require [clj-json.core :as json])
  (:require [homebrew-recipe-rest.models.recipe :as recipe]))

;;Get price from json.
(defn priceFromJson [json]
  (-> (get-in your-parsed-json json)
                       first 
                        (get "price")))
  
;;Parse price1 and price2 out of json.
(defn parse-input [recipe1 recipe2]
  [(Integer/parseInt (priceFromJson recipe1)) (Integer/parseInt (priceFromJson recipe2))])
  
(defn json-response [data & [status]]
  {:status (or status 200)
   :headers {"Content-Type" "application/json"}
   :body (json/generate-string data)})

(defroutes businessHandler
  ;;Compare price of recipe1 to recipe2. 
  (GET "/recipe/comparePrice/:id1/:id2" [id1 id2]
    (let [[id1 id2] (parse-input (recipe/get id1) recipe/get id2)
      result (if (< id1 id2) "Recipe 1 is less expensive." "Recipe 2 is less expensive."))]
      (json-response (result))))