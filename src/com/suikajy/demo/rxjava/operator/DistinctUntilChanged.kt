package com.suikajy.demo.rxjava.operator

import io.reactivex.Observable
import io.reactivex.functions.Function
import javax.xml.crypto.AlgorithmMethod
import javax.xml.crypto.KeySelector
import javax.xml.crypto.KeySelectorResult
import javax.xml.crypto.XMLCryptoContext
import javax.xml.crypto.dsig.keyinfo.KeyInfo


fun main() {
    val obCommon = Observable.just(ElementCommon(1, "one"), ElementCommon(2, "two"),
            ElementCommon(1, "one"), ElementCommon(3, "three"),
            ElementCommon(4, "four"), ElementCommon(2, "two"))

    val obDC = Observable.just(ElementDC(1, "one"), ElementDC(1, "one"), ElementDC(2, "two"),
            ElementDC(1, "one"), ElementDC(3, "three"),
            ElementDC(4, "four"), ElementDC(2, "two"))

    obCommon.distinct(object : Function<ElementCommon, Any> {
        override fun apply(p0: ElementCommon): Any {
            return p0.id
        }
    })
            .subscribe { println(it) }

    obDC.distinctUntilChanged()
            .subscribe { println(it) }
}

data class ElementDC(val id: Int, val name: String)

class ElementCommon(val id: Int, val name: String) {
    override fun toString(): String {
        return "ElementCommon(id=$id, name='$name')"
    }
}