package com.ssm.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisDataSource {
    private JedisPool jedisPool;

    public JedisPool getJedisPool() {
        return jedisPool;
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    //获取数据
    public String getData(String key){
        //获取jedis对象 通过jedisPool
        Jedis jedis = jedisPool.getResource();
        return jedis.get(key);
    }

    //保存数据
    public void setData(String key,String value){
        //获取jedis对象 通过jedisPool
        Jedis jedis = jedisPool.getResource();
        jedis.set(key, value);

    }
}
