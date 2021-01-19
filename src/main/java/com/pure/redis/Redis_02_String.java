package com.pure.redis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

public class Redis_02_String {
    Jedis jedis;
    @Before
    public void before(){
       jedis = new Jedis("hadoop102", 6379);
    }

    @Test
    public void keys(){
        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            System.out.println(key);
        }
    }

    @Test
    public void expire(){
        String key = "student:1002";
        int second = 10;
        Long expire = jedis.expire(key,second);
        System.out.println(key + "的过期时间为：" + expire);
    }

    @Test
    public void ttl(){
        String key = "student:1002";
        Long ttl = jedis.ttl(key);
        System.out.println(key + "的生命周期为：" + ttl);
    }

    @Test
    public void setnx(){
        Long setnx = jedis.setnx("student:1002", "name:zhangsan");
    }

    @Test
    public void msetAndmget(){
        String mset = jedis.mset("t1", "v1", "t2", "v2");
        List<String> mget = jedis.mget("t1", "t2");
        for (String s : mget) {
            System.out.println(s);
        }
    }

    @Test
    public void setex(){
        String setex = jedis.setex("t3", 5, "v3");
        System.out.println(jedis.get("t3"));
    }


    @After
    public void after(){
        jedis.close();
    }
}
