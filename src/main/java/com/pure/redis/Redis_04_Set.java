package com.pure.redis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Set;

public class Redis_04_Set {
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
    public void sadd(){
        Long sadd = jedis.sadd("set1", "s1", "s3", "s2", "s4");
        Set<String> set1 = jedis.smembers("set1");
        for (String s : set1) {
            System.out.println(s);
        }
    }

    @Test
    public void sismember(){
        Boolean sismember = jedis.sismember("set1", "s4");
        System.out.println("sismember = " + sismember);
    }

    @Test
    public void scard(){
        Long sert1 = jedis.scard("set1");
        System.out.println("set1 = " + sert1);
    }

    @Test
    public void smembers(){
        Set<String> smembers = jedis.smembers("set1");
        for (String smember : smembers) {
            System.out.println("smember = " + smember);
        }
    }

    @Test
    public void srem(){
        Long srem = jedis.srem("set1", "s1");
    }

    @Test
    public void sinter(){

        Set<String> set = jedis.sinter("set1", "set");
        for (String s : set) {
            System.out.println("s = " + s);
        }
    }

    @Test
    public void sunion(){
        Set<String> sunion = jedis.sunion("set", "set1");
        for (String s : sunion) {
            System.out.println("s = " + s);
        }
    }

    @Test
    public void sdiff(){
        Set<String> sdiff = jedis.sdiff("set1", "set");
        for (String s : sdiff) {
            System.out.println("s = " + s);
        }
    }


}
