package com.jredis;

import com.sun.org.apache.regexp.internal.RE;
import org.junit.Test;
import redis.clients.jedis.Jedis;


public class TestJredis {

    @Test
    public void jedis() {


        Jedis jedis = new Jedis(RedisConfig.host, RedisConfig.port);
        jedis.auth(RedisConfig.auth);

        jedis.set("hello", "ben");

        String val = jedis.get("hello");

        System.out.println("返回结果：" + val);
    }


}
