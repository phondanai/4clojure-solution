; Problem 58, Function Composition
; Special Restrictions : comp

(use '[clojure.test])

(defn solve [f & fs] ; 0
  (if fs
    (fn [& a] (f (apply (apply solve fs) a))) ; 1
    (fn [& a] (apply f a)))) ; 2

(deftest problem-58
  (is (= [3 2 1] ((solve rest reverse) [1 2 3 4])))
  (is (= 5 ((solve (partial + 3) second) [1 2 3 4])))
  (is (= true ((solve zero? #(mod % 8) +) 3 5 7 9)))
  (is (= "HELLO" ((solve #(.toUpperCase %) #(apply str %) take) 5 "hello world")))
  )

(run-tests)

; I am having a hard time with this problem.
; This is a `comp` implementation for sure, which look like this (g (f args)), as many of g, f.
; Let's break it down.
;; We need a function that can have variadic argument (functions) #0.
;; We also need a function that can have variadic argument (arguments) #1 and #2.

;; info, (apply + [1 2 3]) equivalent to (+ 1 2 3)
;; so, (apply take '(5 "hello world")) => (take 5 "hello world"). <- This take time for me to understand. 

;; normally, (apply reverse [1 2 3 4]) is error, but
;; ((fn [& a] (apply reverse a)) [1 2 3 4]) is work like a charm. eqv to -> (apply reverse '([1 2 3 4]))


