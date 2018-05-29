package com.suikajy.demo.java8api.lamda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(50);
        list.add(18);
        list.add(6);
        list.add(99);
        list.add(32);
        System.out.println(list.toString() + "排序之前");
        LambdaTest1<Integer> lt1 = Collections::sort;
        lt1.sort(list, Comparator.comparingInt(a -> a));
        System.out.println(list.toString() + "排序之后");
    }
}
