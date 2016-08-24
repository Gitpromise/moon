package test.thread.art.excise;

/**
 * Created by maguoqiang on 16/8/3.
 *
 */
public class Tickets02 {

    private static int count=20;
    private static Boolean flag=true;
    private static final Object lock=new Object();

    public static void main(String[] args) throws InterruptedException {
        Sell sell=new Sell();
        Thread t1=new Thread(new Sell(),"t1");
        Thread t2=new Thread(new Sell(),"t2");
        Thread t3=new Thread(new Sell(),"t3");
        Thread t4=new Thread(new Sell(),"t4");
        t2.start();
        t1.start();
        t3.start();
        t4.start();
    }

    public static class Sell implements Runnable{

        public void run() {
            while (flag){
                synchronized (lock){
                    if (count>0){
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("窗口:"+Thread.currentThread()+"剩余票数:"+count);
                        count--;
                        if (count==0){
                            System.out.println("ticket is sold out");
                            flag=false;
                        }
                    }
                }
            }
        }
    }
}
