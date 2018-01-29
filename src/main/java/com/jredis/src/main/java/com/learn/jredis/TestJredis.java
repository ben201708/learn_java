package com.learn.jredis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class TestJredis {

    @Test
    public void jedis() {


        Jedis jedis = new Jedis("localhost", 6379);
        jedis.set("hello", "ben");

        String val = jedis.get("hello");

        System.out.println("返回结果：" + val);
    }


}
