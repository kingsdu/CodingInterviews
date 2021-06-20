package JavaSE.MSB.Thread.C05_Atomic;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 *
 * 不同的线程数量得到的结果不一定
 * 100000个线程并发
 * synchronized重量锁，最慢
 * Atomic不加锁，所以较快
 * LongAdder中使用了分段锁
 *
 */
public class T02_AtomicVsSyncVsLongAdder
{
    static long count2 = 0L;
    static AtomicLong count1 = new AtomicLong(0L);
    static LongAdder count3 = new LongAdder();
    
    public static void main(String[] args) throws Exception
    {
        Thread[] threads = new Thread[1000];
        
        for (int i = 0; i < threads.length; i++)
        {
            threads[i] =
                    new Thread(() ->
                    {
                        for (int k = 0; k < 100000; k++) count1.incrementAndGet();
                    });
        }
        long start = System.currentTimeMillis();
        for (Thread t : threads) t.start();
        for (Thread t : threads) t.join();
        long end = System.currentTimeMillis();
        System.out.println("Atomic: " + count1.get() + " time " + (end - start));
        //-----------------------------------------------------------
        Object lock = new Object();
        
        for (int i = 0; i < threads.length; i++)
        {
            threads[i] =
                    new Thread(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            
                            for (int k = 0; k < 100000; k++)
                                synchronized (lock)
                                {
                                    count2++;
                                }
                        }
                    });
        }
        
        start = System.currentTimeMillis();
        
        for (Thread t : threads) t.start();
        
        for (Thread t : threads) t.join();
        
        end = System.currentTimeMillis();
        
        
        System.out.println("Sync: " + count2 + " time " + (end - start));
        
        
        //----------------------------------
        for (int i = 0; i < threads.length; i++)
        {
            threads[i] =
                    new Thread(() ->
                    {
                        for (int k = 0; k < 100000; k++) count3.increment();
                    });
        }
        
        start = System.currentTimeMillis();
        
        for (Thread t : threads) t.start();
        
        for (Thread t : threads) t.join();
        
        end = System.currentTimeMillis();
        
        System.out.println("LongAdder: " + count1.longValue() + " time " + (end - start));
    }
    
}
