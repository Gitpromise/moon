package test.uuid;

import org.junit.Test;

import java.util.UUID;

/**
 * Created by maguoqiang on 2016/4/5.
 */
public class UuidDemo {
    @Test
    public void test01(){
        System.out.println(UUID.randomUUID());
    }
    @Test
    public void test02(){
        Math.random();
        System.out.println((int) ((Math.random() * 9 + 1) * 100000));
    }
}
