package JavaSE.BLS.Thread.CachedThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 *
 *
 * newCachedThreadPool，一次性创建出20个线程存储在线程池中，sleep完毕后，再次从线程池中获取已经创建的线程，线程池中的线程60s内没有被调用会被回收。
 *
 *
 *
 */
public class CachedThreadPoolDemo
{
    
    public static void main(String[] args)
    {
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 20; i++)
        {
            final int no = i;
            Runnable run = new Runnable(){
                @Override
                public void run(){
                    try
                    {
                        System.out.println("into" + no);
                        Thread.sleep(1000l);
                        System.out.println("end" + no);
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            };
            pool.execute(run);
        }
        pool.shutdown();
        System.out.println("主线程结束");
    }
    
}
