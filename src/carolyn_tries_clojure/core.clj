(ns carolyn-tries-clojure.core
  (:gen-class))

(defn format-unit-with-measure
  "Given a quantity and a unit of measure, format it including accounting for the singular"
  [quantity unit]

  (if (= quantity 1)
    (str quantity " " unit)
    (str quantity " " unit "s")
    )
  )

(defn format-seconds
  [seconds]
  (format-unit-with-measure seconds "second")
  )

(defn format-minutes
  [minutes]
  (format-unit-with-measure minutes "minute")
  )

(defn format-hours
  [hours]
  (format-unit-with-measure hours "hour")
  )

(defn format-time
  "Format a time"
  [input-seconds]

  (let [hours (quot input-seconds 3600)
        minutes (- (quot input-seconds 60) (* hours 60))
        seconds (rem input-seconds 60)        ]

    (cond
      (= input-seconds 0) "none"
      (and (> hours 0) (= minutes 0) (= seconds 0) ) (format-hours hours)
      (and (= hours 0) (= minutes 0) (> seconds 0)) (format-seconds seconds)
      (and (= hours 0) (> minutes 0) (= seconds 0)) (format-minutes minutes)
      (and (> hours 0) (= minutes 0) (> seconds 0)) (str (format-hours hours) " and " (format-seconds seconds))
      (and (= hours 0) (> minutes 0) (> seconds 0)) (str (format-minutes minutes) " and " (format-seconds seconds))
      :else (str (format-hours hours) ", " (format-minutes minutes) " and " (format-seconds seconds))
      )
    )
  )
