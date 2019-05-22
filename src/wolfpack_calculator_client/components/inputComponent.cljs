(ns wolfpack-calculator-client.components.inputComponent
  (:require [reagent.core :as r]))

(def mapKeys [:ship-length :ship-visible-angle :mast-height :mast-angle :seconds-to-cross])

(defn input [key on-change]
  [:div
   [:h3 (str "Enter " (name key))]
   [:input
    {:type      :text
     :name      key
     :on-change (fn [e]
                  (on-change key (-> e .-target .-value)))}]])

(defn main [set-value! do-calculation!]
  (let [zoom (r/atom false)]
    [:div
     (for [key mapKeys] [:div {:key key} [input key set-value!]])
     [:div
      "Zoom"
      [:input
       {:type      :checkbox
        :on-change (fn []
                     (swap! zoom not))}]]
     [:button
      {:type     :button
       :name     "Calculate"
       :on-click (fn []
                   (do-calculation! @zoom))}
      "Start calculation"]]))
