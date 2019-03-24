(ns carolyn-tries-clojure.core
  (:gen-class))

(print (ns-name *ns*))                                      ;show the current namespace

(def hello-world "hello world")                  ;assign a variable

;(print (str hello-world " and good evening"))    ;concatenate 2 strings

(defn format-seconds
  "Given a number of seconds, display as nice string"
  [seconds]
  (cond
    (= seconds 1) (str seconds " second")
    :else (str seconds " seconds")
    )
  )


(defn format-minutes
  "Given a number of minutes, display as nice string"
  [minutes]
  (cond
    (= minutes 1) (str minutes " minute")
    :else (str minutes " minutes")
    )
  )

(defn format-time
  "Format a time"
  [input-seconds]

  (let [minutes (quot input-seconds 60) seconds (rem input-seconds 60)]

    (cond
      (= input-seconds 0) "none"
      (<= minutes 0) (format-seconds seconds)
      :else  (str (format-minutes minutes) " and " (format-seconds seconds))
      )
    )


  )
