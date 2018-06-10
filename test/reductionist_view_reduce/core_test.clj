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


;some method - step by step
;take a predicate and a collection
;grab first item
;check if item returns true against the predicate
;if it does add true to the accumulator the predicate otherwise add the new accumulator which is false (nil)
;otherwise grab second item
;check if item returns true against the predicate otherwise add the new accumulator which is false (nil)
;if it does add true to the accumulator and return the accumulator
;once you get a true you return the accumulator
;otherwise you continue through whole list - if no items are true then nil is returned


(deftest reductionist-some-using-my-reduce
  (testing "Returns nil when no items in the collection are even"
    (def odd-sequence '(1 3 5))
    (is (= (my-some odd-sequence even?) nil)))
  (testing "Returns true when one item in the collection is even"
    (def even-sequence '(2 3 5))
    (is (= (my-some even-sequence even?) true)))
  (testing "Returns true when more than one item in the collection is even"
    (def another-even-sequence '(2 4 6 8))
    (is (= (my-some another-even-sequence even?)) true))
  (testing "Returns true when there is at least one even number in collection"
    (def mixed-sequence '(1 2 3 5 6 8))
    (is (= (my-some mixed-sequence even?)) true)))


;some max - step by step
;take a function & a collection
;grab first item
;check if item is bigger than last
;if it is keep it, otherwise on to the next one

(deftest reductionist-max-using-my-reduce
  (testing "Returns nil when given nil as only number"
            (def nil-sequence '(0))
            (is (= (my-max nil-sequence) 0)))
  (testing "Returns 3 when this is the biggest number"
    (def numbers '(1 2 3))
    (is (= (my-max numbers) 3)))
  (testing "Returns 9 when this is the biggest number"
    (def numbers '(1 4 6 9))
    (is (= (my-max numbers) 9))))


(deftest reductionist-my-find-using-my-reduce
  (testing "Returns first even when given a list containing mixed numbers"
    (def mixed-sequence '(1 3 4 7 8 9))
    (is (= (my-find mixed-sequence even?) 4)))
  (testing "Returns nil when there are no even numbers"
    (def all-odd '(1 3 5))
    (is (= (my-find all-odd even?) nil)))
  (testing "Returns first even when given a list of all evens"
    (def all-even '(2 4 6 8 10))
    (is (= (my-find all-even even?) 2))))



