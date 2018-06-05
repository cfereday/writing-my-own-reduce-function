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

(defn- should-be-added-two?
  [%2 some-predicate]
  (if (= (some-predicate %2) true)
    %2))

(defn my-filter-two
  [some-collection some-predicate]
  (let [initial-result (my-reduce some-collection #(conj %1 (should-be-added-two? %2 some-predicate)) '())
        removed-nil-from-result (remove nil? initial-result)]
    (reverse removed-nil-from-result)))


(defn- check-if-should-be-added
  [accumulator result]
  (if (= (result true))
    #(conj accumulator)))

(defn my-filter
  [some-collection some-predicate]
  (let [result (my-reduce some-collection #(conj %1
                                             (if (= (some-predicate %2) true)
                                               %2))
                 '())
        removed-nil-from-result (remove nil? result)]
    (reverse removed-nil-from-result)))



