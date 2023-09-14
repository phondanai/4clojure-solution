; Problem 56, Find Distinct Items
; Special Restrictions : distinct

(use '[clojure.test])

(defn solve [coll]
  (reduce (fn [col x]
            (if (not (some #(= x %) col))
              (conj col x)
              col)) [] coll))

(deftest problem-56
  (is (= (solve [1 2 1 3 1 2 4]) [1 2 3 4]))
  (is (= (solve [:a :a :b :b :c :c]) [:a :b :c]))
  (is (= (solve '([2 4] [1 2] [1 3] [1 3])) '([2 4] [1 2] [1 3]))))

(run-tests)
