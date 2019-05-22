(ns wolfpack-calculator-client.components.outputComponent
  (:require [reagent.core :as r]))

(defn main [state]
  [:div
   [:p "Distance to target is " (:delta-L @state) " meters"]
   [:p "Angle on bow is " (:AOB @state) " degrees"]
   [:p "Target speed is " (:ship-speed-abs @state) " NM"]])