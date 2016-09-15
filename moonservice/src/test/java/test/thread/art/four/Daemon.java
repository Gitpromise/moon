package test.thread.art.four;

import test.thread.SleepUtils;

/**
 * Created by maguoqiang on 16/8/24.
 * daemon线程是一种支持性线程，当一个java虚拟机中不存在daemon线程的时候，java虚拟机将会退出。可以
 * 通过调用 Thread.setDaemon(true)将线程设置为daemon线程.
 * daemon线程被用作完成支持性工作，但是在java虚拟机退出时daemon线程中的finally块并不一定会执行
 */
public class Daemon {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Thread thread=new Thread(new DaemonRunner(),"daemon");
        //thread.setDaemon(true);//如果不设置为true，则finally中一定执行
        thread.start();
        System.out.println("mainThread run.");
    }
    static class DaemonRunner implements Runnable{
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName());
                SleepUtils.second(2);
            }finally {
                System.out.println("DaemonThread finally run.");
            }
        }
    }
}
