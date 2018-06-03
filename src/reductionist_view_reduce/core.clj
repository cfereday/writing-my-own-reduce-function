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

(defn my-reduce [some-collection some-function accumulator]
  (if (= (count some-collection) 0)
    accumulator
    (let [first-number-in-collection (first some-collection)
          new-accumulator (some-function accumulator first-number-in-collection)
          popped-collection (pop some-collection)]
      (my-reduce popped-collection some-function new-accumulator))))

