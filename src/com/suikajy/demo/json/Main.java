package com.suikajy.demo.json;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.suikajy.demo.json.bean.InvoiceIssUingApplicationBean;

public class Main {

    public static void main(String[] args) {
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
        //这里得到一个结论：FastJson处理前缀为m的boolean值的时候会漏掉这个boolean值（bug）
        //而Gson不会
    }

}
