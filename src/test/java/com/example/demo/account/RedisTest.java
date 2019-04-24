package com.example.demo.account;

import com.example.demo.events.Event;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class RedisTest {
    @Test
    public void jedis() {
        Jedis jedis = new Jedis("52.193.154.247", 26379);
        Set<String> keys = jedis.keys("*");
        System.out.println(keys);

    }

}
