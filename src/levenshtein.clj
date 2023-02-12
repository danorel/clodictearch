(ns levenshtein
  (:require [clojure.string :as str])
  (:gen-class))

(defn levenshtein-distance-in-vector
  ([] 0)
  ([xs ys] 
   (cond
     (and (nil? (seq xs)) (nil? (seq ys))) 0
     (nil? (seq xs)) (count ys)
     (nil? (seq ys)) (count xs)
     :else
       (if (= (last xs) (last ys))
         (levenshtein-distance-in-vector (drop-last xs) (drop-last ys))
         (apply min (vector
            (+ 1 (levenshtein-distance-in-vector (drop-last xs) ys))
            (+ 1 (levenshtein-distance-in-vector xs (drop-last ys)))
            (+ 1 (levenshtein-distance-in-vector (drop-last xs) (drop-last ys)))))))))

(defn levenshtein-distance
  [f s] 
  (let [xs (-> f
               (str/split #""))
        ys (-> s
               (str/split #""))]
    (levenshtein-distance-in-vector xs ys)))

(levenshtein-distance "hello" "heat")
