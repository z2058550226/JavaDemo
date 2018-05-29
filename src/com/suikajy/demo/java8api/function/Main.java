package com.suikajy.demo.java8api.function;

import java.util.Objects;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<String, Integer> toInt = Integer::valueOf;
        String suika = "2";
        // apply(T t)：就是简单的根据输入获取这个方法的输出
        System.out.println(toInt.apply(suika));//2 这里是整数

        // compose(Function fun)：在方法执行之前对输入进行处理
        // 参数Function输入可以是其他类型，输出必须是组合方法的输入类型
        Function<Test, String> funFilter = test -> test.getClass().getName();
        Function<String, Boolean> funDigital = s -> {
            Objects.requireNonNull(s);
            return s.length() > 0;
        };
        Function<Test, Boolean> composedFunction = funDigital.compose(funFilter);
        System.out.println(composedFunction.apply(new Test()));//true

        // andThen(Function fun)：在方法执行之后对输出进行处理
        Function<Test, Boolean> andThenFunction = funFilter.andThen(funDigital);
        System.out.println(andThenFunction.apply(new Test()));//true

        // identity()：获取一个直接输出输入的方法。
        // 有时在既有代码里面有compose和andThen，这时如果想不做任何处理可以直接使用这个方法
        Function function = Function.identity();
        System.out.println(function.apply(suika).getClass().getName());//java.lang.String
    }

    private static class Test {

    }
}
