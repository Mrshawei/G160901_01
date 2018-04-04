package com.sw.test;

public class Test {
    public static void main(String[] args) {
        SingleInstance s=SingleInstance.getSingleInstance();
        SingleInstance s1=SingleInstance.getSingleInstance();
        System.out.println(s==s1);
    }
}
