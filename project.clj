(defproject homebrew_recipe_rest "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.3.1"]
                 [ring/ring-defaults "0.1.2"]
                 [ring-json-params "0.1.0"]
                 [clj-json "0.2.0"]
                 [com.novemberain/monger "2.0.0"]
                 [org.immutant/web "2.0.0-beta2"]
                 [org.immutant/caching "2.0.0-beta2"]
                 [org.immutant/messaging "2.0.0-beta2"]
                 [org.immutant/scheduling "2.0.0-beta2"]
                 [org.wildfly/wildfly-server "8.2.0.Final"]]
  :plugins [[lein-ring "0.8.13"]
            [lein-immutant "2.0.0-alpha2"]]
  :ring {:handler homebrew-recipe-rest.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
