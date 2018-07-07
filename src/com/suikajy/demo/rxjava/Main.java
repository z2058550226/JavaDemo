package com.suikajy.demo.rxjava;

public class Main {

    public static void main(String[] args) {

        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(Emitter<String> emitter) {
                emitter.onNext("aaa");
                emitter.onComplete();
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });


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

    private static abstract class ObservableOnSubscribe<T> {

        public abstract void subscribe(Emitter<T> emitter);
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
