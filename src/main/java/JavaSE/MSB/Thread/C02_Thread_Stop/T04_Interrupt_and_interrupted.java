package JavaSE.MSB.Thread.C02_Thread_Stop;

import JavaSE.MSB.Thread.C00_Common.SleepHelper;

/**
 * @Author: Du
 * @Date: 2021/6/10 17:38
 *
 *
 * 停止线程的第一种方式：
 * 1 t.interrupted()重置并查询
 * 2 通过 isInterrupted()判断
 *
 *
 */
public class T04_Interrupt_and_interrupted
{
    public static void main(String[] args)
    {
        t1();
    }
    
    private static void t1()
    {
        Thread t = new Thread(() ->
        {
            for (; ; )
            {
                if (Thread.interrupted())//重置标志位
                {
                    System.out.println("Thread is interrupted");
                    System.out.println(Thread.interrupted());//查询
                    break;
                }
            }
        });
        t.start();
        SleepHelper.sleepSeconds(2);
        t.interrupt();
        System.out.println(t.interrupted());//false，这个静态方法访问的是主线程，且查询后会重置，所以是false
    }
}
