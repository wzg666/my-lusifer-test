package com.wzg.hello.maven.servlet.utils;

import java.io.IOException;

/**
 * @ClassName TestInterface
 * @Description TODO
 * @Author wzg
 * Date 2020/10/15 20:12
 * Version 1.0
 */
public class TestInterface {

    static String url = "http://192.168.1.71:8080/bgan/getHeart";

    public static void main(String[] args) {
        TestInterface.test2();
    }

    public static void test2() {
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    long time1;
                    long total = 0;
                    for (int i = 0; i < 400; i++) {
                        stopTime(10);
                        time1 = System.currentTimeMillis();
                        TestInterface.testInterface();
                        System.out.println(System.currentTimeMillis()-time1);
                        total += System.currentTimeMillis()-time1;
                    }
                    System.out.println("total="+(total/100.0));
                }
            }).start();
        }
    }

    public static void test1() {
        long time1;
        long total = 0;
        for (int i = 0; i < 50; i++) {
            stopTime(10);
            time1 = System.currentTimeMillis();
            TestInterface.testInterface();
            total += System.currentTimeMillis()-time1;
        }
        System.out.println("total="+(total/100.0));
    }

    public static void testInterface() {
        try {
            System.out.println(HttpUtil.doPost(url, "{\n" +
                    "  \"token\": \"string\"\n" +
                    "}", null).substring(0, 40));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void stopTime(int ms) {
        try {
            Thread.sleep(ms);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
