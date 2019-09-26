package com.suikajy.demo.rxjava.operator.errorhandle

import com.suikajy.demo.rxjava.operator.logiccontrol.ElementDC
import com.suikajy.demo.util.Sleeper.sleep
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.functions.BiFunction
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.PublishSubject


fun main() {
    networkTest()
}

/**
 * This test is from https://android.jlelse.eu/rx-grokking-retrywhen-and-repeatwhen-on-android-development-examples-af5c3ed0872b
 */
fun networkTest() {
    // Suppose net connection is game over.
    val isNetError = true

    val retrySubject = PublishSubject.create<Int>().toSerialized()

    val netCall = Observable.create<ElementDC> { emitter ->
        println("start to connect network....")
        sleep(1)
        if (isNetError) {
            emitter.onError(IllegalArgumentException("network error."))
        } else {
            emitter.onNext(ElementDC(1, "one"))
        }
        emitter.onComplete()
    }

    val getSomethingReallyHuge = Observable.create<String> {
        println("start to read huge file....")
        sleep(2)
        it.onNext("huge string")
        it.onComplete()
    }

    Observable.combineLatest(
            netCall.subscribeOn(Schedulers.io())
                    .doOnError {
                        print("network error type 'r' to retry: ")

                        with(readLine() ?: "") {
                            if (this == "r") {
                                println("you typed 'r'")
                                retrySubject.onNext(0)
                            } else println("network error exit.")
                        }
                    }
                    .retryWhen { retryHandler ->
                        retryHandler.zipWith(retrySubject, BiFunction<Throwable, Int, Int> { _, t2 -> t2 })
                    },
            getSomethingReallyHuge.subscribeOn(Schedulers.io())
                    .retryWhen { retryHandler -> retryHandler.flatMap { retrySubject } },
            BiFunction<ElementDC, String, ElementDC> { p0, p1 -> ElementDC(p0.id, p1) }
    ).blockingSubscribe(::println, Throwable::printStackTrace)
}