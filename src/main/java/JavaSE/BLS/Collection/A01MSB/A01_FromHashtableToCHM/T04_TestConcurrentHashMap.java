package JavaSE.BLS.Collection.A01MSB.A01_FromHashtableToCHM;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * 1、效率问题一定要以实际测试为准
 * 例子： 100个线程  操作 1000000个数
 * 2、写数据时 Hashtable SynchronizedHashMap ConcurrentHashMap效率相差不大
 * 3、读数据时 ConcurrentHashMap 明显比Hashtable SynchronizedHashMap快很多
 *
 */
public class T04_TestConcurrentHashMap
{
    static Map<UUID, UUID> m = new ConcurrentHashMap<>();
    
    static int count = Constants.COUNT;
    static UUID[] keys = new UUID[count];
    static UUID[] values = new UUID[count];
    static final int THREAD_COUNT = Constants.THREAD_COUNT;
    
    static
    {
        for (int i = 0; i < count; i++)
        {
            keys[i] = UUID.randomUUID();
            values[i] = UUID.randomUUID();
        }
    }
    static class MyThread extends Thread
    {
        int start;
        int gap = count / THREAD_COUNT;
        
        public MyThread(int start)
        {
            this.start = start;
        }
        
        @Override
        public void run()
        {
            for (int i = start; i < start + gap; i++)
            {
                m.put(keys[i], values[i]);
            }
        }
    }
    
    public static void main(String[] args)
    {
        long start = System.currentTimeMillis();
        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < threads.length; i++)
        {
            threads[i] =
                    new MyThread(i * (count / THREAD_COUNT));
        }
        for (Thread t : threads)
        {
            t.start();
        }
        for (Thread t : threads)
        {
            try
            {
                t.join();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("ConcurrentHashMap写的时间--"+(end - start));
        
        System.out.println(m.size());
        
        //-----------------------------------
        
        start = System.currentTimeMillis();
        for (int i = 0; i < threads.length; i++)
        {
            threads[i] = new Thread(() ->
            {
                for (int j = 0; j < 10000000; j++)
                {
                    m.get(keys[10]);
                }
            });
        }
        for (Thread t : threads)
        {
            t.start();
        }
        for (Thread t : threads)
        {
            try
            {
                t.join();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        end = System.currentTimeMillis();
        System.out.println("ConcurrentHashMap读的时间--"+(end - start));
    }
}
