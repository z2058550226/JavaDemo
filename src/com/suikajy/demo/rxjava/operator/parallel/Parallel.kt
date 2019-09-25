package com.suikajy.demo.rxjava.operator.parallel

import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * Practically, parallelism in RxJava means running independent flows and merging their results back into a single flow.
 *
 * parallel() function change the Flowable to the ParallelFlowable.
 * At the end of parallelled operators, it need an sequential() function to change
 * the ParallelFlowable back to the normal Flowable.
 *
 * This feature is like the Stream of the Java8.
 */
fun main() {
    Flowable.range(1, 10)
            .parallel()
            .runOn(Schedulers.computation())
            .map {
                println(Thread.currentThread())
                it * it
            }
            .sequential()
            .blockingSubscribe(::println)
}

fun traditionalWay() {
    Flowable.range(1, 10)
            .flatMap { v ->
                Flowable.just(v)
                        .subscribeOn(Schedulers.computation())
                        .map { it * it }
            }
            .blockingSubscribe(::println)
}