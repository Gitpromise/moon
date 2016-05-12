package test;

import com.moon.redis.RedisClient;
import org.junit.Test;

/**
 * Created by mgq on 2016/2/1.
 *
 * 感觉这东西跟mongodb差不多，安装和布置挺简单，
 下载地址：https://github.com/dmajkic/redis/downloads 下载下来的包里有两个，
 一个是32位的，一个是64位的。根据自己的实情情况选择，我的是64bit，
 把这个文件夹复制到其它地方，比如D:\JavaWork\rediswork\redis-2.4.5-win32-win64\32bit目录下。
 打开一个cmd窗口  使用cd命令切换目录到D:\JavaWork\rediswork\redis-2.4.5-win32-win64\32bit 运行 redis-server.exe redis.conf
 如果想方便的话，可以把redis的路径加到系统的环境变量里，这样就省得再输路径了，后面的那个redis.conf可以省略，如果省略，会启用默认的。输入之后，会显示如下界面：


 这时候别启一个cmd窗口，原来的不要关闭，不然就无法访问服务端了
 切换到redis目录下运行 redis-cli.exe -h 127.0.0.1 -p 6379 出现下图：
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
