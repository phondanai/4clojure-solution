; Problem 53, Longest Increasing Sub-Seq.

(use '[clojure.test])

(defn solve [coll]
  (let [diff    (map #(apply - %) (partition 2 1 coll)) ; [1]
        cnt-occ (->> diff                               ; [2]
                     (partition-by identity)
                     (map count))
        valid?  (>= (count (filter #(= -1 %) diff)) 1)  ; [3]
        max-val (apply max cnt-occ)                     ; [4]
        idx     (.indexOf cnt-occ max-val)]             ; [5]
    (if valid?                                          ; [6]
        (->> coll
          (drop idx)
          (take (inc max-val)))
        [])))


(deftest problem-53-test
  (is (= (solve [1 0 1 2 3 0 4 5]) [0 1 2 3]))
  (is (= (solve [5 6 1 3 2 7]) [5 6]))
  (is (= (solve [2 3 3 4 5]) [3 4 5]))
  (is (= (solve [7 6 5 4]) [])))

(print (run-tests))


; Description
; [1] Create pairs of values using `partition` and apply the difference in those pair,
; e.g. [1 0 1 2 3 0 4 5] => ((1 0) (0 1) (1 2) (2 3) (3 0) (0 4) (4 5)) => (1 -1 -1 -1 3 -4 -1),
; -1 tell us that it is consecutively increasing. [idea from](https://stackoverflow.com/questions/23712800/count-consecutive-occurence-of-element-in-collection)
; [2] Partition again by it identity, this will help us to group the same value and count each group,
; (1 -1 -1 -1 3 -4 -1) => ((1) (-1 -1 -1) (3) (-4) (-1)) => (1 3 1 1 1)
; [3] valid? count the difference -1 should more than 1.
; [4,5] find the max value and find the index of max value.
; [6] finally if valid?, drop values from idx position of max value and take total number of max-val (the most soncescutive of -1)
