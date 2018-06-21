package com.suikajy.demo.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class OwnerInvocationHandler implements InvocationHandler {

    PersonBean person;

    public OwnerInvocationHandler(PersonBean person) {
        this.person = person;
    }

    /**
     * 会在代理类与被代理类沟通之前拦截这个沟通，并执行invoke中的代码
     *
     * @param proxy  代理类的对象，一般是Proxy.newProxyInstance()方法的返回值
     * @param method 客户端调用的代理类对象的方法
     * @param args   调用method时传递的参数
     * @return 如果返回值为null，则会直接调用被代理对象的响应方法（相当于不作处理），如果返回值不为null则invoke方法会取代原有的代理调用
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        try {
            if (method.getName().startsWith("get")) {
                return method.invoke(person, args);
            } else if (method.getName().equals("setHotOrNotRating")) {
                throw new IllegalAccessException();
            } else if (method.getName().startsWith("set")) {
                return method.invoke(person, args);
            }
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;//如果是其他调用则return null表示不做处理
    }
}
