package com.pure.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtils {
    private static JedisPool jedisPool;

    public static Jedis getJedis(){

//        1. 设置redis连接池的配置信息
        JedisPoolConfig config = new JedisPoolConfig();
//       1.1 设置最大的连接数
        config.setMaxTotal(10);
//        1.2 最大空闲数据连接
        config.setMaxIdle(5);
//        1.3 最小空虚数据连接
        config.setMinIdle(5);
//        1.4 当连接池中数据库中的资源耗竭时是否进行阻塞
        config.setBlockWhenExhausted(true);
//        1.5 超时等待时间
        config.setMaxWaitMillis(1000);
//        1.6 测试
        config.setTestOnBorrow(true);
        jedisPool = new JedisPool(config,"hadoop102",6379);
//        2.获取Jdeis的对象
        Jedis jedis = jedisPool.getResource();
        return jedis;
    }
}
