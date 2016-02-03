package test;

import com.moon.redis.RedisClient;
import org.junit.Test;

/**
 * Created by mgq on 2016/2/1.
 */
public class RedisTest {
    @Test
    public void testJedis()throws Exception{

//        RedisClient.set("key01", "测试redis");
//        RedisClient.set("key02", "测试redisTime",10);
//        RedisClient.del("key02");
        Object o=RedisClient.get("key02");
        System.out.println(o);
    }
}
