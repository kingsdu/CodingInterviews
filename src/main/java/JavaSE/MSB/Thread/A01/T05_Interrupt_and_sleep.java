package JavaSE.MSB.Thread.A01;

/**
 * @Author: Du
 * @Date: 2021/6/10 17:43
 */
public class T05_Interrupt_and_sleep
{
    public static void main(String[] args)
    {
        t1();
    }
    
    
    private static void t1()
    {
        Thread t = new Thread(() ->
        {
            try
            {
                Thread.sleep(10000);//sleep方法会抛出（进入到）异常catch部分，根据自己的需求处理异常
            } catch (InterruptedException e)
            {
                System.out.println("Thread is interrupted!");
                System.out.println(Thread.currentThread().isInterrupted());//进入catch后，Java会自动将isInterrupted复位为false
            }
        });
        
        t.start();
        
        SleepHelper.sleepSeconds(2);
        
        t.interrupt();
    }
    
    
}
