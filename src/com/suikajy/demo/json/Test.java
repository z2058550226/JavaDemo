package com.suikajy.demo.json;

import com.google.gson.Gson;
import com.suikajy.demo.json.bean.TestBean;

public class Test {

    @org.junit.Test
    public void gson() {
        String json = "{\"x\":1,\"y\":2}";
        Gson gson = new Gson();
        TestBean testBean = gson.fromJson(json, TestBean.class);
        System.out.println(testBean.toString());
    }
}
