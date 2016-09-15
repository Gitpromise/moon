package test.thread.art.four;

import test.thread.SleepUtils;

/**
 * Created by maguoqiang on 16/8/26.
 * Thread.join()的使用
 */
public class Join {
    public static void main(String[] args) {
        Thread previous=Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            //每个线程拥有前一个线程的引用，需要等待前一个线程终止，才能从等待中返回
            Thread thread=new Thread(new Domino(previous),String.valueOf(i));
            thread.start();
            previous=thread;
        }
        SleepUtils.second(2);
        System.out.println(Thread.currentThread().getName()+" terminate.");
    }
    static class Domino implements Runnable{
        private Thread thread;
        public Domino(Thread thread){
            this.thread=thread;
        }
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"terminate");
        }
    }
}
