package com.suikajy.demo.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Main {

    public static void main(String[] args) {
        Callback<String> callback = new SubCallback<>();
        Class clz = getClzByGenericType(callback);
        System.out.println(clz);

        new RawDao<String>();

        EntityDao testDao = new EntityDao();
        Entity e = testDao.get(null);
        System.out.println(e);

    }

    /**
     * 通过一个泛型类的泛型类型获取泛型的运行时对象。
     *
     * @param obj 泛型类的实例
     * @param <T> 泛型类的泛型
     * @return 泛型的运行时类对象
     */
    public static <T> Class<T> getClzByGenericType(Object obj) {
        Class<T> genericClazz = null;
        Class<?> clazz = obj.getClass();
        while (clazz != Object.class) {
            Type t = clazz.getGenericSuperclass();
//            Type t = obj.getClass();
            if (t instanceof ParameterizedType) {
                Type[] args = ((ParameterizedType) t).getActualTypeArguments();
                if (args[0] instanceof Class) {
                    genericClazz = (Class<T>) args[0];
                    break;
                }
            }
            clazz = clazz.getSuperclass();
        }
        return genericClazz;
    }

}
