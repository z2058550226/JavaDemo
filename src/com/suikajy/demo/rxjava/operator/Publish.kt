package com.suikajy.demo.rxjava.operator

import com.suikajy.demo.util.Sleeper
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

fun main() {
    val connectableObservable = Observable
            .interval(0, 1, TimeUnit.SECONDS)
            .take(10)
            .publish()

    val connectDisposable = connectableObservable.connect() // if you want to stop the upstream, dispose this object.

    Sleeper.sleep(2)
    val disposable1 = connectableObservable
            .observeOn(Schedulers.io())
            .subscribe(::println)
    Sleeper.sleep(5)
    connectableObservable.observeOn(Schedulers.trampoline())
            .subscribe {
                println("sub2: $it")
            }
    disposable1.dispose()
    Sleeper.sleep(5)
}