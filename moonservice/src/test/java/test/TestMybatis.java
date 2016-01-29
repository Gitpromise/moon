package test;


import com.moon.auth.entity.Depart;
import com.moon.auth.service.IDepartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by mgq on 2016/1/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestMybatis {

    @Resource(name = "departServiceImpl")
    private IDepartService departService;
    @Test
    public void testDao(){
        Depart depart=departService.getDepartById("1ad73acf05b511e5a09e02004c4f4f50");
        System.out.println(depart);
    }
}
