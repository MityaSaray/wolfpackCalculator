(ns wolfpack-calculator-client.components.index
  (:require [reagent.core :as reagent]
            [wolfpack-calculator-client.components.inputComponent :as iC]
            [wolfpack-calculator-client.components.outputComponent :as oC]
            [wolfpack-calculator-client.services.calc-service :as C]))

(defonce state (reagent/atom {:ship-length        0
                              :ship-visible-angle 0
                              :ship-speed-abs     0
                              :sub-speed          0
                              :delta-L            0
                              :AOB                0
                              :mast-height        0
                              :mast-angle         0
                              :seconds-to-cross   0}))


(defn update-value! [key value]
  (swap! state assoc-in [key] value))

(defn do-calculation! [zoom]
  (println zoom)
  (let [mult (if zoom 4 1)
        {:keys [ship-length ship-visible-angle mast-height mast-angle seconds-to-cross]} @state
        delta-l (C/dist (* mult mast-height) mast-angle)
        aob (C/AOB ship-length ship-visible-angle delta-l)]
    (swap! state assoc
           :AOB aob
           :delta-L delta-l
           :ship-speed-abs (C/calculate-ship-speed ship-length seconds-to-cross aob))))

(defn index []
  (let [app-state state]
    [:div {:style {:display         "flex"
                   :justify-content "space-evenly"}}
     [iC/main update-value! do-calculation!]
     [oC/main app-state]]))



