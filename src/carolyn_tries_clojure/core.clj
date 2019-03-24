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

(defn format-time
  "Format a time"
  [input-seconds]

  (let [minutes (quot input-seconds 60) seconds (rem input-seconds 60)]

    (cond
      (= input-seconds 0) "none"
      (<= minutes 0) (format-seconds seconds)
      (<= seconds 0) (format-minutes minutes)
      :else (str (format-minutes minutes) " and " (format-seconds seconds))
      )
    )
  )
