package com.suikajy.demo.debug;

public class DebugMain {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                System.out.println(3 / i);
            }
        }).start();
    }
}
