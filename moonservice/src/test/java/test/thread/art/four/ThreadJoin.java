package test.thread.art.four;

import test.thread.SleepUtils;

/**
 * Created by maguoqiang on 16/7/6.
 */
public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread a=new Thread(new A());
        Thread b=new Thread(new B());
        a.start();
        a.join();
        b.start();//因为a.join()的原因，b只有等待a运行结束后才可以运行
    }
    static class A implements Runnable{

        public void run() {
            SleepUtils.second(3);
            System.out.println("a is run");
        }
    }
    static class B implements Runnable{
        public void run() {
            System.out.println("b is run");
        }
    }
}
