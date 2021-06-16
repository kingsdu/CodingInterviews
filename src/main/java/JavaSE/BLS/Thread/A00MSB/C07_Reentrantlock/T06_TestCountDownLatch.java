package JavaSE.BLS.Thread.A00MSB.C07_Reentrantlock;

import java.util.concurrent.CountDownLatch;

public class T06_TestCountDownLatch
{
    public static void main(String[] args)
    {
        usingJoin();
//        usingCountDownLatch();
    }
    
    private static void usingCountDownLatch()
    {
        Thread[] threads = new Thread[100];
        CountDownLatch latch = new CountDownLatch(threads.length);//100个门栓
        
        for (int i = 0; i < threads.length; i++)
        {
            threads[i] = new Thread(() ->
            {
                int result = 0;
                for (int j = 0; j < 10000; j++) result += j;
                System.out.println(result);
                latch.countDown();//开1个门栓
            });
        }
        
        for (int i = 0; i < threads.length; i++)
        {
            threads[i].start();
        }
        
        try
        {
            latch.await();//门栓栓柱门 计数100 每个线程结束都会countdown 当计数100==0 结束计数
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        
        System.out.println("end latch");
    }
    
    
    //也可以用Join，让所有线程都等待在一起，当前线程结束了才能自动向前走
    private static void usingJoin()
    {
        Thread[] threads = new Thread[100];
        
        for (int i = 0; i < threads.length; i++)
        {
            threads[i] = new Thread(() ->
            {
                int result = 0;
                for (int j = 0; j < 10000; j++) result += j;
                System.out.println(result);
            });
        }
        
        for (int i = 0; i < threads.length; i++)
        {
            threads[i].start();
        }
        //当前线程结束了才能自动向前走
        for (int i = 0; i < threads.length; i++)
        {
            try
            {
                threads[i].join();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        
        System.out.println("end join");
    }
}
