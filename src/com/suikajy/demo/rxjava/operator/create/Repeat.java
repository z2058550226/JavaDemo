package com.suikajy.demo.rxjava.operator.create;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class Repeat {

    public static void main(String[] args) {
        repeatWhen();
    }

    private static void simpleRepeat() {
        Observable.just("a", "b", "c")
                .repeat(3)
                .subscribe(System.out::println);
    }

    private static void repeatWhen() {
        Observable.just("a", "b", "c")
                .doOnSubscribe(ignore -> System.out.println("repeat onSubscribe: " + System.currentTimeMillis()))
                .repeatWhen(objectObservable -> {
                    System.out.println(System.currentTimeMillis() + " " + objectObservable.getClass().getSimpleName());
                    return objectObservable.delay(3, TimeUnit.SECONDS)
                            .doOnNext(it -> {
                                System.out.println("repeat onNext: " + it + " At " + System.currentTimeMillis() + " " + it.getClass().getSimpleName());
                            }).doOnDispose(() -> {
                                System.out.println("repeat onDispose: ");
                            }).doOnComplete(() -> {
                                System.out.println("repeat onComplete: ");
                            });
                }).take(10).blockingSubscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                System.out.println("Repeat.onSubscribe: ");
            }

            @Override
            public void onNext(String s) {
                System.out.println("Repeat.onNext: " + s);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {
                System.out.println("Repeat.onComplete: ");
            }
        });
    }

    private static void repeatUntil() {
        Observable.just("a", "b", "c")
                .repeatUntil(() -> {
                    return false;
                }).take(10).subscribe(System.out::println);
    }
}
