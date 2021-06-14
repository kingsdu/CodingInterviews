package JavaSE.BLS.Thread.A00MSB.A03_Volatile;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: Du
 * @Date: 2021/6/11 17:30
 */
public class T03_CacheLinePadding
{
    
    public static long COUNT = 10_0000_0000L;
    
    private static class T
    {
        //private long p1, p2, p3, p4, p5, p6, p7;//将这些注释打开，执行时间会变快？？？
        public long x = 0L;//也可以加 @Contended //只有1.8有效，run参数 要加 -XX:-RestrictContended
        //private long p9, p10, p11, p12, p13, p14, p15;
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
            for (int i = 0; i < COUNT; i++)
            {
                arr[0].x = i;
            }
            latch.countDown();
        });
        
        Thread t2 = new Thread(() ->
        {
            for (int i = 0; i < COUNT; i++)
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
