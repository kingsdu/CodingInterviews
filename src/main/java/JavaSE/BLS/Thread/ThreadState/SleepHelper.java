package JavaSE.BLS.Thread.ThreadState;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Du
 * @Date: 2021/6/9 18:00
 */
public class SleepHelper
{
    public static void sleepSeconds(int seconds){
        try
        {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
