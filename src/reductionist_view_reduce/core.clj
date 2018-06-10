(ns reductionist-view-reduce.core
  (:gen-class))


(defn my-reduce [some-collection some-function accumulator]
  (if (= (count some-collection) 0)
    accumulator
    (let [[element & rest] some-collection
          new-accumulator (some-function accumulator element)]
      (my-reduce rest some-function new-accumulator))))


(defn my-map
  [some-collection some-function]
  (reverse (my-reduce some-collection #(conj %1 (some-function %2)) '())))


  (defn my-filter
  [some-collection some-predicate]
  (let [result (my-reduce some-collection #(conj (remove nil? %1) (if (= (some-predicate %2) true)
                                                                    %2))
                 '())]
    (reverse result)))

(defn my-some
  [some-collection some-predicate]
  (my-reduce some-collection #(if (some-predicate %2) true %1) nil))

(comment
  (defn my-max
    [some-collection some-function]
    (println "HERE IS RESULT***" (my-reduce some-collection (some-function some-collection) 0))
    ))


(defn my-max
  [some-collection]
  (my-reduce some-collection max 0))
