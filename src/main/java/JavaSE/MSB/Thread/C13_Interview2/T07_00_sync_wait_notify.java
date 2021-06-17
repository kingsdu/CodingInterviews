package JavaSE.MSB.Thread.C13_Interview2;

//如果要求某个线程先执行，某个线程后执行
public class T07_00_sync_wait_notify
{
    private static volatile boolean t2Started = false;
    
    //private static CountDownLatch latch = new CountDownLatch(1);
    
    public static void main(String[] args)
    {
        final Object o = new Object();
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();
        
        new Thread(() ->
        {
//            try
//            {
//                latch.await();
//            } catch (InterruptedException e)
//            {
//                e.printStackTrace();
//            }
            synchronized (o)
            {
                while (!t2Started)
                {
                    try
                    {
                        o.wait();
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }

                for (char c : aI)
                {
                    System.out.print(c);
                    try
                    {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        }, "t1").start();
        
        new Thread(() ->
        {
            synchronized (o)
            {
                for (char c : aC)
                {
                    System.out.print(c);
                    //latch.countDown();
                    t2Started = true;
                    try
                    {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        }, "t2").start();
    }
}


