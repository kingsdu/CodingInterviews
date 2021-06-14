package JavaSE.BLS.Thread.A00MSB.A02_Thread_Stop;

import JavaSE.BLS.Thread.A00MSB.A01.SleepHelper;

/**
 * @Author: Du
 * @Date: 2021/6/10 18:18
 */
public class T04_Interupted_and_NolmalThread
{
    public static void main(String[] args)
    {
        t01();
    }
    
    private static void t01()
    {
        Thread t1 = new Thread(() ->
        {
            //不依赖于中间状态的精确时间或次数时，较为合适的方法
            while (Thread.interrupted())//相对最优雅的方法
            {
            
            }
            System.out.println("t1 end");
        });
        
        t1.start();
        
        SleepHelper.sleepSeconds(1);
        
        t1.interrupt();
    }
}
