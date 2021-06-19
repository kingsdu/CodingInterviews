package JavaSE.MSB.Thread.C02_Thread_Stop;

import JavaSE.MSB.Thread.C00_Common.SleepHelper;

/**
 * @Author: Du
 * @Date: 2021/6/10 18:05
 */
public class T01_Stop
{
    
    public static void main(String[] args)
    {
        t01();
    }
    
    private static void t01()
    {
        Thread t1 = new Thread(() ->
        {
            while (true)
            {
                System.out.println("go on");
                SleepHelper.sleepSeconds(1);
            }
        });
        
        t1.start();
        
        SleepHelper.sleepSeconds(3);
        
        t1.stop();//使用stop方法结束线程，已废弃，不推荐
        //为什么不建议用：容易产生数据不一致的问题。
        //会释放所有的锁，且没有善后工作
    }
}
