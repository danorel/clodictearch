(ns algorithms-test
  (:require [clojure.test :refer :all]
            [algorithms :refer :all]))

(deftest find-using-levenshtein-index-test
  (testing "Dictionary search for closest words per certain query using Levenshtein distance index"
    (is (= (find-using-levenshtein-index "hello" ["hell" "old" "halloween"]) ["hell"]))
    (is (= (find-using-levenshtein-index "hello" ["hell" "lol" "halloween" "hill" "hall"]) ["hell"]))))


(deftest build-trie-query-test
  (testing "Building Trie templated query"
    (is (= (count (-build-trie-query "heo")) 7))
    (is (= (count (-build-trie-query "abracadabra")) 231))
    (is (= (count (-build-trie-query "hello")) 25))))

(deftest find-using-trie-test
  (testing "Dictionary search for closest words per certain query using Trie templated query"
    (is (= (count (find-using-trie "hello" ["hell" "old" "halloween"])) ["hell"]))
    (is (= (count (find-using-trie "hello" ["hell" "lol" "halloween" "hill" "hall"])) ["hell"]))))
