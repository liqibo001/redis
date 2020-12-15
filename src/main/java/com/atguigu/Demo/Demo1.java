package com.atguigu.Demo;

import redis.clients.jedis.Jedis;


import java.util.List;
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

        jedis.mset("st1", "v1", "st2", "v2");
        List<String> mget = jedis.mget("st1", "st2");
        System.out.println(mget);

        jedis.lpush("l2","1","2","3");
        List<String> l2 = jedis.lrange("l2", 0, -1);
        System.out.println(l2);
        System.out.println(jedis.llen("l2"));
        Long l21 = jedis.llen("l2");
        for (int i = 0; i < l21; i++) {
            jedis.lpop("l2");
        }

        jedis.sadd("orders","order01");
        jedis.sadd("orders","order02");
        jedis.sadd("orders","order03");
        jedis.sadd("orders","order04");
        jedis.srem("orders","order01");
        Set<String> orders = jedis.smembers("orders");
        System.out.println(orders);

        jedis.hset("hash1", "username", "lisi");

        jedis.close();
    }
}
