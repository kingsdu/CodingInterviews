package JavaSE.BLS.Thread.TransferQueue;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

public class Producer implements Runnable
{
    
    private final TransferQueue<String> queue;
    
    public Producer(TransferQueue<String> queue)
    {
        this.queue = queue;
    }
    
    public String Producer()
    {
        return "your lucky number" + (new Random().nextInt(100));
    }
    
    @Override
    public void run()
    {
        try
        {
            while (true)
            {
                if (queue.hasWaitingConsumer())
                {
                    queue.transfer(Producer());
                }
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
