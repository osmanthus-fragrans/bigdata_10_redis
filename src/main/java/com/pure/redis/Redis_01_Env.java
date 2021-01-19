package com.pure.redis;

import redis.clients.jedis.Jedis;

public class Redis_01_Env {
    public static void main(String[] args) {
//        1.设置Redis的服务器的IP地址与Port端口号
        Jedis jedis = new Jedis("hadoop102",6379);
//        2.测试连通性
        String pong = jedis.ping();
        System.out.println("Jedis : " + pong);
//        3.关闭资源
        jedis.close();
    }
}
