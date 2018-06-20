package com.suikajy.demo;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;

import java.util.List;

public class TestMain {

    public static void main(String[] args) {
        System.out.println("suika");
        List<String> list = List.of("a", "b", "c");
        System.out.println(list);

        InvoiceIssUingApplicationBean bean = new InvoiceIssUingApplicationBean();
        bean.setGeRen(true);
        bean.setGongYou(false);
        bean.setmTvTime("time");
        bean.setmGeRen("mmmmmmmmmmmmmmmmmm");
        bean.setmGongYou("asdfjlasd;lfjas;ldfja;lsd");
        bean.setmYes(false);
        Object o = JSON.toJSON(bean);
        System.out.println(o);
        Gson gson = new Gson();
        String s = gson.toJson(bean);
        System.out.println(s);
    }
}
