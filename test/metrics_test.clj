(ns metrics-test 
  (:require [clojure.test :refer :all]
            [metrics :refer :all]))

(deftest a-test
  (testing "Levenshtein distance"
    (is (= (levenshtein-distance "hello" "heat") 3))
    (is (= (levenshtein-distance "hello" "hello") 0))
    (is (= (levenshtein-distance "flip" "flop") 1))
    (is (= (levenshtein-distance "flip" "free") 3))))
