(ns algorithms
  (:require [clojure.string  :as str]
            [data_structures :as ds]
            [metrics])
  (:gen-class))

(defn -build-levenshtein-index
  [word dictionary]
  (reduce
   (fn [distance-map dictionary-word]
     (let [distance-word (metrics/levenshtein-distance word dictionary-word)]
       (assoc distance-map distance-word (conj (get distance-map distance-word []) dictionary-word))))
   {}
   dictionary))

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

(defn -build-trie-query
  ([word]
   (-build-trie-query #{word} 0))
  ([queries times]
   (if (= times 3)
     queries
     (let [starred-queries (-> (map
                                (fn [query]
                                  (map-indexed
                                   (fn [idx _] (str (subs query 0 idx) "*" (subs query (+ idx 1))))
                                   (str/split query #""))) queries)
                               (flatten)
                               ((fn [starred-queries] (into #{} starred-queries))))]
       (recur starred-queries (inc times))))))

(defn find-using-trie
  [word dictionary]
  (let [trie    (ds/build-trie dictionary)
        queries (-build-trie-query word)]
    (-> (map (fn [query] (ds/find-in-trie trie query)) queries)
        (flatten)
        ((fn [flatten-queries] (remove nil? flatten-queries)))
        ((fn [filtered-queries] (into #{} filtered-queries))))))

(find-using-trie "hello" ["hell" "old" "halloween"])
