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

(defn my-map-two
  ([some-function some-collection]
   (let [[first-element & rest] some-collection
         new-collection (conj '() (some-function first-element))]
     (my-map-two some-function rest new-collection)))
  ([some-function some-collection some-new-collection]
   (if (= (count some-collection) 0)
     (reverse some-new-collection)
     (let [[first-element & rest] some-collection
           updated-new-collection (conj some-new-collection (some-function first-element))]
       (my-map-two some-function rest updated-new-collection)))))



