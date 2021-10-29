package com.lifengming.redis.lock;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author lifengming
 * @since 2020.01.07
 */
public class RedisTest {

    @Test
    public void test() {
        System.out.println(5000 - System.currentTimeMillis() % 1000);

    }

    @org.junit.Test
    public void testRedis(){
        Jedis jedis=new Jedis("47.96.188.139",8005);
        jedis.auth("123456");
        SetParams setParams=new SetParams();
        setParams.ex(20);  //setex     设置值的同时设置过期时间
        setParams.nx();  //
        String s = UUID.randomUUID().toString();
        String lock = jedis.set("lock", s,setParams);
        Long setnx = jedis.setnx("lock", "value2");
        if(setnx==1){
            jedis.expire("lock",10);
        }

        System.out.println(lock);
    }
}
