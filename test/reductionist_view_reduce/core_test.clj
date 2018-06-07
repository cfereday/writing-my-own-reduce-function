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

;reduce function - step by step
;takes a collection, a function & an accumulator
;grab first item
;grab accumulator
;shove to function
;whatever you get back you have your new accumulator
;grab second item
;grab new accumulator
;shove to function
;returns the accumulator

(deftest reductionist-reduce-addition-example
  (testing "Returns zero when given an empty collection"
    (def empty-sequence '(0))
    (is (= (my-reduce empty-sequence + 0) 0)))
  (testing "Adds two elements in a list together"
    (def elements-to-be-added '(1 1))
    (is (= (my-reduce elements-to-be-added + 0) 2)))
  (testing "Adds two elements in a list together"
    (def elements-to-be-added '(1 1 2))
    (is (= (my-reduce elements-to-be-added + 0) 4))))



;map function -step by step
;takes a function & a collection
;grab first item
;apply function to that item
;add to a new collection
;grab second item
;apply function to that item
;add to a new collection
;returns the new collection


(deftest reductionist-map-using-my-reduce
  (testing "Returns one when given an empty collection"
    (def empty-sequence '(0))
    (is (= (my-map empty-sequence inc) '(1))))
  (testing "Returns incremented sequence of two elements"
    (def sequence-of-two '(1 2))
    (is (= (my-map sequence-of-two inc) '(2 3))))
  (testing "Returns incremented sequence of three elements"
    (def sequence-of-two '(1 2 3))
    (is (= (my-map sequence-of-two inc) '(2 3 4)))))

;filter method - step by step
;take a predicate & a collection
;grab first item
;check if the item returns true against the predicate
;if it does add it to the new collection
;grab second item
;Go through same process

(deftest reductionist-filter-using-my-reduce
  (testing "Returns an empty collection when given an equal predicate and an odd number"
    (def odd-sequence '(1))
    (is (= (my-filter odd-sequence even?) '(nil))))
  (testing "Returns a collection of the even numbers when given an equal predicate and a collection"
    (def sequence '(1 2 3 4 5 6))
    (is (= (my-filter sequence even?) '(2 4 6)))))


