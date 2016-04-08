package test.thread;

import lombok.Synchronized;

/**
 * Created by maguoqiang on 2016/3/17.
 */
public class ThreadTest implements Runnable {

    private static int i=20;


    @Override
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
}
