; Problem 63, Re-implement group-by
; Special Restrictions : group-by

(use '[clojure.test])

(defn solve [f col]
  (let [fn-data (interleave (map f col) col)]
    (reduce (fn [acc [k v]]
              (update acc k (fn [existing]
                              (if existing
                                (conj existing v)
                                [v]))))
            {}
            (partition 2 fn-data))))

(deftest problem-63
  (is (= (solve #(> % 5) #{1 3 6 8}) {false [1 3] true [6 8]}))
  (is (= (solve #(apply / %) [[1 2] [2 4] [4 6] [3 6]]) {1/2 [[1 2] [2 4] [3 6]] 2/3 [[4 6]]}))
  (is (= (solve count [[1] [1 2] [3] [1 2 3] [2 3]]) {1 [[1] [3]] 2 [[1 2] [2 3]] 3 [[1 2 3]]}))
)

(run-tests)
