package JavaSE.BLS.Thread.LoadSequence;


/**
 *
 * t1 t3 t5 t4 全部 obj.wait();
 * t2获得线程执行权，obj.notifyAll();
 * t1 t3 t5 t4 醒来，但是同步锁和执行权还是在t2,t2执行完毕，释放锁权和执行权
 *
 * t1 t3 t5 t4 逆序执行
 *
 */
public class WaitNotify
{
    public static void main(String[] args) throws Exception
    {
        final Object obj = new Object();
        Thread t1 = new Thread()
        {
            public void run()
            {
                synchronized (obj)
                {
                    try
                    {
                        obj.wait();
                        System.out.println("Thread 1 wake up.");
                    } catch (InterruptedException e)
                    {
                    }
                }
            }
        };
        t1.start();
    
        Thread t5 = new Thread()
        {
            public void run()
            {
                synchronized (obj)
                {
                    try
                    {
                        obj.wait();
                        System.out.println("Thread 5 wake up.");
                    } catch (InterruptedException e)
                    {
                    }
                }
            }
        };
        t5.start();
    
        Thread t3 = new Thread()
        {
            public void run()
            {
                synchronized (obj)
                {
                    try
                    {
                        obj.wait();
                        System.out.println("Thread 3 wake up.");
                    } catch (InterruptedException e)
                    {
                    }
                }
            }
        };
        t3.start();
    
        Thread t4 = new Thread()
        {
            public void run()
            {
                synchronized (obj)
                {
                    try
                    {
                        obj.wait();
                        System.out.println("Thread 4 wake up.");
                    } catch (InterruptedException e)
                    {
                    }
                }
            }
        };
        t4.start();
    
        
        Thread.sleep(1000);//We assume thread 1 must start up within 1 sec.
        Thread t2 = new Thread()
        {
            public void run()
            {
                synchronized (obj)
                {
                    obj.notifyAll();
                    System.out.println("Thread 2 sent notify.");
                }
            }
        };
        t2.start();
    }
    
}
