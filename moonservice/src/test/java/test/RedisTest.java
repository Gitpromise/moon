package test;

import com.moon.redis.RedisClient;
import org.junit.Test;

/**
 * Created by mgq on 2016/2/1.
 */
public class RedisTest {
    @Test
    public void testJedis()throws Exception{
        RedisClient redisClient=new RedisClient();
        System.out.println(redisClient);

        redisClient.set("key01", "测试redis");

        Object o=RedisClient.get("key01");
        System.out.println(o);
    }
}
