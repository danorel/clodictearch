(ns algorithms 
  (:require [metrics])
  (:gen-class))

(defn -build-levenshtein-index
  [word dictionary]
  (reduce 
    (fn[distance-map dictionary-word]
      (let [distance-word (metrics/levenshtein-distance word dictionary-word)]
        (assoc distance-map distance-word (conj (get distance-map distance-word []) dictionary-word))
    ))
    {}
    dictionary
  ))

(defn -find-using-levenshtein-index-per-distance
  [levenshtein-index distance]
    "Way too slow algorithm using levenshtein index: { 'distance-1': [word1, word2, etc.] }"
    (let [closest-words (get levenshtein-index distance ())]
      (if (nil? (seq closest-words))
        (recur levenshtein-index (inc distance))
        closest-words)))

(defn find-using-levenshtein-index 
  ([word dictionary]
    (let [levenshtein-index (-build-levenshtein-index word dictionary)]
      (-find-using-levenshtein-index-per-distance levenshtein-index 1))))
