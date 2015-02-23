(ns homebrew-recipe-rest.db.dbConnect
  (:require [monger.core :as mg]))
  
  ;;Connects to MongoDb using Mongor.
  (let [conn (mg/connect {:host "localhost" :port 27017})])  