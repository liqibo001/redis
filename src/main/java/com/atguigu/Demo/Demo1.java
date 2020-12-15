package com.atguigu.Demo;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class Demo1 {
    public static void main(String[] args) {
        Jedis jedis = Jedis_util.getJedisFromPool();
        String set = jedis.set("k1", "v1");
        String set1 = jedis.set("k2", "v2");
        String set2 = jedis.set("k3", "v3");
        Set<String> keys = jedis.keys("*");
        System.out.println(keys.size());
        for (String key : keys) {
            System.out.println(key);
        }

        System.out.println(jedis.exists("k1")); //k1是否存在


        System.out.println(jedis.get("k1"));  //获得k1的值

        jedis.close();
    }
}
