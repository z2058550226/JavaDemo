package com.suikajy.demo.encode;

import com.google.gson.Gson;
import com.suikajy.demo.swing.base64.Base64;

public class Base64Test {

    static String testString = "{\"errorno\":200,\"msg\":\"操作成功\",\"data\":\"Qbj68CxzuDZwizIAgHkQL634P5okMrMt+N+boNTjPBHQwyzWqktZY3SYi1J+5WZBVhftBemy3CTm4OAocnddoeHQGR+LkS+rsO+7OQ9pKdzfjW1CEnkSME8iTntyt2x6hDx0OAfEzdqXvpjsmqqrYIeSJTNptXcj0uBLFMfK8DTRRqXkb9oa88XB4jy3thfP5Ht6QFgpZ6QD6YjJ1oZGJQtd\\/NXKWglJRA3XVKTcyeQ=\"}";
    static String test = "Qbj68CxzuDZwizIAgHkQL634P5okMrMt+N+boNTjPBHQwyzWqktZY3SYi1J+5WZBVhftBemy3CTm4OAocnddoeHQGR+LkS+rsO+7OQ9pKdzfjW1CEnkSME8iTntyt2x6hDx0OAfEzdqXvpjsmqqrYIeSJTNptXcj0uBLFMfK8DTRRqXkb9oa88XB4jy3thfP5Ht6QFgpZ6QD6YjJ1oZGJQtd\\/NXKWglJRA3XVKTcyeQ=";
    public static void main(String[] args) {
        Gson gson = new Gson();
        System.out.println(sign);
//        printDecode("csItc\\/PPJx+eM9CbBNnlTHQ1ct3MqDx8wUwdFPcsnuuyvNert\\/GdCR7auUPRlWtH99uL7ckWo1aByH2zNRxweF9rpsYZvBgX5LSRQW\\/Jdpvo4xoD0f5FGBqbexhMYoh2kH9XZRF+YS\\/JOYg+57R3sWIyrUY1jHVCugkHiJJF9FZAWC8Muly+lu9msg33AxfTnWKI\\/n8640x3\\/qOQNz39O4KJOpv4Us2jQZvdp0fIuWBY0RDbtd9brRoPxrj5zUNVEgtCa1i1qk\\/K9ok3c6aiAV81d2fdmbClpotWql3ZbQ\\/tPOBu17+yU+iR58PnGX0DbintSuyDF89hR+tV6Oh4Ks1k9b4JmqqYGLU0hFGCvTF9LhtDGawBHr4RsQO6qneJ20tOHVHn38EGPMAySEmjqijnNt0hWDXU230lAaECm9XgsVZBc5UjUARUv5ymCvozm6BcSaMog6i2fBUJH1TD3w==");
    }

    static String sign = "t3B1lDN+l4PIMJDaJmsgYa52eeloBCUPUBEGAa4h79HQGTA/XmV650B3a+Say1xmhr4G/aSfqpN7\n" +
            "3o39ZqO6NviXR9Pqea4LVIUBggYoZ4JfYSG1rHeaOmfNUSOk6Y10kpEt+RjK2k/7OBUis899C3B7\n" +
            "KCWofajQJNNtYk6cYX9niIJeE9SSXuiRScyQTMWL";

    public static void printEncode(String originString) {
        byte[] encode = Base64.encode(originString.getBytes(), Base64.DEFAULT);
        String encodeString = new String(encode);
        System.out.println("Base64: " + encodeString);
        System.out.println("AES: " + AES.encrypt(originString));
        System.out.println(
        );


    }

    private static void printDecode(String encodedString) {
        System.out.println("Decode : " + AES.decrypt(encodedString));
    }

    static class TestBean {

        /**
         * title : 蓝星某个城市内，一个略显颓废的青年，他的双目无神，神情疲惫的走在马路上，给人一种随时可能逝去的苍凉之感。
         * label : 93
         */

        public String title;
        public String label;
    }
}
