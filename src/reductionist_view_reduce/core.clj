(ns reductionist-view-reduce.core
  (:gen-class))

(defn my-reduce [some-collection]
  (map + some-collection))

