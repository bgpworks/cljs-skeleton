(ns app.core
  (:require [reagent.core :as r]))

(defn counter []
  (let [c (r/atom 0)]
    (fn []
      [:div.counter
       [:button.btn
        {:on-click (fn [] (swap! c dec))}
        "-"]
       [:span
        {:style {:font-size "40px"
                 :margin "10px"}}
        @c]
       [:button.btn
        {:on-click (fn [] (swap! c inc))}
        "+"]])))

(defn hello []
  [:div
   {:style {:text-align "center"}}
   [:h1 "안녕하세요!"]
   [:p "Clojurescript의 reagent(react)를 이용하여 렌더링 합니다."]

   [:h2 "Counter 예제"]
   [counter]])

(defn ^:dev/after-load render
  "Render the toplevel component for this app."
  []
  (reagent.dom/render [hello] (.getElementById js/document "app")))

(defn ^:export main
  "Run application startup logic."
  []
  (render))
