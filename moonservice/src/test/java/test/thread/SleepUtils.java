package test.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by maguoqiang on 16/6/19.
 *
 */
public class SleepUtils {
    public static final void second(long seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
