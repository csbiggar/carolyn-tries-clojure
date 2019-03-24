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

(defn format-days
  [days]
  (format-unit-with-measure days "day")
  )

(defn format-years
  [years]
  (format-unit-with-measure years "year")
  )

(def seconds-in-minute 60)
(def minutes-in-hour 60)
(def hours-in-day 24)
(def days-in-year 365)

(def seconds-in-hour (* seconds-in-minute minutes-in-hour))
(def seconds-in-day (* seconds-in-hour hours-in-day))
(def seconds-in-year (* seconds-in-day days-in-year))

(def minutes-in-day (* minutes-in-hour hours-in-day))
(def minutes-in-year (* minutes-in-day days-in-year))

(def hours-in-year (* hours-in-day days-in-year))

(defn split-by-time-unit
  "Given seconds, split into an array of hours, minutes, seconds etc"
  [input-seconds]
  (let [
        years (quot input-seconds seconds-in-year)
        days (- (quot input-seconds seconds-in-day) (* years days-in-year))
        hours (- (quot input-seconds seconds-in-hour) (* days hours-in-day) (* years hours-in-year))
        minutes (- (quot input-seconds seconds-in-minute) (+ (* hours minutes-in-hour) (* days minutes-in-day) (* years minutes-in-year)))
        seconds (rem input-seconds 60)
        ]
    (remove clojure.string/blank? [(format-years years) (format-days days) (format-hours hours) (format-minutes minutes) (format-seconds seconds)])
    )
  )

(defn format-time
  [input-seconds]
  (let [time-unit-components (split-by-time-unit input-seconds)]
    (cond
      (= input-seconds 0) "none"
      (= (count time-unit-components) 1) (first time-unit-components)
      :else (str (str (clojure.string/join ", " (drop-last time-unit-components))) " and " (last time-unit-components))
      )
    )
  )

(defn -main
  "Prompt user for some seconds then format them nicely into years, days, hours, minutes & seconds"
  [& args]
  (let [string-seconds (do (print "Welcome! Enter seconds to see them beautifully formatted: ") (flush) (read-line))]
    (println (format-time (Long/parseLong string-seconds))))
  )
