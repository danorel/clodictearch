(ns data-structures-test
  (:require [clojure.test    :refer :all]
            [data_structures :refer :all]))

(deftest trie-test
  (testing "Trie collection"
    (is (= (count (build-trie ["hell" "old" "halloween"])) 2))))
