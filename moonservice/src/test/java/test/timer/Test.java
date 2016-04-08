package test.timer;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
/**
 * Created by maguoqiang on 2016/4/1.
 */
public class Test {
    static int count = 0;
    public static void main(String[] args) {
        //timer1();
        //timer2();
        //timer3();
        timer4();
    }

    // 第一种方法：设定指定任务task在指定时间time执行 schedule(TimerTask task, Date time)
    public static void timer1() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("-------设定要指定任务--------");
            }
        }, 2000);// 设定指定的时间time,此处为2000毫秒
    }

    // 第二种方法：设定指定任务task在指定延迟delay后进行固定延迟peroid的执行
    // schedule(TimerTask task, long delay, long period)
    public static void timer2() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("-------设定要指定任务--------");
            }
        }, 1000, 1000);
    }

    // 第三种方法：设定指定任务task在指定延迟delay后进行固定频率peroid的执行。
    // scheduleAtFixedRate(TimerTask task, long delay, long period)
    public static void timer3() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                System.out.println("-------设定要指定任务--------");
            }
        }, 1000, 2000);
    }

    // 第四种方法：安排指定的任务task在指定的时间firstTime开始进行重复的固定速率period执行．
    // Timer.scheduleAtFixedRate(TimerTask task,Date firstTime,long period)
    public static void timer4() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 18); // 控制时
        calendar.set(Calendar.MINUTE, 17);       // 控制分
        calendar.set(Calendar.SECOND, 0);       // 控制秒

        final Date time = calendar.getTime();         // 得出执行任务的时间,此处为今天的12：00：00
        System.out.println(time);

        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                ++count;
                System.out.println("-------设定要指定任务--------" + count);
                final Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    public void run() {
                        ++count;
                        if (count < 5) {
                            System.out.println("-------设定要指定任务---内-----" + count);
                            }
                        }
                    }
                    ,time,1000*5);
                }
            }, time);
    }
}
