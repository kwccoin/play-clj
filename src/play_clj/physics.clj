(ns play-clj.physics
  (:require [play-clj.g2d-physics :as p2d]
            [play-clj.g3d-physics :as p3d]
            [play-clj.utils :as u])
  (:import [com.badlogic.gdx.physics.box2d Body World]
           [play_clj.g3d_physics Body3D World3D]))

; this namespace is for internal use only. you should use the g2d-physics and
; g3d-physics namespaces directly, instead.

(defmulti add-body!
  (fn [screen body] (-> screen (u/get-obj :world) class)))

(defmethod add-body!
  World
  [screen b-def]
  (p2d/add-body! screen b-def))

(defmethod add-body!
  World3D
  [screen body]
  (p3d/add-body! screen body))

(defmulti body-position!
  (fn [entity a1 a2 a3] (-> entity (u/get-obj :body) class)))

(defmethod body-position!
  Body
  [entity x y angle]
  (p2d/body-position! entity x y angle))

(defmethod body-position!
  Body3D
  [entity x y z]
  (p3d/body-position! entity x y z))

(defmulti body-x!
  (fn [entity x] (-> entity (u/get-obj :body) class)))

(defmethod body-x!
  Body
  [entity x]
  (p2d/body-x! entity x))

(defmethod body-x!
  Body3D
  [entity x]
  (p3d/body-x! entity x))

(defmulti body-y!
  (fn [entity y] (-> entity (u/get-obj :body) class)))

(defmethod body-y!
  Body
  [entity y]
  (p2d/body-y! entity y))

(defmethod body-y!
  Body3D
  [entity y]
  (p3d/body-y! entity y))

(defmulti body-z!
  (fn [entity z] (-> entity (u/get-obj :body) class)))

(defmethod body-z!
  Body3D
  [entity z]
  (p3d/body-z! entity z))

(defmulti body-angle!
  (fn [entity angle] (-> entity (u/get-obj :body) class)))

(defmethod body-angle!
  Body
  [entity angle]
  (p2d/body-angle! entity angle))

(defmulti first-entity
  (fn [screen entities] (-> screen (u/get-obj :world) class)))

(defmethod first-entity
  World
  [screen entities]
  (p2d/first-entity screen entities))

(defmethod first-entity
  World3D
  [screen entities]
  (p3d/first-entity screen entities))

(defmulti second-entity
  (fn [screen entities] (-> screen (u/get-obj :world) class)))

(defmethod second-entity
  World
  [screen entities]
  (p2d/second-entity screen entities))

(defmethod second-entity
  World3D
  [screen entities]
  (p3d/second-entity screen entities))

(defmulti add-joint!
  (fn [screen joint] (-> screen (u/get-obj :world) class)))

(defmethod add-joint!
  World
  [screen j-def]
  (p2d/add-joint! screen j-def))

(defmulti step!
  (fn [screen & [entities]] (-> screen (u/get-obj :world) class)))

(defmethod step!
  World
  [screen & [entities]]
  (p2d/step! screen entities))

(defmethod step!
  World3D
  [screen & [entities]]
  (p3d/step! screen entities))

(def box-2d* p2d/box-2d*)
(defmacro box-2d [& body] `(p2d/box-2d ~@body))
(defmacro box-2d! [& body] `(p2d/box-2d! ~@body))
(defmacro body-def [& body] `(p2d/body-def ~@body))
(defmacro body! [& body] `(p2d/body! ~@body))
(defmacro joint-def [& body] `(p2d/joint-def ~@body))
(defmacro joint! [& body] `(p2d/joint! ~@body))
(defmacro fixture-def [& body] `(p2d/fixture-def ~@body))
(defmacro fixture! [& body] `(p2d/fixture! ~@body))

(def chain-shape* p2d/chain-shape*)
(defmacro chain-shape [& body] `(p2d/chain-shape ~@body))
(defmacro chain-shape! [& body] `(p2d/chain-shape! ~@body))
(def circle-shape* p2d/circle-shape*)
(defmacro circle-shape [& body] `(p2d/circle-shape ~@body))
(defmacro circle-shape! [& body] `(p2d/circle-shape! ~@body))
(def edge-shape* p2d/edge-shape*)
(defmacro edge-shape [& body] `(p2d/edge-shape ~@body))
(defmacro edge-shape! [& body] `(p2d/edge-shape! ~@body))
(def polygon-shape* p2d/polygon-shape*)
(defmacro polygon-shape [& body] `(p2d/polygon-shape ~@body))
(defmacro polygon-shape! [& body] `(p2d/polygon-shape! ~@body))


(def init-bullet p3d/init-bullet)
(def bullet-3d* p3d/bullet-3d*)
(defmacro bullet-3d [& body] `(p3d/bullet-3d ~@body))
(defmacro bullet-3d! [& body] `(p3d/bullet-3d! ~@body))
(def rigid-body* p3d/rigid-body*)
(defmacro rigid-body [& body] `(p3d/rigid-body ~@body))
(defmacro rigid-body! [& body] `(p3d/rigid-body! ~@body))
(def rigid-body-info p3d/rigid-body-info)
(def soft-body* p3d/soft-body*)
(defmacro soft-body [& body] `(p3d/soft-body ~@body))
(defmacro soft-body! [& body] `(p3d/soft-body! ~@body))
(def soft-body-info p3d/soft-body-info)

(def box-shape* p3d/box-shape*)
(defmacro box-shape [& body] `(p3d/box-shape ~@body))
(defmacro box-shape! [& body] `(p3d/box-shape! ~@body))
(def capsule-shape* p3d/capsule-shape*)
(defmacro capsule-shape [& body] `(p3d/capsule-shape ~@body))
(defmacro capsule-shape! [& body] `(p3d/capsule-shape! ~@body))
(def cone-shape* p3d/cone-shape*)
(defmacro cone-shape [& body] `(p3d/cone-shape ~@body))
(defmacro cone-shape! [& body] `(p3d/cone-shape! ~@body))
(def cylinder-shape* p3d/cylinder-shape*)
(defmacro cylinder-shape [& body] `(p3d/cylinder-shape ~@body))
(defmacro cylinder-shape! [& body] `(p3d/cylinder-shape! ~@body))
(def sphere-shape* p3d/sphere-shape*)
(defmacro sphere-shape [& body] `(p3d/sphere-shape ~@body))
(defmacro sphere-shape! [& body] `(p3d/sphere-shape! ~@body))
