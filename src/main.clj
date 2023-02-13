(ns main
  (:require [clojure.java.io :as io]
            [clojure.string  :as str]
            [algorithms])
  (:gen-class))

(defmacro measure-time [expr]
  (let [sym (= (type expr) clojure.lang.Symbol)]
    `(let [start# (. System (nanoTime))
           return# ~expr
           res# (if ~sym
                  (resolve '~expr)
                  (resolve (first '~expr)))]
       (prn (str "Timed "
                 (:name (meta res#))
                 ": " (/ (double (- (. System (nanoTime)) start#)) 1000000.0) " msecs"))
       return#)))

(defn -file->vec
  "Read in a file from the resources directory"
  [filename]
  (-> filename
      (io/resource)
      (slurp)
      (str/split #"\n")))

(defn -vec->file
  "Write in a file in the resources directory"
  [filename output]
  (io/make-parents filename)
  (spit filename (prn-str output)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [[word input output & _] args
        results  (measure-time (algorithms/find-using-trie word (-file->vec input)))]
    (println "Closest words to" word "are:")
    (println results)
    (-vec->file output results)))
