package JavaSE.BLS.Thread.Executor.ScheduledThreadPool;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 *
 * https://www.cnblogs.com/yufeng218/p/13211010.html
 *
 *
 */
public class ScheduledThreadDemo
{
    public static void main(String[] args)
    {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);
        /**
         * 延迟多长时间之后只执行一次；
         */
        pool.schedule(new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("延迟执行");
            }
        }, 1, TimeUnit.SECONDS);
        
        /**
         * 延迟指定时间后执行一次，之后按照固定的时长周期执行；
         * 这个执行周期是固定，不管任务执行多长时间，还是每过3秒中就会产生一个新的任务
         */
        pool.scheduleAtFixedRate(new Runnable()
        {
            @Override
            public void run()
            {
                //这个业务逻辑需要很长的时间，定时任务去统计一张数据上亿的表，财务财务信息，需要30min
                System.out.println("重复执行1");
            }
        }, 1, 3, TimeUnit.SECONDS);
        
        /**
         * 延迟指定时间后执行一次，之后按照：上一次任务执行时长 + 周期的时长 的时间去周期执行；
         * 假设12点整执行第一次任务12:00，执行一次任务需要30min，下一次任务 12:30 + 3s 开始执行
         */
        pool.scheduleWithFixedDelay(new Runnable()
        {
            @Override
            public void run()
            {
                //30min
                try
                {
                    Thread.sleep(60000 * 30);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                System.out.println("" + new Date() + "重复执行2");
            }
        }, 1, 3, TimeUnit.SECONDS);
    }
}
