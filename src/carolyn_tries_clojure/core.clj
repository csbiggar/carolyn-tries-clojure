(ns carolyn-tries-clojure.core
  (:gen-class))

(print (ns-name *ns*))                                      ;show the current namespace

(def hello-world "hello world")                  ;assign a variable

;(print (str hello-world " and good evening"))    ;concatenate 2 strings

(defn format-time
  "Given a number of seconds, display as nice string"
  [seconds]
  (str seconds " seconds")
  )
