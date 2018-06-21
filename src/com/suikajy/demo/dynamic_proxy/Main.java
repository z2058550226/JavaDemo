package com.suikajy.demo.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        //下面模拟了一个基于Java动态代理实现的保护代理模式
        //保护代理：控制代理模式中Subject的一些属性的修改访问
        PersonBeanImp person1 = new PersonBeanImp();
        person1.setGender("woman");
        person1.setName("suika");
        person1.setInterests("eat");
        PersonBeanImp person2 = new PersonBeanImp();
        person2.setGender("man");
        person2.setName("naegi");
        person2.setInterests("kill");
        PersonBeanImp person3 = new PersonBeanImp();
        person3.setGender("woman");
        person3.setName("reimu");
        person3.setInterests("housework");

        PersonBean p1ownerProxy = getOwnerProxy(person1);
        PersonBean p2nonOwnerProxy = getNonOwnerProxy(person1);

        System.out.println(p1ownerProxy.getGender());
        try {
            p1ownerProxy.setHotOrNotRating(1);
        } catch (Exception e) {
            System.out.println("suika cant set rating by herself!");
        }

        try {
            p2nonOwnerProxy.setName("ba ka");
        } catch (Exception e) {
            System.out.println("you cant set name doesn't belong to you");
        }
    }

    //这里返回的PersonBean是一个代理，并且这个代理的调用会经由OwnerInvocationHandler进行处理
    //InvocationHandler字如其名，就是一个调用的处理者，在代理对象调用被代理对象(这里指形参person)之前会先走一遍InvocationHandler的invoke方法
    public static PersonBean getOwnerProxy(PersonBean person) {
        return (PersonBean) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new OwnerInvocationHandler(person));
    }

    public static PersonBean getNonOwnerProxy(PersonBean person) {
        return (PersonBean) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new NonOwnerInvocationHandler(person));
    }

    public static PersonBean getProxy(PersonBean person, InvocationHandler handler) {
        return (PersonBean) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                handler);
    }
}
