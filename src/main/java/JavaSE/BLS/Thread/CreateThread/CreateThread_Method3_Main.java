package JavaSE.BLS.Thread.CreateThread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CreateThread_Method3_Main
{
    
    public static void main(String[] args)
    {
        CreateThread_Method3 c3 = new CreateThread_Method3();
        FutureTask<String> task = new FutureTask<String>(c3);
        
        new Thread(task).start();
    
        System.out.println("这是主线程：start");
    
        try
        {
            System.out.println(task.get());
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        } catch (ExecutionException e)
        {
            e.printStackTrace();
        }
    
        System.out.println("这是主线程：end");
    }
}
