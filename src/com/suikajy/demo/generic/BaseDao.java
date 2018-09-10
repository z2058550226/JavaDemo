package com.suikajy.demo.generic;

public interface BaseDao<T> {
    T get(String id);
}
