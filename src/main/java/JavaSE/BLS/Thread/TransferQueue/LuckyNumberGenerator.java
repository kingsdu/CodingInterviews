package JavaSE.BLS.Thread.TransferQueue;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class LuckyNumberGenerator
{
    
    public static void main(String[] args)
    {
        TransferQueue<String> queue = new LinkedTransferQueue<>();
        Thread producer = new Thread(new Producer(queue));
        producer.setDaemon(true);
        
        producer.start();
        
        for (int i = 0; i < 10; i++)
        {
            Thread consumer = new Thread(new Consumer(queue));
            consumer.setDaemon(true);
            consumer.start();
            try
            {
                Thread.sleep(1000l);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            
        }
    }
    
}
