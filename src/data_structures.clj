(ns data_structures
  (:require [clojure.string :as str])
  (:gen-class))

(defn add-to-trie [trie query]
  (assoc-in trie query (merge (get-in trie query) {:val query :terminal true})))

(defn find-in-trie [trie query]
  "Returns true if the value x matches any other value in the specified trie."
  (if (str/blank? query)
    nil
    (let [[letter & rest-word] query
          next-query           (str/join rest-word)]
      (if (get trie :terminal)
        (get trie :val)
        (if (= letter "*")
          (flatten (map (fn [key] (find-in-trie (get trie key) next-query)) (keys trie)))
          (let [next-trie (get trie letter)]
            (recur next-trie next-query)))))))

(defn build-trie [coll]
  "Builds a trie over the values in the specified seq coll."
  (reduce add-to-trie {} coll))
