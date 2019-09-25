package com.suikajy.demo.rxjava.hotobservable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

import static com.suikajy.demo.util.Sleeper.sleep;


/**
 * When the number of subscriber is equal to the parameter 'numberOfSubscribers' autoConnect() start to
 * connect() the publisher.
 * the numberOfSubscriber is 1 by default.
 * <p>
 * When the autoConnect() has no subscriber, it will continue emitting.
 */
public class AutoConnect {

    public static void main(String[] args) {

        Observable<Long> longObservable = Observable.interval(0, 1, TimeUnit.SECONDS)
                .take(10)
                .publish()
                .autoConnect(2);

        sleep(2);

        Disposable disposable1 = longObservable.subscribe(aLong -> System.out.println("sub1: " + aLong));
        sleep(3);
        Disposable disposable2 = longObservable.subscribe(aLong -> System.out.println("sub2: " + aLong));
        sleep(2);
        disposable1.dispose();

        sleep(4);
    }
}
