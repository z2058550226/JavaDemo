package com.suikajy.demo.rxjava.hotobservable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

import static com.suikajy.demo.util.Sleeper.sleep;

/**
 * replay() will replay the event the subscriber did not received
 */
public class Reply {

    public static void main(String[] args) {
        Observable<Long> longObservable = Observable.interval(0, 1, TimeUnit.SECONDS)
                .take(10)
                .replay()
                .refCount();

        sleep(2);

        Disposable disposable1 = longObservable.subscribe(aLong -> System.out.println("sub1: " + aLong));
        sleep(3);
        Disposable disposable2 = longObservable.subscribe(aLong -> System.out.println("sub2: " + aLong));
        sleep(2);
        disposable1.dispose();

        sleep(4);
    }

}
