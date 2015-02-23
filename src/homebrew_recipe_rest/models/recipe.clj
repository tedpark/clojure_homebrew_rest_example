(ns homebrew-recipe-rest.models.recipe
  (:refer-clojure :exclude (list get delete)))
  
(def recipes (atom {}))

(defn list []
  @recipes)
  
(defn get [id]
  (@recipes id))

(defn put [id recipe]
  (let [new-recipe (merge (get id) recipe)]
     (swap! recipes assoc id)
     new-recipe))

(defn delete [id]
  (let [old-recipe (get id)]
    (swap! recipes dissoc id)
    old-recipe))  