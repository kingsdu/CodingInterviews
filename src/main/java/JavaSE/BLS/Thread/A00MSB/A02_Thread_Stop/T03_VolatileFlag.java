package JavaSE.BLS.Thread.A00MSB.A02_Thread_Stop;

import JavaSE.BLS.Thread.A00MSB.A01.SleepHelper;

/**
 * @Author: Du
 * @Date: 2021/6/10 18:12
 */
public class T03_VolatileFlag
{
    private static volatile boolean running = true;
    
    public static void main(String[] args)
    {
        t01();
    }
    
    private static void t01()
    {
        Thread t1 = new Thread(() ->
        {
            long i = 0L;
            while (running)
            {
                //wait recv accept等操作无法结束
                i++;//无法控制循环的时间
            }
            System.out.println("end and i = " + i);
        });
        
        t1.start();
        
        SleepHelper.sleepSeconds(1);
        
        running = false;
    }
    
}
