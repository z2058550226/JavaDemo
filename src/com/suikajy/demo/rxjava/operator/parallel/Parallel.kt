package com.suikajy.demo.rxjava.operator.parallel

import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * parallel() function change the Flowable to the ParallelFlowable.
 * At the end of parallel operators, it need an sequential() function to change
 * the ParallelFlowable back to the normal Flowable.
 */
fun main() {
    Flowable.range(1, 10)
            .parallel()
            .runOn(Schedulers.computation())
            .map { it * it }
            .sequential()
            .blockingSubscribe(System.out::println)
}