(ns dictsearch 
  (:require [levenshtein :as metric])
  (:gen-class))

(defn -build-levenshtein-index
  [word dictionary]
  (reduce 
    (fn[distance-map dictionary-word]
      (let [distance-word (metric/levenshtein-distance word dictionary-word)]
        (assoc distance-map distance-word (conj (get distance-map distance-word []) dictionary-word))
    ))
    {}
    dictionary
  ))

(defn -find-closest-in-index
  [levenshtein-index distance]
    (let [closest-words (get levenshtein-index distance ())]
      (if (nil? (seq closest-words))
        (recur levenshtein-index (inc distance))
        closest-words)))

(defn find-closest
  ([word dictionary]
    (let [levenshtein-index (-build-levenshtein-index word dictionary)]
      (-find-closest-in-index levenshtein-index 1))))
