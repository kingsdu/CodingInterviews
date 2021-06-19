package JavaSE.MSB.Thread.C02_Thread_Stop;

import JavaSE.MSB.Thread.C00_Common.SleepHelper;

/**
 * @Author: Du
 * @Date: 2021/6/10 17:33
 *
 * 停止线程的第一种方式：
 * 1 执行 t.interrupt()
 * 2 通过 isInterrupted()判断
 */
public class T03_Interrupt_and_isInterrupted
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
                if (Thread.currentThread().isInterrupted())
                {
                    System.out.println("Thread is interrupted");
                    System.out.println(Thread.currentThread().isInterrupted());
                    break;
                }
            }
        });
        
        t.start();
        
        SleepHelper.sleepSeconds(2);
        
        t.interrupt();//标注停止，后面线程在运行时会检测这个标志位决定是否停止线程
    }
    
}
