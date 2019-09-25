package com.suikajy.demo.rxjava.operator.create;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

import static com.suikajy.demo.util.Sleeper.sleep;

public class Timer {

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis() + "  #1");
        Observable.timer(1, TimeUnit.SECONDS)
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        System.out.println("Delay.onSubscribe");
                    }

                    @Override
                    public void onNext(Long aLong) {
                        System.out.print(System.currentTimeMillis() + " #2 ");
                        System.out.println("Delay.onNext " + aLong);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("Delay.onError");
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Delay.onComplete");
                    }
                });
        sleep(3);
    }

}
