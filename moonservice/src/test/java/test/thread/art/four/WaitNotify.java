package test.thread.art.four;

import test.thread.SleepUtils;

/**
 * Created by maguoqiang on 16/7/6.
 * 等待／通知
 */
public class WaitNotify {
    private static Boolean flag=true;
    private static Object lock=new Object();

    public static void main(String[] args) {
        Thread wait=new Thread(new Wait());
        Thread notify=new Thread(new Notify());
        wait.start();
        notify.start();
    }
    static class Wait implements Runnable{

        public void run() {
            synchronized (lock){
                while (flag){
                    try {
                        System.out.println("lock is true");
                        lock.wait();
                        System.out.println("wait is over");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("lock is false");
            }
        }
    }

    static class Notify implements Runnable{

        public void run() {
            synchronized (lock){
                System.out.println("hold lock notify");
                flag=false;
                lock.notifyAll();
                SleepUtils.second(5);
            }
            synchronized (lock){
                System.out.println("hold lock again");
                SleepUtils.second(5);
            }
        }
    }
}
