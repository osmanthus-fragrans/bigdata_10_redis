package com.pure.redis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Set;

public class Redis_06_ZSet {
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
    public void zadd(){
        jedis.zadd("zset",200,"hive");
        jedis.zadd("zset",50,"zookeeper");
        jedis.zadd("zset",250,"hadoop");
        jedis.zadd("zset",150,"hbase");
        Set<String> zset = jedis.zrange("zset", 0, -1);
        for (String s : zset) {
            System.out.println("s = " + s);
        }
    }

    @Test
    public void zrevrange(){
        Set<String> zset = jedis.zrevrange("zset", 0, -1);
        for (String s : zset) {
            System.out.println("s = " + s);
        }
    }

    @Test
    public void zrangebyscore(){
        Set<String> zset = jedis.zrangeByScore("zset", 100, 200);
        for (String s : zset) {
            System.out.println("s = " + s);
        }
    }

    @Test
    public void zrevrangebyscore(){
        Set<String> zset = jedis.zrevrangeByScore("zset", 200, 100);
        for (String s : zset) {
            System.out.println("s = " + s);
        }
    }
}
