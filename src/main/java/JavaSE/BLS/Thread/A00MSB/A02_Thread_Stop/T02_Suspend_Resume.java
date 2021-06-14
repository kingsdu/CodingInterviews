package JavaSE.BLS.Thread.A00MSB.A02_Thread_Stop;

import JavaSE.BLS.Thread.A00MSB.A01.SleepHelper;

/**
 * @Author: Du
 * @Date: 2021/6/10 18:09
 */
public class T02_Suspend_Resume
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
        
        t1.suspend();//暂停
        
        SleepHelper.sleepSeconds(3);
        
        t1.resume();//继续
        
        SleepHelper.sleepSeconds(1);
        
        t1.suspend();
        //被废弃的原因：和stop类似
        //在suspend时，持有锁，锁不会被释放，就继续暂停状态，这样锁可能永远不会被释放了
    }
    
}
