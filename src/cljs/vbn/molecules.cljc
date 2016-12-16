(ns vbn.molecules
  (:require [rum.core :as rum]
            [vbn.atoms :as atom] ))


(rum/defc our-definition [content]
  [:div content])

(rum/defc three-dimensions [content]
  [:div content])


(rum/defc blurb-title-second [content]
  (let [{:keys [image alt-text title text cta]} content]
    [:div.blurb
     [:.img-container
      (atom/blurb-image image alt-text)]
     [:div.image-title-text-cta
      [:h3 title]
      text
      [:button [:span cta]]]]))

(rum/defc page-intro [& content]
  (conj [:div {:style {:align-items 'center}}]
        content))


