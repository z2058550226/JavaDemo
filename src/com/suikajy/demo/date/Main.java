package com.suikajy.demo.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        //calendar.setTime(new Date(1530412174000L));
        print(calendar);

        calendar.add(Calendar.MONTH, -1);

        print(calendar);

        calendar.set(Calendar.DAY_OF_MONTH, 2);
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Calendar c2 = Calendar.getInstance();
        Calendar c3 = Calendar.getInstance();
        c2.add(Calendar.DATE,11);
        print(c2);
        print(c3);
        System.out.println(c2.getTime().getTime());
        System.out.println(c3.getTime().getTime());
//        print(calendar);
    }

    private static void print(Calendar calendar) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(calendar.getTime()));
    }

}
