(ns reductionist-view-reduce.core
  (:gen-class))

;grab first item
;grab accumulator
;shove to function
;whatever you get back you have your new accumulator
;grab second item
;grab new accumulator
;shove to function

(defn my-reduce-two [some-collection some-function accumulator]
  (let [first-number-in-collection (first some-collection)
        new-accumulator (some-function accumulator first-number-in-collection)
        popped-collection (pop some-collection)]
    (my-reduce-two popped-collection some-function new-accumulator)))

(comment
  (defn my-reduce
    ([some-collection]
     (let [first-number-in-collection (first some-collection)
           second-number-in-collection (second some-collection)
           provisional-result (+ first-number-in-collection second-number-in-collection)
           popped-collection (pop some-collection)]
       (my-reduce popped-collection provisional-result)))
    ([some-collection provisional-result]
     (if (= (count some-collection) 1)
       (nth provisional-result 0)
       (let [second-number-in-collection (second some-collection)
             next-provisional-result (+ provisional-result second-number-in-collection)
             popped-collection (pop some-collection)]
         (my-reduce popped-collection next-provisional-result))))))
