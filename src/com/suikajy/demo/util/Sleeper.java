package com.suikajy.demo.util;

import java.util.concurrent.TimeUnit;

public interface Sleeper {

    static void sleep(int second) {
        sleep(second,TimeUnit.SECONDS);
    }

    static void sleep(int time, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
