package com.moon.redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

/**
 * Created by mgq on 2016/2/1.
 */
@Service("redisClient")
public class RedisClient {
    public  static JedisPool jedisPool; // 池化管理jedis链接池

    static {

        //读取相关的配置
        ResourceBundle resourceBundle = ResourceBundle.getBundle("redis.redis");//读取名称为redis.properties   redis.redis  包名加文件名
        int maxActive = Integer.parseInt(resourceBundle.getString("redis.pool.maxActive"));
        int maxIdle = Integer.parseInt(resourceBundle.getString("redis.pool.maxIdle"));
        int maxWait = Integer.parseInt(resourceBundle.getString("redis.pool.maxWait"));

        String ip = resourceBundle.getString("redis.ip");
        int port = Integer.parseInt(resourceBundle.getString("redis.port"));

        JedisPoolConfig config = new JedisPoolConfig();
        //设置最大连接数
        config.setMaxTotal(maxActive);
        //设置最大空闲数
        config.setMaxIdle(maxIdle);
        //设置超时时间
        config.setMaxWaitMillis(maxWait);

        //初始化连接池
        jedisPool = new JedisPool(config, ip, port);
    }

    /**
     * 向缓存中设置字符串内容
     * @param key key
     * @param value value
     * @return
     * @throws Exception
     */
    public static boolean  set(String key,String value) throws Exception{
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{
            jedisPool.returnResource(jedis);
        }
    }

    /**
     * 向缓存中设置对象
     * @param key
     * @param value
     * @return
     */
    public static boolean  set(String key,Object value){
        Jedis jedis = null;
        try {
            String objectJson = JSON.toJSONString(value);
            jedis = jedisPool.getResource();
            jedis.set(key, objectJson);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{
            jedisPool.returnResource(jedis);
        }
    }
    /**
     * 向缓存中设置对象,以及过期时间
     * @param key
     * @param value
     * @param time 过期时间 （秒）
     * @return
     */
    public static boolean  set(String key,Object value,int time){
        Jedis jedis = null;
        try {
            String objectJson = JSON.toJSONString(value);
            jedis = jedisPool.getResource();
            jedis.setex(key,time,objectJson);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{
            jedisPool.returnResource(jedis);
        }
    }

    /**
     * 删除缓存中得对象，根据key
     * @param key
     * @return
     */
    public static boolean del(String key){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.del(key);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{
            jedisPool.returnResource(jedis);
        }
    }

    /**
     * 根据key 获取内容
     * @param key
     * @return
     */
    public static Object get(String key){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            Object value = jedis.get(key);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{
            jedisPool.returnResource(jedis);
        }
    }


    /**
     * 根据key 获取对象
     * @param key
     * @return
     */
    public static <T> T get(String key,Class<T> clazz){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String value = jedis.get(key);
            return JSONObject.parseObject(value, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{
            jedisPool.returnResource(jedis);
        }
    }
}
