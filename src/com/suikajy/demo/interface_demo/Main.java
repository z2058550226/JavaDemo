package com.suikajy.demo.interface_demo;

public class Main {

    public static void main(String[] args) {
        A a = new B() {
            @Override
            public void a(int a, int b) {

            }

            @Override
            public void a(int a) {

            }
        };
    }

    interface A {
        void a(int a);
    }

    interface B extends A {
        void a(int a, int b);
    }
}
