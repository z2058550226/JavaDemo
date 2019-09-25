package com.suikajy.demo.rxjava.operator.basic

import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

fun main() {
    ignoreUpstreamResult()
}

fun ignoreUpstreamResult() {
    println(System.currentTimeMillis())
    Observable.interval(0, 1, TimeUnit.SECONDS)
            .take(3)
            .ignoreElements() // returns Completable
            .andThen(Observable.just(1, 2, 3)) // returns Observable<Int>
            .blockingSubscribe(::println)
    println(System.currentTimeMillis()) // delay 3 seconds
}