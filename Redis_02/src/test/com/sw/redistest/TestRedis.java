package com.sw.redistest;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestRedis {
    @Test
    public void testRedis(){
        //创建java操作redis的客户端
        Jedis jedis=new Jedis("39.108.219.192",6379);
        //System.out.println("连接成功");
        //jedis.ping();

        jedis.auth("Sys13142b");

        //存放 string类型的数据
        //jedis.set("sname","张柯基");
      /*  String sname = jedis.get("sname");
        System.out.println(sname);*/



        //hash类型存放数据
      /* Map<String,String> person=new HashMap<String,String>();
        person.put("name","唐人一");
        person.put("age","18");
        person.put("sex","男");

        jedis.hmset("person",person);*/

        //System.out.println(jedis.keys("*"));
        //获取hash类型的数据
        /*List<String> hmget = jedis.hmget("person", "name");
        System.out.println(hmget);
        */

        //获取hash某个键的所有数据
       /* Map<String, String> person = jedis.hgetAll("person");
        Set<String> keys=person.keySet();
        for (String key : keys) {
            System.out.print(key+"------");
            String value=person.get(key);
            System.out.println(value);
        }*/

       //保存数据到sets中
        jedis.sadd("hobby","basktball");
        jedis.sadd("hobby","football");
        jedis.sadd("hobby","ppball");

    /*    Set<String> hobby = jedis.smembers("hobby");
        for (String s : hobby) {
            System.out.println(s);
        }*/


    //list集合
        jedis.lpush("girl","范黑皮");
        jedis.lpush("girl","王黑皮");
        jedis.lpush("girl","雷亲疼");

        List<String> girl = jedis.lrange("girl", 0, -1);
        for (String s : girl) {
            System.out.println(s);
        }







        /*Set<String> keys = jedis.keys("*");
        for (String s : keys) {
            System.out.println(s);
        }*/



    }

}
