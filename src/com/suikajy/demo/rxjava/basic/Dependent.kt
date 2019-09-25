package com.suikajy.demo.rxjava.basic

import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.functions.Consumer
import java.util.concurrent.atomic.AtomicInteger

fun main() {
    deferredDependent2()
}

fun typical() {
    Flowable.just(1)
            .flatMap { Flowable.just(it.toString()) }
            .flatMap { Flowable.just("$it $it") }
            .blockingSubscribe(::println)
}

/**
 * It is often the case also that later sequences would require values from earlier mappings.
 * This can be achieved by moving the outer flatMap into the inner parts of the previous flatMap for example:
 */
fun jumpDependent() {
    Flowable.just(2)
            .flatMap { value ->
                Flowable.just(value + 1)
                        .flatMap { next -> Flowable.just(next * value) }
            }
            .blockingSubscribe(::println)
}

// non-dependent see the Completable.kt

/**
 * Sometimes, there is an implicit data dependency between the previous sequence and the new sequence that, for some
 * reason, was not flowing through the "regular channels". One would be inclined to write such continuations as follows:
 */
fun wrongDeferredDependent() {
    val count = AtomicInteger()

    Observable.range(1, 10)
            .doOnNext { count.incrementAndGet() }
            .ignoreElements()
            .andThen(Single.just(count.get()))
            .subscribe(Consumer<Int> { println(it) })
    // it will output 0, because Single.just(count.get()) is run in
    // assembly time.
}

fun deferredDependent() {
    val count = AtomicInteger()

    Observable.range(1, 10)
            .doOnNext { count.incrementAndGet() }
            .ignoreElements()
            .andThen(Single.defer { Single.just(count.get()) })
            .subscribe(Consumer<Int> { println(it) })
}

fun deferredDependent2() {
    val count = AtomicInteger()

    Observable.range(1, 10)
            .doOnNext { count.incrementAndGet() }
            .ignoreElements()
            .andThen(Single.fromCallable(count::get))
            .subscribe(Consumer<Int> { println(it) })
}