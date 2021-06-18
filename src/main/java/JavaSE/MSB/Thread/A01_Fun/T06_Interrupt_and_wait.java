package JavaSE.MSB.Thread.A01_Fun;

/**
 * @Author: Du
 * @Date: 2021/6/10 17:48
 */
public class T06_Interrupt_and_wait
{
    
    public static void main(String[] args)
    {
        t1();
    }
    
    static final Object o = new Object();
    
    private static void t1()
    {
        Thread t = new Thread(() ->
        {
            synchronized (o){
                try
                {
                    o.wait();//wait方法会抛出（进入到）异常catch部分，根据自己的需求处理异常
                } catch (InterruptedException e)
                {
                    System.out.println("Thread is interrupted!");
                    System.out.println(Thread.currentThread().isInterrupted());//进入catch后，Java会自动将isInterrupted复位为false
                }
            }
        });
        
        t.start();
        
        SleepHelper.sleepSeconds(2);
        
        t.interrupt();
    }
}
