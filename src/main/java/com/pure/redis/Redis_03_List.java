package com.pure.redis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.ListPosition;

import java.util.List;

public class Redis_03_List {

    private Jedis jedis = null;

    @Before
    public void before(){
        jedis = new Jedis("hadoop102",6379);
    }

    @Test
    public void lpush(){
        Long lpush = jedis.lpush(
                "lis", "v1", "v2", "v3", "v4"
        );
        List<String> lists = jedis.lrange("lis", 0, -1);
        System.out.println("li 的值为： ");
        for (String list : lists) {
            System.out.println(list);
        }
    }

    @Test
    public void lrem(){
        jedis.lrem("lis",1,"v2");
        List<String> lists = jedis.lrange("lis", 0, -1);
        System.out.println("li 的值为： ");
        for (String list : lists) {
            System.out.println(list);
        }
    }

    @Test
    public void lpop(){
        String lis = jedis.lpop("lis");
        System.out.println(lis);
        List<String> lists = jedis.lrange("lis", 0, -1);
        System.out.println("li 的值为： ");
        for (String list : lists) {
            System.out.println(list);
        }
    }

    @Test
    public void rpush(){
        Long rpush = jedis.rpush("rlist", "v1", "v2", "v3", "v4");
        List<String> rlist = jedis.lrange("rlist", 0, -1);
        System.out.println("rlist的元素个数为： " + jedis.llen("rlist"));
        for (String s : rlist) {
            System.out.println(s);
        }
    }

    @Test
    public void lindex(){
        String lis = jedis.lindex("lis", 1);
        System.out.println("lis = " + lis);
    }

    @Test
    public void linsert(){
        Long aLong = jedis.linsert("lis", ListPosition.AFTER, "v4", "a");
        List<String> lrange = jedis.lrange("lis", 0, -1);
        for (String s : lrange) {
            System.out.println(s);
        }
    }

    @After
    public void after(){
        jedis.close();
    }
}
