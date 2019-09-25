package com.suikajy.demo.rxjava.hotobservable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

import static com.suikajy.demo.util.Sleeper.sleep;

/**
 * refCount() means that: When you first subscribe the returned Observable object,
 * the Observable automatically call the connect() method and start emit the element.
 * When the subscriber's number is zero, refCount() will automatically dispose the upstream.
 */
public class RefCount {

    public static void main(String[] args) {
        Observable<Long> longObservable = Observable.interval(0, 1, TimeUnit.SECONDS)
                .take(10)
                .publish()
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
