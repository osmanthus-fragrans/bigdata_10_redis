package com.pure.redis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Set;

public class Redis_08_Cluster {

    private static JedisCluster jedisCluster = null;

    public static void main(String[] args) {
        JedisCluster cluster = Redis_08_Cluster.getJedisCluster();
        String set = cluster.set("k9", "v9");
        System.out.println("set = " + set);
        cluster.close();
    }

    public static JedisCluster getJedisCluster(){
        if (jedisCluster == null){

            HostAndPort hostAndPort = new HostAndPort("192.168.56.102",6391);

            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(10);
            config.setMaxIdle(5);
            config.setMinIdle(5);
            config.setBlockWhenExhausted(true);
            config.setMaxWaitMillis(1000);
            config.setTestOnBorrow(true);
            jedisCluster = new JedisCluster(hostAndPort,config);
        }
        return jedisCluster;
    }
}
