(ns dictsearch-test 
  (:require [clojure.test :refer :all]
            [dictsearch :refer :all]))

(deftest a-test
  (testing "Dictionary distance evaluation"
    (is (= (find-closest "hello" ["hell" "old" "halloween"]) ["hell"]))
    (is (= (find-closest "hello" ["hell" "lol" "halloween" "hill" "hall"]) ["hell"]))))
