package com.suikajy.demo.rxjava;

public class Main {

    public static void main(String[] args) {

        Observable.create((ObservableOnSubscribe<String>) emitter -> {
            emitter.onNext("aaa");
            emitter.onComplete();
        }).subscribe(System.out::println);

    }

    static class Observable<T> {

        private final ObservableOnSubscribe<T> mSubscriber;

        Observable(ObservableOnSubscribe<T> mSubscriber) {
            this.mSubscriber = mSubscriber;
        }

        static <K> Observable<K> create(ObservableOnSubscribe<K> subscribe) {
            return new Observable<>(subscribe);
        }

        public void subscribe(Observer<T> observer) {
            mSubscriber.subscribe(new Emitter<T>() {
                @Override
                public void onNext(T t) {
                    observer.onNext(t);
                }

                @Override
                public void onComplete() {
                    observer.onComplete();
                }
            });
        }

        public void subscribe(Consumer<T> consumer) {
            mSubscriber.subscribe(new Emitter<T>() {
                @Override
                public void onNext(T t) {
                    consumer.accept(t);
                }

                @Override
                public void onComplete() {

                }
            });
        }
    }

    interface ObservableOnSubscribe<T> {

        void subscribe(Emitter<T> emitter);
    }

    interface Emitter<T> {

        void onNext(T t);

        void onComplete();

    }

    interface Observer<T> {
        void onNext(T t);

        void onComplete();
    }

    interface Consumer<T> {
        void accept(T t);
    }
}
