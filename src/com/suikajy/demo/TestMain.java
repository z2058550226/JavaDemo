package com.suikajy.demo;

public class TestMain {

    public static void main(String[] args) {
        System.out.println(new TestMain().getS());
    }

    public String getS() {
        if (getClass().getSimpleName().contains("TestMain")) {
            return "apk";
        }
        return "s";
    }
}
