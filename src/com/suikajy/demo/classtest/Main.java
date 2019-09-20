package com.suikajy.demo.classtest;

/**
 * test for method isAssignableFrom()
 *
 * Contrary to instanceof，isAssignableFrom()判断当前Class对象是否是制定Class的当前类或者父类
 */
public class Main {
    public static void main(String[] args) {
//        Person p1 = new ChinesePerson("p1", 24);
//        Person p1 = new ChineseMan("p1", 24);
        Person p1 = new Person("p1", 24);
        if (p1.getClass().isAssignableFrom(ChinesePerson.class)) {
            System.out.println("p1 is a ChinesePerson");
        } else {
            System.out.println("p1 is not a ChinesePerson");
        }
    }
}

class ChineseMan extends ChinesePerson{

    ChineseMan(String name, int age) {
        super(name, age);
    }
}

class ChinesePerson extends Person {

    ChinesePerson(String name, int age) {
        super(name, age);
    }
}

class Person {
    final String name;
    final int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}