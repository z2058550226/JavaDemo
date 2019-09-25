package com.suikajy.demo.rxjava;

import com.suikajy.demo.rxjava.operator.logiccontrol.ElementDC;
import io.reactivex.rxjava3.core.Emitter;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

import java.util.concurrent.TimeUnit;

import static com.suikajy.demo.util.Sleeper.sleep;

public class SomeTest {
    private static Emitter<Observable<ElementDC>> sEmitter;

    public static void main(String[] args) {

        Subject<Observable<ElementDC>> subject = PublishSubject.create();
        Disposable disposable = subject
                .flatMap((Function<Observable<ElementDC>, ObservableSource<ElementDC>>) ob -> ob)
                .subscribe();

        ElementDC eleOne = new ElementDC(1, "one");
        ElementDC eleTwo = new ElementDC(2, "two");
        Observable<ElementDC> testOb = Observable.interval(0, 1, TimeUnit.SECONDS)
                .take(5)
                .map(time -> new ElementDC(time.intValue(), "No. " + time))
                .doOnNext(System.out::println);
        subject.onNext(testOb);

        sleep(1);

        disposable.dispose();

        sleep(5);
    }

    private static void test1() {
        Observable.create((ObservableOnSubscribe<Observable<ElementDC>>) emitter -> {
            sEmitter = emitter;
        }).flatMap((Function<Observable<ElementDC>, ObservableSource<ElementDC>>) elementDCObservable -> elementDCObservable)
                .subscribe();
        sleep(2);
        ElementDC eleOne = new ElementDC(1, "one");
        ElementDC eleTwo = new ElementDC(2, "two");
        Observable<ElementDC> testOb = Observable.just(eleOne, eleTwo)
                .doOnNext(System.out::println);

        sEmitter.onNext(testOb);
    }
}


