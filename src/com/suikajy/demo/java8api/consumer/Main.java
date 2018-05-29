package com.suikajy.demo.java8api.consumer;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        //Consumer是将处理者抽象化的接口，可以用来结合命令模式使用
        Supplier<LambdaClassTest> personSupplier = LambdaClassTest::new;
        Consumer<LambdaClassTest> greeter = (lt) -> System.out.println("Hello, " + lt.getTest());
        greeter.accept(personSupplier.get());
    }

    static class LambdaClassTest {

        CharSequence c;

        String getTest() {
            return "test";
        }
    }

    static class A extends LambdaClassTest{

    }
}
