package com.suikajy.demo.rxjava.hotobservable;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

import static com.suikajy.demo.util.Sleeper.sleep;

/**
 * share is equal to the someObservable.publish().refCount()
 */
public class Share {

    public static void main(String[] args) {
        Observable<Long> longObservable = Observable.interval(0, 1, TimeUnit.SECONDS)
                .take(10)
                .share();
        sleep(2);

        Disposable disposable1 = longObservable.subscribe(aLong -> System.out.println("sub1: " + aLong));
        sleep(3);
        Disposable disposable2 = longObservable.subscribe(aLong -> System.out.println("sub2: " + aLong));
        sleep(1);
        disposable1.dispose();

        sleep(4);
    }

}
