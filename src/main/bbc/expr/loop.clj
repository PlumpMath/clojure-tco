;;----------------------------------------------------------------------
;; File loop.clj
;; Written by Chris Frisz
;; 
;; Created 16 Apr 2012
;; Last modified 21 Apr 2012
;; 
;; Defines the record type and operations for 'loop' expressions in
;; the TCO compiler.
;;----------------------------------------------------------------------

(ns bbc.expr.loop
  (:require [bbc.protocol
             [pemit :as pemit]]))

(defrecord Loop [bind* body]
  pemit/PEmit
    (emit [this]
      (let [bind* (vec (map pemit/emit (:bind* this)))
            body (pemit/emit (:body this))]
        `(loop ~bind* ~body))))
