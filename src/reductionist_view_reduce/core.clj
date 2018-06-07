(ns reductionist-view-reduce.core
  (:gen-class))

;steps of a reduce function
;grab first item
;grab accumulator
;shove to function
;whatever you get back you have your new accumulator
;grab second item
;grab new accumulator
;shove to function

;control what the output will be

(defn my-reduce [some-collection some-function accumulator]
  (if (= (count some-collection) 0)
    accumulator
    (let [[element & rest] some-collection
          new-accumulator (some-function accumulator element)]
      (my-reduce rest some-function new-accumulator))))

;get first item
;apply function to first item
;add this to a new collection
;get second item
;apply function to second item
;add this to the new collection
;and so on, until every item in the collection has been iterated over
(defn my-map
  [some-collection some-function]
  (reverse (my-reduce some-collection #(conj %1 (some-function %2)) '())))


;filter method - step by step
;take a predicate & a collection
;grab first item
;check if the item returns true against the predicate#
;if it does add it to the new collection
;grab second item
;Go through same process

  (defn my-filter
  [some-collection some-predicate]
  (let [result (my-reduce some-collection #(conj (remove nil? %1) (if (= (some-predicate %2) true)
                                                                    %2))
                 '())]
    (reverse result)))
