package JavaSE.BLS.Thread.A00MSB.A01;

/**
 * @Author: Du
 * @Date: 2021/6/10 17:38
 *
 *
 * interrupted重置并查询
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
                }
            }
        });
        
        t.start();
        
        SleepHelper.sleepSeconds(2);
        
        t.interrupt();
    
        System.out.println(t.interrupted());//false，这个静态方法访问的是主线程，所以是false
    }
}
