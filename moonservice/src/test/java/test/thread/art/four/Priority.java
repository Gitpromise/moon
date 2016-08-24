package test.thread.art.four;

import test.thread.SleepUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maguoqiang on 16/8/23.
 * 线程优先级，有些操作系统甚至会忽略对线程优先级的设定
 */
public class Priority {
    private static volatile boolean notStart=true;
    private static volatile boolean notEnd=true;
    public static void main(String[] args) {
        List<Job> jobs=new ArrayList<Job>();
        for (int i = 0; i < 10; i++) {
            int priority=i<5?Thread.MIN_PRIORITY:Thread.MAX_PRIORITY;
            Job job=new Job(priority);
            jobs.add(job);
            Thread thread=new Thread(job,"Thread:"+i);
            thread.start();
        }
        notStart=false;
        SleepUtils.second(10);
        notEnd=false;
        for (Job job:jobs){
            System.out.println("Job Priority:"+job.priority+",Count:"+job.jobCount);
        }
    }
    static class Job implements Runnable{
        private int priority;
        private long jobCount;

        public Job(int priority){
            this.priority=priority;
        }
        public void run() {
//            while (notStart){
//                Thread.yield();
//            }
            while (notEnd) {
                //Thread.yield();
                jobCount++;
            }
        }
    }
}
