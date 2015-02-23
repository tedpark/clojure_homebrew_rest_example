(ns homebrew-recipe-rest.handler
  (:use [homebrew-recipe-rest.crudService]
            [homebrew-recipe-rest.db.dbConnect])
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes main-handler
  (GET "/" [] "Hello World")
  (route/not-found "Not Found"))

(defn wrap-ohandler [f handler]
  (fn [req]
    (let [ res (f req) ]
      (if (= res nil) (handler req) res))))

(def handler-wrapped 
  (-> #'crudHandler
    (wrap-ohandler #'main-handler )))

(def app
  (wrap-defaults handler-wrapped site-defaults))
