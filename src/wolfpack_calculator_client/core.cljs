(ns wolfpack_calculator_client.core
  (:require [reagent.core :as reagent :refer [atom]]
            [wolfpack-calculator-client.components.index :as app]))

(enable-console-print!)

(defn hello-world []
  [app/index])

(reagent/render-component [hello-world]
                          (. js/document (getElementById "app")))

(defn on-js-reload [])
;; optionally touch your app-state to force rerendering depending on
;; your application
;; (swap! app-state update-in [:__figwheel_counter] inc)
