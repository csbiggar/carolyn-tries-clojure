(ns carolyn-tries-clojure.core-test
  (:require [clojure.test :refer :all]
            [carolyn-tries-clojure.core :refer :all]))

(deftest format-string-tests
  (testing "should print out seconds"
    (is (= (format-time 23) "23 seconds")))
  (testing "should print out 1 second as singular"
    (is (= (format-time 1) "1 second")))
  (testing "should print out 0 seconds as none"
    (is (= (format-time 0) "none")))
  (testing "should split into minutes if > 59 seconds"
    (is (= (format-time 123) "2 minutes and 3 seconds")))
  (testing "should show 1 minute as singular"
    (is (= (format-time 70) "1 minute and 10 seconds")))
  (testing "should omit seconds if a whole number of minutes"
    (is (= (format-time 120) "2 minutes")))
  )

(run-tests 'carolyn-tries-clojure.core-test)
