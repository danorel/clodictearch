(ns metrics
  (:require [clojure.string :as str])
  (:gen-class))

(defn -levenshtein-distance-in-seq
  ([] 0)
  ([xs ys]
   (cond
     (and (nil? (seq xs)) (nil? (seq ys))) 0
     (nil? (seq xs)) (count ys)
     (nil? (seq ys)) (count xs)
     :else
     (if (= (last xs) (last ys))
       (recur (drop-last xs) (drop-last ys))
       (apply min (vector
                   (+ 1 (-levenshtein-distance-in-seq (drop-last xs) ys))
                   (+ 1 (-levenshtein-distance-in-seq xs (drop-last ys)))
                   (+ 1 (-levenshtein-distance-in-seq (drop-last xs) (drop-last ys)))))))))

(defn levenshtein-distance
  [f s]
  (let [xs (-> f
               (str/split #""))
        ys (-> s
               (str/split #""))]
    (-levenshtein-distance-in-seq xs ys)))
