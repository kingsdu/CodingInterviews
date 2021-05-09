package JavaSE.BLS.Thread.Executor.FixThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 *
 * newFixedThreadPool，是一个可重用固定线程数的线程池，以共享的无界队列来运行这些线程
 *
 */
public class FixThreadPoolDemo
{
    /**
     * 一次执行5个线程
     * @param args
     */
    public static void main(String[] args)
    {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 25 ; i++)
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
    }

}
