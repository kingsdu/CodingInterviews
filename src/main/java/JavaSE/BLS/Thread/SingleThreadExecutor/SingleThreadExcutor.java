package JavaSE.BLS.Thread.SingleThreadExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
