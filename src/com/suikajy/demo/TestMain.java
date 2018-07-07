package com.suikajy.demo;

import io.reactivex.*;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import java.util.Map;
import java.util.concurrent.Executor;

public class TestMain {

    public static void main(String[] args) {
        System.out.println("suika");

        Map<String, String> fileMap = Map.of("k1", "v1", "k2", "v2", "k3", "v3");

        Flowable.fromIterable(fileMap.keySet())
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.newThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        System.out.println(fileMap.get(s));
                        System.out.println(Thread.currentThread().getId());
                    }
                });

        Observable<String> stringObservable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {

            }
        });


        System.out.println(Thread.currentThread().getId());
    }
}
