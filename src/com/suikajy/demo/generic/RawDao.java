package com.suikajy.demo.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class RawDao<T> {
    protected Class<T> clazz;

    @SuppressWarnings("unchecked")
    public RawDao() {
        @SuppressWarnings("rawtypes")
        Class clazz = getClass();

        while (clazz != Object.class) {
            Type t = clazz.getGenericSuperclass();
            if (t instanceof ParameterizedType) {
                Type[] args = ((ParameterizedType) t).getActualTypeArguments();
                if (args[0] instanceof Class) {
                    this.clazz = (Class<T>) args[0];
                    break;
                }
            }
            clazz = clazz.getSuperclass();
        }

        System.out.println(this.clazz);
    }
}
