package JavaSE.MSB.Thread.A01;

/**
 * @Author: Du
 * @Date: 2021/6/10 17:50
 *
 *
 * 在抢锁的过程中是不会被 interrupt 所干扰的，无法打断执行的
 *
 */
public class T07_Interrupt_and_sync
{
    
    private static Object o = new Object();
    
    public static void main(String[] args)
    {
        t1();
    }
    
    private static void t1()
    {
        Thread t1 = new Thread(() ->
        {
            synchronized (o)//t1先持有锁
            {
                SleepHelper.sleepSeconds(5);
            }
        });
        
        t1.start();
        
        SleepHelper.sleepSeconds(1);
        
        Thread t2 = new Thread(() ->
        {
            synchronized (o)//t2抢夺锁
            {
            
            }
            System.out.println("t2 end");
        });
        
        t2.start();
        
        SleepHelper.sleepSeconds(1);
        
        t2.interrupt();//t2在抢锁的过程中是不会被 interrupt 所干扰的，无法打断执行的
    }
    
}
