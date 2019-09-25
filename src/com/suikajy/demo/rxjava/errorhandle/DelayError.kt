package com.suikajy.demo.rxjava.errorhandle

import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

fun main() {
    test1()
}

fun test1() {
    val rangeOb = Flowable.interval(0, 1, TimeUnit.SECONDS).take(10)

    rangeOb.flatMap({
        if (it % 2 == 0L) Flowable.error<Exception>(Exception("test exception"))
        else Observable.just(it).toFlowable(BackpressureStrategy.BUFFER)
    }, true)
            .blockingSubscribe(::println) { throwable ->
                println("onError")
                throwable.printStackTrace()
            }
}