package test.thread.art.excise;

import test.thread.SleepUtils;

/**
 * Created by maguoqiang on 16/8/3.
 * 模拟订票系统
 */
public class Tickets {
    private static boolean flag=true;
    private static int i=1000;//原始票数
    private static final Object lock=new Object();

    public static void main(String[] args) {
        Thread buy=new Thread(new Buy());
        buy.start();
        //SleepUtils.second(2);
        Thread sell=new Thread(new Sell());
        sell.start();

    }

    public static class Sell implements Runnable{

        public void run() {
            i++;
            System.out.println("生产了一张票，还剩"+i+"张票");
            if (i>0){
                synchronized (lock){
                    System.out.println("当前票数充足，通知消费者可以购买。");
                    lock.notify();
                    flag=false;
                }
            }
        }
    }

    public static class Buy implements Runnable{

        public void run() {
            while (flag) {
                synchronized (lock) {
                i--;
                System.out.println("消费了一张票，还剩" + i + "张票。");
                if (i < 1) {
                        try {
                            System.out.println("票不足，等待");
                            lock.wait();
                            System.out.println("sdkfalk");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
