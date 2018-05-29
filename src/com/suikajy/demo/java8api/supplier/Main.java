package com.suikajy.demo.java8api.supplier;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

    }

    static class Test {

        public A get() {
            // Supplier提供一个对象的创建。
            // 相对于Function可以当策略模式的万能接口，Supplier则更偏向抽象工厂模式的万能借口
            Supplier<A> supplier = A::new;
            return supplier.get();
        }

    }

    static class A {
        public final int a = 1;
    }
}
