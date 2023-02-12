(ns main
  (:require [clojure.java.io :as io]
            [clojure.string  :as str]
            [dictsearch      :as ds])
  (:gen-class))

(defn -file->vec
  "Read in a file from the resources directory"
  [filename]
    (-> filename
        (io/resource)
        (slurp)
        (str/split #"\n")))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [filename (first args)
        word     (second args)]
    (println (ds/find-closest word (-file->vec filename)))))
