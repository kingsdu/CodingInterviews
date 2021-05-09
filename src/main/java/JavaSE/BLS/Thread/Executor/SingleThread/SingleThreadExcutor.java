package JavaSE.BLS.Thread.Executor.SingleThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * 单线程线程池，此线程池保证所有任务的执行顺序按照提交的顺序执行
 *
 */
public class SingleThreadExcutor
{
    
    public static void main(String[] args)
    {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        
        for (int i = 0; i < 10; i++)
        {
            final int no = i;
            Runnable run = new Runnable()
            {
                public void run()
                {
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
            executor.execute(run);
        }
        executor.shutdown();
    }
}
