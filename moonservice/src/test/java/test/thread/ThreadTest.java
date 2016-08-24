package test.thread;

import lombok.Synchronized;
import org.junit.Test;

/**
 * Created by maguoqiang on 2016/3/17.
 * 测试
 */
public class ThreadTest implements Runnable {

    private static int i=20;


    public void run() {
        while (i>0){
            System.out.println(i--);
        }

    }

    public static void main(String[] args)throws Exception{
        ThreadTest t_01=new ThreadTest();
        ThreadTest t_02=new ThreadTest();
        ThreadTest t_03=new ThreadTest();
        ThreadTest t_04=new ThreadTest();
        ThreadTest t_05=new ThreadTest();
        t_01.run();
        Thread.sleep(10000);
        t_02.run();
        t_03.run();
        t_04.run();
        t_05.run();

    }

    public void testThread(int t) {
        //线程安全
        synchronized (Object.class) {
            for (int i = 0; i < 10; i++) {
                System.out.print(t);
            }
        }
    }
}
