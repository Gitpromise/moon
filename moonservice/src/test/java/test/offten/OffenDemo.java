package test.offten;

import org.junit.Test;

/**
 * Created by maguoqiang on 2016/5/10.
 */
public class OffenDemo {
    int b=0;
    @Test
    public void testVr1(){
        //局部变量的的访问速度远远高于类的成员变量
        int a=0;
        long start=System.currentTimeMillis();
        for (int i=0;i<2000000000;i++){
            a++;
        }
        long end=System.currentTimeMillis();
        System.out.println(end-start);//4

        long start01=System.currentTimeMillis();
        for (int i=0;i<2000000000;i++){
            b++;
        }
        long end01=System.currentTimeMillis();
        System.out.println(end01-start01);//95
    }

    @Test
    public void testVr2(){
        //位运算代替乘除法
        long a=100;
        long start=System.currentTimeMillis();
        for (int i=0;i<20000000;i++){
            a*=2;
            a/=2;
        }
        long end=System.currentTimeMillis();
        System.out.println(end-start);//26

        long start01=System.currentTimeMillis();
        for (int i=0;i<20000000;i++){
            a<<=1;
            a>>=1;
        }
        long end01=System.currentTimeMillis();
        System.out.println(end01-start01);//2
    }
}
