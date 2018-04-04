package com.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ssm.dao.UserDao;
import com.ssm.entity.User;
import com.ssm.redis.RedisDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    //自动注入
    @Autowired
    private UserDao userDao;
    @Autowired
    private RedisDataSource redisDataSource;


    //添加用户的方法
    @RequestMapping("addUser")
    public  String addUser(User user){
        String key="com.ssm.redis.UserDao.findAllUser";
        String s=redisDataSource.getData(key);
        List<User> list=JSON.parseArray(s,User.class);
        list.add(user);
        s=JSON.toJSONString(list);
        redisDataSource.setData(key,s);

        userDao.addUser(user);
        return "success";
    }

    //查询所有数据的方法
    @RequestMapping("findAllUser")
    public String findAllUser(Map map){
        List<User> list=null;
        String key="com.ssm.redis.UserDao.findAllUser";


        String data = redisDataSource.getData(key);

        //如果没有数据那么查询数据库,将数据保存到redis
        if(data==null){
            list = userDao.findAllUser();
            String s=JSON.toJSONString(list);
            redisDataSource.setData(key,s);
        }else{
            //将data转换成集合
            list=JSON.parseArray(data,User.class);

        }
        //如果redis中有该数据那么直接从redis中获取,
        map.put("list",list);
        return "success";
    }
}
