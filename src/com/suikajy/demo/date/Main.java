package com.suikajy.demo.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {


        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(1530412174000L));
        print(calendar);

        calendar.add(Calendar.MONTH, -1 );

        print(calendar);

        calendar.set(Calendar.DAY_OF_MONTH,2);
        print(calendar);
    }

    private static void print(Calendar calendar) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(calendar.getTime()));
    }

}
