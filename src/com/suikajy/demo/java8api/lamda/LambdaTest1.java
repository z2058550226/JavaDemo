package com.suikajy.demo.java8api.lamda;

import java.util.Comparator;
import java.util.List;

public interface LambdaTest1<T> {

    void sort(List<T> args, Comparator<? super T> comparator);

}
