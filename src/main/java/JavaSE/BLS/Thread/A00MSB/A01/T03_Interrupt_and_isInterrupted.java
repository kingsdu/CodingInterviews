package JavaSE.BLS.Thread.A00MSB.A01;

/**
 * @Author: Du
 * @Date: 2021/6/10 17:33
 *
 * 停止线程的一种方式
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
        
        t.interrupt();
    }
    
}
