package com.pure.redis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class Redis_05_Hash {
    private Jedis jedis = null;

    @Before
    public void before(){
        jedis = new Jedis("hadoop102",6379);
    }

    @After
    public void after(){
        jedis.close();
    }

    @Test
    public void hset(){
        Long hset = jedis.hset("user", "username", "march");
        Map<String, String> user = jedis.hgetAll("user");
        for (String s : user.keySet()) {
            System.out.println(s);
        }
    }

    @Test
    public void hget(){
        String s = jedis.hget("user", "username");
        System.out.println("s = " + s);
    }

    @Test
    public void hmset(){
        Map<String,String> map = new HashMap<>();
        map.put("k1","v1");
        map.put("k2","v2");
        map.put("k3","v3");
        jedis.hmset("ha",map);
        Map<String, String> all = jedis.hgetAll("ha");
        for (String s : all.keySet()) {
            System.out.println(s);
        }
    }

    @Test
    public void hincrby(){

    }
}
