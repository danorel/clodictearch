(ns dictsearch 
  (:require [clojure.java.io :as io])
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [filename (first args)]
    (with-open [rdr (io/resource filename)]
      (doseq [line (line-seq rdr)]
        (println line)))))
