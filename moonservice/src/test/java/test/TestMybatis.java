package test;


import com.moon.auth.entity.Depart;
import com.moon.auth.service.IDepartService;
import com.moon.netty.client.BootClient;
import com.moon.netty.client.NettyClient;
import com.moon.netty.server.BootServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by mgq on 2016/1/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class TestMybatis {

    @Resource(name = "departServiceImpl")
    private IDepartService departService;
    @Test
    public void testDao(){
        long startTime=System.currentTimeMillis();
        //使用redis耗时847毫秒(循环100)   5257毫秒(循环1000)
        //不使用1040毫秒         11575毫秒
        for (int i=0;i<1000;i++) {
            Depart depart = departService.getDepartById("1ad73acf05b511e5a09e02004c4f4f50");
            //System.out.println(depart);
        }
        long endTime=System.currentTimeMillis();
        System.out.println("耗时:"+(endTime-startTime)+"毫秒");

    }
    @Resource
    private BootServer bootServer;

    @Resource
    private BootClient bootClient;

    @Test
    public void testNetty(){
        String [] a=new String[10];
        bootServer.main(a);

    }
    @Test
    public void testClient()throws Exception{
        String [] a=new String[10];
        bootClient.main(a);
    }
}
