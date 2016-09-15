package test.thread.art.four;

import test.thread.SleepUtils;

import java.util.concurrent.TimeUnit;

/**
 * Created by maguoqiang on 16/8/24.
 * 理解中断
 */
public class Interrupted {
    public static void main(String[] args) throws Exception {
        //不停的尝试睡眠
        Thread sleepThread=new Thread(new SleepRunner(),"sleepThread");
        sleepThread.setDaemon(true);

        //不停的运转
        Thread busyThread=new Thread(new BusyRunner(),"busyThread");
        busyThread.setDaemon(true);

        sleepThread.start();
        busyThread.start();
        //休眠5秒，充分运行
        TimeUnit.SECONDS.sleep(5);
        sleepThread.interrupt();
        busyThread.interrupt();
        System.out.println("sleepThread interrupted is:" + sleepThread.isInterrupted());
        System.out.println("busyThread interrupted is:"+busyThread.isInterrupted());
        //防止sleepThread and busyThread立刻退出
        SleepUtils.second(2);
    }
    static class SleepRunner implements Runnable{
        public void run() {
            while (true){
                SleepUtils.second(10);
            }
        }
    }
    static class BusyRunner implements Runnable{
        public void run() {
            while (true){

            }
        }
    }
}
//从结果可以看出，抛出InterruptedException的线程SleepThread ,其中断标志位被清除了，而一直忙碌运作的线程BusyThread，中断标志位没有被清除
