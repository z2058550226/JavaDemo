package com.suikajy.demo.utf_8;

public class Main {

    public static void main(String[] args) {
        char ch = 0;
        for (int i = 0; i < Character.MAX_VALUE; i++) {
            ch = (char) i;
            if (i % 10 == 0 && i > 0) System.out.print("\n");
            if (i % 10 == 0) System.out.printf("line %s ", i / 10 + 1);
            System.out.print("  ");
            System.out.print(ch);
        }
    }

}
