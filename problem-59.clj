; Problem 59, Juxtaposition
; Special Restrictions : juxt

(use '[clojure.test])

(defn solve [& fs]
  (fn [& args]
    (map #(apply % args) fs)))

(deftest problem-59
  (is (= [21 6 1] ((solve + max min) 2 3 5 1 6 4)))
  (is (= ["HELLO" 5] ((solve #(.toUpperCase %) count) "hello")))
  (is (= [2 6 4] ((solve :a :c :b) {:a 2, :b 4, :c 6, :d 8, :e 10})))
)

(run-tests)

