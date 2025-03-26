; Problem 62, Re-implement Iteration
; Special Restrictions : iterate

(use '[clojure.test])

(defn solve [x y]
  (cons y
    (lazy-seq
      (solve x (x y)))))

(deftest problem-62
  (is (= (take 5 (solve #(* 2 %) 1)) [ 1 2 4 8 16]))
  (is (= (take 100 (solve inc 0)) (take 100 (range))))
  (is (= (take 9 (solve #(inc (mod % 3)) 1)) (take 9 (cycle [1 2 3]))))
)

(run-tests)

