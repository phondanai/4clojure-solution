; Problem 54, Partition a Sequence
(use '[clojure.test])

(defn solve [x col]
  (let [drp (range 0 (count col) x)]
    (filter #(= x (count %))
      (map (fn [y] (take x (drop y col))) drp))))


(deftest problem-54
  (is (= (solve 3 (range 9)) '((0 1 2) (3 4 5) (6 7 8))))
  (is (= (solve 2 (range 8)) '((0 1) (2 3) (4 5) (6 7))))
  (is (= (solve 3 (range 8)) '((0 1 2) (3 4 5)))))

(run-tests)
