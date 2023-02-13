(ns algorithms-test 
  (:require [clojure.test :refer :all]
            [algorithms :refer :all]))

(deftest a-test
  (testing "Dictionary search for closest words per certain query using Levenshtein distance index"
    (is (= (find-using-levenshtein-index "hello" ["hell" "old" "halloween"]) ["hell"]))
    (is (= (find-using-levenshtein-index "hello" ["hell" "lol" "halloween" "hill" "hall"]) ["hell"]))))
