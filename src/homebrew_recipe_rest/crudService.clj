(ns homebrew-recipe-rest.crudService
  (:use compojure.core)
  (:use ring.middleware.json-params)
  (:require [clj-json.core :as json])
  (:require [homebrew-recipe-rest.models.recipe :as recipe]))

(defn json-response [data & [status]]
  {:status (or status 200)
   :headers {"Content-Type" "application/json"}
   :body (json/generate-string data)})

(defroutes crudHandler
  ;;Welcome response on index.
  (GET "/" []
    (json-response {"message" "Welcome to the Homebrew Recipe Store"}))
  
  ;;List of recipes. "READ"
  (GET "/recipes" []
    (json-response (recipe/list)))

  ;;Specific recipe. "READ"
  (GET "/recipes/:id" [id]
    (json-response (recipe/get id)))

  ;;"CREATE and UPDATE" recipe.
  (PUT "/recipes/:id" [id recipe]
    (json-response (recipe/put id recipe)))

  ;;"DELETE" recipe.
  (DELETE "/recipes/:id" [id]
    (json-response (recipe/delete id))))