package com.suikajy.demo.rxjava.operator;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class TakeUntil {

    public static void main(String[] args) {
        ArrayList<String> taskKeys = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            taskKeys.add("No." + i);
        }
        ArrayList<String> canceledKey = new ArrayList<>();
        Observable.create((ObservableOnSubscribe<String>) observableEmitter -> {
            for (String taskKey : taskKeys) {
                TimeUnit.SECONDS.sleep(1);
                observableEmitter.onNext(taskKey);
            }
            observableEmitter.onComplete();
        })
                .takeUntil(Observable.create(new ObservableOnSubscribe<String>() {
                    @Override
                    public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                        for (int i = 0; true; i++) {
                            System.out.println("takeUntil operator is executed!!");
                            TimeUnit.MILLISECONDS.sleep(500);
                            if (canceledKey.contains(taskKeys.get(7))) {
                                observableEmitter.onNext("ssssaf");
                                break;
                            }
                        }
                        observableEmitter.onComplete();
                    }
                }).subscribeOn(Schedulers.newThread()))
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.newThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        System.out.println("onSubscribe");
                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println("onNext: " + s);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.err.println(throwable.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                    }
                });
        try {
            TimeUnit.SECONDS.sleep(5);
            String sevenEle = taskKeys.get(7);
            canceledKey.add(sevenEle);
            System.out.println("cancel invoked " + canceledKey.toString());
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
