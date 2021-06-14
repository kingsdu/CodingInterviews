package JavaSE.BLS.Thread.A00MSB.A03_Volatile;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: Du
 * @Date: 2021/6/11 17:52
 */
public class T04_Contened
{
    
    public static long COUNT = 10_0000_0000L;
    
    private static class T
    {
        //@Contended //只有1.8有效
        public long x = 0L;
    }
    
    public static T[] arr = new T[2];
    
    static
    {
        arr[0] = new T();
        arr[1] = new T();
    }
    
    public static void main(String[] args) throws InterruptedException
    {
        CountDownLatch latch = new CountDownLatch(2);
        
        Thread t1 = new Thread(() ->
        {
            for (long i = 0; i < COUNT; i++)
            {
                arr[0].x = i;
            }
            latch.countDown();
        });
        
        Thread t2 = new Thread(() ->
        {
            for (long i = 0; i < COUNT; i++)
            {
                arr[1].x = i;
            }
            latch.countDown();
        });
        
        final long start = System.nanoTime();
        t1.start();
        t2.start();
        latch.await();
        System.out.println((System.nanoTime() - start) / 100_0000);
    }
    
}
