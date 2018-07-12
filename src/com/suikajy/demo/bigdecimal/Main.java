package com.suikajy.demo.bigdecimal;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        System.out.println(BigDecimal.valueOf(112122212342334111L));
        System.out.println(new BigDecimal(1.34));
        System.out.println(BigDecimal.valueOf(1.34));

        double a = 1.34;
        double b = 1.1;
        System.out.println(BigDecimal.valueOf(a).multiply(BigDecimal.valueOf(b)));

    }

}
