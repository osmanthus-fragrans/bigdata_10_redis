package com.pure.redis;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class TestRedisUtils {
    public static void main(String[] args) {
        Jedis jedis = RedisUtils.getJedis();
        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            System.out.println(key);
        }
        jedis.close();
    }
}
