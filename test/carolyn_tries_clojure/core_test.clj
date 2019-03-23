(ns carolyn-tries-clojure.core-test
  (:require [clojure.test :refer :all]
            [carolyn-tries-clojure.core :refer :all]))

(deftest format-string-tests
  (testing "should print out seconds"
    (is (= (format-time 23) "23 seconds")))
  (testing "should print out 1 second as singular"
    (is (= (format-time 1) "1 second")))
  )

(run-tests 'carolyn-tries-clojure.core-test)
