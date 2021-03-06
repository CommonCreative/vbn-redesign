(ns vbn.web
  #?(:cljs (:require-macros  [vbn.styler :refer [css at-media]]))
  (:require [rum.core :as rum]
            [vbn.atoms :as atom]
            [vbn.molecules :as molecule]
            #?(:clj [vbn.styler :refer [css at-media get-css-str]])))

(def pricing-options [(css  {:border-style "outset"
                             :border-width "0.4em"
                             ;; FIXBELOW - make brand-color
                             :border-color "green"
                             :border-radius "0.5em"
                             :align-items "center"
                             :padding "1em"
                             ;; FIXBELOW - make brand-dark
                             :background "black"
                             :color "white"
                             :width "19em"})])

(def inside-three [(css {:margin-top "2rem"})
                   (at-media {:min-width "60rem"} {:margin-top 0
                                                   :padding "1em"
                                                   :max-width "16em"})
                   (at-media {:min-width "120rem"} {:font-size "0.8rem"})])


(def inside-three-four [(css {:margin-top "2rem"})
                        (at-media {:min-width "60rem"} {:margin-top 0
                                                        :padding "1em"
                                                        :max-width "19em"})
                        (at-media {:min-width "120rem"} {:font-size "0.8rem"})])

(def column-four [(css {:flex-direction "row"
                        :flex-wrap "wrap"
                        :justify-content "space-around"
                        :width "100%"})
                  (at-media {:min-width "120rem"} {:margin-top 0
                                                   :width "50%"})])








;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;   PAGE COMPONENTS   ;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(rum/defc icon-title-text [title text]
 [:div title text])

(rum/defc process-h3 [text]
  [:h3 {:class [(at-media {:min-width "60rem"} {:font-size "1.4em"})]}  text])


(rum/defc process [img title text]
  [:div {:class inside-three} img title text])



;;;;;;;;;
;;;;;;;;;   OUR PROCESS
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;



(rum/defc our-process []
  [:div. {:class ["full-width"
                  (css {:color "white"
                        :background-color "#3a539b"})]}
   ;{:style {:margin-top "0"}}
   [:div {:class [(css {:width "100vw"
                        :max-width "53em"
                        :align-self "center"
                        :padding-left "1.5em"
                        :padding-right "1.5em"
                        :padding-top "4.5em"
                        :padding-bottom "4.5"})
                  (at-media {:min-width "120rem"} {:max-width "110rem"})]}
    [:h2.center "Our Process"]

    [:p.center "We focus on immediate feedback throughout our entire  process. As such it is highly iterative and interactive from the very beginning. You are completely engaged throughout the entire process. When you start with us after the initial consult we provide you with a completely interactive unfinished design prototype. From here we progressively evolve this prototype togther to produce a design that feels almost real. Knowing this is exactly what you want we begin the final stage of actually building your website or application."]

    [:div {:class (at-media {:min-width "60rem"} {:flex-direction "row"
                                                  :flex-wrap "wrap"
                                                  :justify-content "space-around"})}

     (process
       (atom/visual-language)
       (process-h3 "Visual Language")
       [:p "Starting with the initial consult we review the visual language your business currently has or what is missing. From here we develop the unique style of your website or application in a way that can easily be reviewed and evolve years later."])


     (process
       (atom/mock-up)
       (process-h3 "Mock-up")
       [:p "Bringing your unique style and information architecture together we create the first real representation of what the final product will look like using real or representative information."])

     (process
       (atom/micro-interactions)
       (process-h3 "Micro-interactions")
       [:p "Once we have established the look and flow of your website or application we can focus on micro-interactions. It is here that you can truly set yourself apart. We create small interactive and intelligent animations. This is what delights your users."])

     (process
       (atom/develop)
       (process-h3 "Develop and Deploy")
       [:p "Throughout the entire process we develop finalised designs to ensure it is completed as quickly as possible. At this stage we add the final touches and then release your website or application into the wild. "])

     (process
       (atom/happy-days)
       (process-h3 "Happy Days")
       [:p "You can rest easy knowing you’ve made the best choice."])



     [:div {:class inside-three}
      (atom/happy-days)
      (icon-title-text
       [:h3 {:class [(at-media {:max-width "60rem"} {:align-self "center"})
                     (at-media {:min-width "60rem"} {:font-size "1.4em"})]} "Information Architecture"]
       [:p "Starting with the initial consult we establish the current state of your business and it’s future plans. From here we can design the structure of the information on your website or application to ensure that it achieves your current and future business objectives/ desired goals. "])]]]])






;;;;;;;;;
;;;;;;;;;   REASONS TO CHOOSE
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(rum/defc reason [img text]
  [:div {:class inside-three-four} img text])

(rum/defc reason-h3 [text]
  [:h3 {:class [(at-media {:max-width "60rem"} {:align-self "center"})]}
   text])


;;;;
;;;;   FULL SLICE
;;;;

(rum/defc reasons-to-choose-us []
  [:div.full-width
   [:div {:class [(css {:width "100vw"
                        :max-width "53em"
                        :align-self "center"
                        :padding-left "1.5em"
                        :padding-right "1.5em"
                        :padding-top "4.5em"
                        :padding-bottom "4.5"})
                  (at-media {:min-width "120rem"} {:max-width "110rem"})]}
    (atom/h2-home "4 Reasons to Choose Us")
    [:div.four-up
     (reason
       (atom/rock-solid)
       (icon-title-text
        (reason-h3 "Rock Solid Foundations")
        [:div
         [:p "Built on the most reliable
      technology the web has to offer."]
         [:p "Seamlessly grow from a simple blog to an international phenomenom without ever noticing a difference in speed or crashing."]]))
     (reason
       (atom/bird)
       (icon-title-text
         (reason-h3 "Speed Matters")
        [:div
         [:p "Your website will load faster than the rest. We strive for a sub 2 second load time."]
         [:p "Over 50% of mobile users will abandon sites that take longer than 3 seconds to load. Sites that load faster have longer user sessions and can more than double revenue generated from sales or ads."]]))
     (reason
       (atom/safe)
       (icon-title-text
         (reason-h3 "Ultra Secure")
        [:div
         [:p "We provide bulletproof security. Your visitors can rest easy knowing your site will never have any malware."]
         [:p "The possibilities of your site being hacked or taken down are eliminated and significantly reduced with a very smart system design and advanced protection."]]))
     (reason
       (atom/evolve)
       (icon-title-text
         (reason-h3 "Designed to Evolve")
        [:div
         [:p "Evolve from a simple website to an online application. Then jump from the web into a phone, tablet, desktop or TV!"]
         [:p "Our system allows your business to grow without any major technology changes or massive rewrites."]]))]]])


;;;;;;;;;
;;;;;;;;;  PRINCIPLES
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(rum/defc principles []
  [:div {:class ["full-width"
                 "buffer-top-large"
                 (css {:color "white"
                       :background-color "#333D47"})]}
   [:div {:class [(css {:width "100vw"
                        :max-width "53em"
                        :align-self "center"
                        :padding-left "1.5em"
                        :padding-right "1.5em"
                        :padding-top "4.5em"
                        :padding-bottom "4.5"})]}
    [:h2.center "We have two guiding principles"]
    [:div {:class [(css {:flex-direction "row"
                         :justify-content "space-between"})]}

     [:div {:class [(css {:width "45%"
                          :margin-top "1.5rem"})]}
      ;.principle.make-top-margin
      [:h3 "Speed"]
      [:p "We emphasize speed throughout our development process and in our final product."]
      [:p "Immediate feedback on a design results in a smoother creative flow and is the difference between testing all the ideas both you and our team have or just the ones we have time for. "]
      [:p "Today more people visit websites or use applications on their mobiles instead of desktops. This means much slower download speeds resulting in very slow loading times and a bad user experience. People expect things to load in under 2 seconds and we can meet these expectations."]]


     [:div {:class [(css {:width "45%"})]}
      [:h3 "Simplicity"]
      [:p "A well designed solution is always the most simple. Often decisions are based on what is the most flashy or easiest option. The hidden side of these decisions is the result of visual and technical systems which lack the ability grow, evolve, adapt and be maintained."]
      [:p "At VBN we choose the minimal set of tools necessary to get the job done and we carry this minimalism right through to the products we deliver. The flexibility this process provides is umatched for the budgets we can work with."]]]]])


;;;;;;;;;
;;;;;;;;;   CONTACT FORM
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;;;
;;;;   FULL SLICE
;;;;

(rum/defc contact-form []
  [:div.block-green.full-width
   [:div {:class [(css {:width "100vw"
                        :max-width "53em"
                        :align-self "center"
                        :padding-left "1.5em"
                        :padding-right "1.5em"
                        :padding-top "4.5em"
                        :padding-bottom "4.5"
                        :align-items "center"})]}
    [:h2 "What are you waiting for?"]
    [:div.form-width
     [:form {:name "contact"
             "netlify" true}
      [:p
       [:label "Your Name:"]
       [:input {:type "text"
                :name "name"}]]
      [:p
       [:label "Your Email:"]
       [:input {:type "email"}]]

      [:p
       [:label "Let us know what your dreaming up"]
       [:textarea {:class [(css {:min-height "6em"
                                 :max-width "100%"})]
                   :name "message"}]]

      [:p
       [:button [:span "Send"]]]]]]])



;;;;;;;;;
;;;;;;;;;   PRICING SECTION
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


(rum/defc feature [text]
  [:li {:class [(css {:line-height "1.5em"})]} text])

(rum/defc pricing-option [amount type feature-list]
  [:div {:class inside-three-four}
   [:div {:class pricing-options}
    [:div {:class [(css {:flex-direction "row"})]}
     (atom/dollar)
     [:h3 {:class [(css {:margin-top 0})]} amount]]
    [:span type]]
   feature-list])

 ;;;;
 ;;;;  FULL SLICE
 ;;;;

(rum/defc pricing []
  [:div.center-items.buffer-top-large
   [:h2 "What's the cost?"]
   [:p "Everyone has different needs so it will almost always end up with a custom quote. However in the interest of saving both of us time we have provided you with prices for a variety of general website combinations. These prices are based on a typical website and conditions apply with respect to upkeep fees. Prices are introductory and will change in the future."]

   [:div {:class pricing-options}
    ;.circle
    (atom/dollar) [:h3 {:class [(css {:margin-top 0})]} "250"]]  ; FIXBELOW <- won't need the margin top when fixing global styles + also in pricing list
   [:span
    {:class [(css {:font-size "1.5em"})]}
   ;.initial-consult
    "Initial Consult"]
   [:p "Our initial consultation covers up to two hours discussion regarding your needs and any preliminary designing. We offer so much value it is impossible for us to do this for free. We provide a detailed info sheet following the initial consult and any designs done will also be provided to you in PDF format. This means you can easily take all that value to another studio of give it to a friend doing your website."]
   [:p "If you still love us and want to continue. Rest assured that this money goes towards your final payment."]]


  [:div {:class [(css {:padding-left "1.5em"
                       :padding-right "1.5em"})]}

   [:div {:class column-four}
    (pricing-option "3000" "Simple Site"
      [:ul
       (feature "Without a CMS")
       (feature "Custom Site Design")
       (feature "Custom domain that you own")
       (feature "You own the site code")
       (feature "Never pay any upkeep fees")])
    (pricing-option "3800" "Dynamic Site"
      [:ul
       (feature "Without a CMS")
       (feature "Custom Site Design")
       (feature "Custom domain that you own")
       (feature "You own the site code")
       (feature "Never pay any upkeep fees")])]

   [:div {:class column-four}
     (pricing-option "4800" "Dynamic Site +"
        [:ul
         (feature "Without a CMS")
         (feature "Custom Site Design")
         (feature "Custom domain that you own")
         (feature "You own the site code")
         (feature "Never pay any upkeep fees")])
     (pricing-option "4500" "Dynamic Site + E commerce"
       [:ul.pricing-features
        (feature "Advanced CMS")
        (feature "Custom Site Design")
        (feature "Custom domain that you own")
        (feature "You own the site code")
        (feature "Upkeep starts at 2% of transactions with a minimum of 10 dollars (excluding fees from your choice of payment gateway).
  Non-profits, schools or crowdfunding projects are exempt from the minimum 10 dollars and the fee is reduced to 1.5%. ")])]])






;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;   FULL PAGE CONTENT   ;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;



(rum/defc content []
  [:main#main
   (molecule/page-intro
    [:h1 "Web & App"]
    [:p "It’s a jungle out there! Branding and the technology are often viewed as two separate pieces with the quality of one sacrificed for the other. However effective storytelling requires both the branding and the technology to live in harmony. The ever evolving landscape of technology has left many businesses with dated, fragmented and inconsistent technology."])

   (reasons-to-choose-us)
   (principles)
   (our-process)
   (pricing)
   (contact-form)])
