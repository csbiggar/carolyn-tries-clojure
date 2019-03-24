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

  (testing "should split into hours if > 59 minutes"
    (is (= (format-time 3662) "1 hour, 1 minute and 2 seconds")))
  (testing "should omit minutes and seconds if a whole number of hours"
    (is (= (format-time 3600) "1 hour")))
  (testing "should omit minutes if hours and seconds only"
    (is (= (format-time 3604) "1 hour and 4 seconds")))
  (testing "should print out multiple hours as plural"
    (is (= (format-time 7200) "2 hours")))


  (testing "should split into days if > 23 hours"
    (is (= (format-time 90062) "1 day, 1 hour, 1 minute and 2 seconds")))

  )

(run-tests 'carolyn-tries-clojure.core-test)
