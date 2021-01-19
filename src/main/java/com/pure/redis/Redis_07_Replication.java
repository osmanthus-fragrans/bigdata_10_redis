package com.pure.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

public class Redis_07_Replication {
    public static void main(String[] args) {
        Jedis jedis = Redis_07_Replication.getConnection();
//        String pong = jedis.ping();
//        System.out.println("pong = " + pong);
        jedis.set("key","value");
        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            System.out.println("key = " + key);
        }
        jedis.close();
    }

    public static Jedis getConnection(){
        JedisPoolConfig config = new JedisPoolConfig();

        config.setMaxTotal(10);
        config.setMaxIdle(5);
        config.setMinIdle(5);
        config.setBlockWhenExhausted(true);
        config.setMaxWaitMillis(1000);
        config.setTestOnBorrow(true);

        Set<String> set = new HashSet<>();
        set.add("hadoop102:26379");
        JedisSentinelPool sentinelPool = new JedisSentinelPool("mymaster",set,config);

        return sentinelPool.getResource();
    }
}
