; Problem 61, Map Construction
; Special Restrictions : zipmap

(use '[clojure.test])

(defn solve [x y]
  (into {} (map hash-map x y)))

(deftest problem-61
  (is (= {:a 1, :b 2, :c 3} (solve [:a :b :c] [1 2 3])))
  (is (= {1 "one", 2 "two", 3 "three"} (solve [1 2 3 4] ["one" "two" "three"])))
  (is (= {:foo "foo", :bar "bar"} (solve [:foo :bar] ["foo" "bar"])))
)

(run-tests)

