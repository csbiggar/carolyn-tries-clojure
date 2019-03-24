(ns carolyn-tries-clojure.core
  (:gen-class))

(defn format-unit-with-measure
  "Given a quantity and a unit of measure, format it accounting for the singular"
  [quantity unit]

  (cond
    (= quantity 0) ""
    (= quantity 1) (str quantity " " unit)
    :else (str quantity " " unit "s")
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

(defn split-by-time-unit
  "Given seconds, split into an array of hours, minutes, seconds etc"
  [input-seconds]
  (let [hours (quot input-seconds 3600)
        minutes (- (quot input-seconds 60) (* hours 60))
        seconds (rem input-seconds 60)
        ]
    (remove clojure.string/blank? [(format-hours hours) (format-minutes minutes) (format-seconds seconds)])
    )
  )

(defn format-time
  "Format a time"
  [input-seconds]
  (let [time-unit-components (split-by-time-unit input-seconds)]
    (cond
      (= input-seconds 0) "none"
      (= (count time-unit-components) 1) (first time-unit-components)
      :else (str (str (clojure.string/join ", " (drop-last time-unit-components))) " and " (last time-unit-components))
      )
    )
  )
