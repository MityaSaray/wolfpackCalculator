(ns wolfpack-calculator-client.services.calc-service)

(defn to-angle [radians]
  (/ (* radians 180) Math/PI))

(defn arcsin-to-deg [leg hypotenuse]
  (to-angle (Math/acos
              (/ leg hypotenuse))))

(defn get-projection-l [angle measured-distance]
  (*
    (Math/sin
      (/ angle 100))
    measured-distance))


(defn AOB [l-abs projection-angle l-measured]
  (let [l-project (get-projection-l projection-angle l-measured)
        lambda1 (arcsin-to-deg l-project l-abs)
        lambda2 (arcsin-to-deg l-project l-measured)]
    (- 180 lambda1 lambda2)))

(defn dist [mast-height mast-angle]
  (* 100 (/ mast-height mast-angle)))

(defn calculate-ship-speed [length time AOB]
  (let [ship-speed-nm (* 1.94 (/ length time))]
    (/ ship-speed-nm (Math/sin (/ (* AOB Math/PI) 180)))))

