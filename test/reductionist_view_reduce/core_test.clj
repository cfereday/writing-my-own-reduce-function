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


;doIt takes a collection
;It takes an accumulator
;It can either give a new data collection, or a single result
;It will go through each item in the collection
;It will apply a function to each element of that collection
;It will return a new number

(deftest reductionist-reduce
  (testing "Adds the elements of a data collection together"
    ;create an array containing [0]
    ;create a new reduce function
    ;pass in the collection
    ;returns 0
    (def empty-list (list 0))
    (is (= (my-reduce empty-list) 0))))
