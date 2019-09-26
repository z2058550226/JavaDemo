package com.suikajy.demo.rxjava.operator.create

import com.suikajy.demo.util.Sleeper.sleep
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.functions.Consumer
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger

/**
 * defer() does not create the Observable until the observer subscribes, and create a fresh Observable for each observer
 */
fun main() {
    val defer = Observable.defer {
        Observable.interval(1, 1, TimeUnit.SECONDS).take(10)
    }
    defer.subscribe(::println)
    sleep(2)
    defer.subscribe(::println)
    sleep(10)
}

fun test1() {
    val count = AtomicInteger()

    Observable.range(1, 10)
            .doOnNext { count.incrementAndGet() }
            .ignoreElements()
            .andThen(Single.defer { Single.just(count.get()) }) // if here only use just, it will output 0.
            .subscribe(Consumer<Int> { println(it) })
}