package JavaSE.MSB.Collection.A01_FromHashtableToCHM;

import java.util.Hashtable;
import java.util.UUID;
/**
 *
 * 1、效率问题一定要以实际测试为准
 * 例子： 100个线程  操作 1000000个数
 * 2、写数据时 Hashtable SynchronizedHashMap ConcurrentHashMap效率相差不大
 * 3、读数据时 ConcurrentHashMap明显比Hashtable SynchronizedHashMap快很多
 *
 */
public class T01_TestHashtable
{
    
    static Hashtable<UUID, UUID> m = new Hashtable<>();
    
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
        int gap = count / THREAD_COUNT;//每个线程负责的值范围
        
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
                    new MyThread(i * (count / THREAD_COUNT));//每个线程起始值不一样，记录每个线程负责哪一部分
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
        System.out.println("Hashtable写时间----" + (end - start));
        
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
        System.out.println("Hashtable读时间----" + (end - start));
    }
}
