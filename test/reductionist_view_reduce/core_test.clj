(ns reductionist-view-reduce.core-test
  (:require [clojure.test :refer :all]
            [reductionist-view-reduce.core :refer :all]))

;describe what the reduce function does
;go through and try to test for different functionality at stages of reduce function


;reduce function is made up of many small functions to finally produce a single result

;It is a function composition
; an act or mechanism to combine simple functions to build more complicated ones.
; Like the usual composition of functions in mathematics, the result of each function is passed as the argument of the next,
; and the result of the last one is the result of the whole.


;grab first item
;grab accumulator
;shove to function
;whatever you get back you have your new accumulator
;grab second item
;grab new accumulator
;shove to function

(deftest reductionist-reduce-addition
  (testing "Returns zero when given an empty collection"
    (def empty-sequence '(0))
    (is (= (my-reduce empty-sequence + 0) 0)))
  (testing "Adds two elements in a list together"
    (def elements-to-be-added '(1 1))
    (is (= (my-reduce elements-to-be-added + 0) 2)))
  (testing "Adds two elements in a list together"
    (def elements-to-be-added '(1 1 2))
    (is (= (my-reduce elements-to-be-added + 0) 4))))



