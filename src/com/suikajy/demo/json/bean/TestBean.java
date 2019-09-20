package com.suikajy.demo.json.bean;

public class TestBean {

    public int x;
    public transient int y;

    public TestBean(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
