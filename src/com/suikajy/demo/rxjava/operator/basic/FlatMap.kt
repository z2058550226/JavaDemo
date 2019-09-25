package com.suikajy.demo.rxjava.operator.basic

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

fun main() {
    Observable.range(1, 3)
            .flatMapSingle {
                Single.just(it).map(Int::toString)
            }.blockingSubscribe(::println)
}