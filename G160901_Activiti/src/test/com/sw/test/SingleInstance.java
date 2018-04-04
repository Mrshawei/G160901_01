package com.sw.test;

public class SingleInstance {
   /* private final static SingleInstance singleInstance=new SingleInstance();
    //回收外部实例化对象的权力
    private SingleInstance(){

    }
   //提供一个公共的供外部获取对象的方法
    public static SingleInstance getSingleInstance(){

        return singleInstance;
    }*/


    private static SingleInstance singleInstance=null;

    private SingleInstance(){

    }
    public static SingleInstance getSingleInstance(){

        if(singleInstance==null){
            singleInstance=new SingleInstance();
        }
        return singleInstance;
    }
}

