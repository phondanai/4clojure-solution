; Problem 55, Count Occurences.
(use '[clojure.test])

(defn solve [coll]
  (let [part (partition-by identity (sort coll))
        k (map first part)
        cnt (map count part)]
   (zipmap k cnt)))

(deftest problem-54
  (is (= (solve [1 1 2 3 2 1 1]) {1 4, 2 2, 3 1}))
  (is (= (solve [:b :a :b :a :b]) {:a 2, :b 3}))
  (is (= (solve '([1 2] [1 3] [1 3])) {[1 2] 1, [1 3] 2})))

(run-tests)
