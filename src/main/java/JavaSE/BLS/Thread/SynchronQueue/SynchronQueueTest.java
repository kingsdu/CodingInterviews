package JavaSE.BLS.Thread.SynchronQueue;

import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;

public class SynchronQueueTest
{
    
    public static void main(String[] args)
    {
        System.out.println("begin:" + (System.currentTimeMillis() / 1000));
        
        final SynchronousQueue<String> sq = new SynchronousQueue<>();
        //定义1的信号量，相当于一个互斥锁
        final Semaphore sem = new Semaphore(1);
        
        for (int i = 0; i < 10; i++)
        {
            new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    try
                    {
                        sem.acquire();
                        String input = sq.take();
                        String output = TestDo.doSome(input);
                        System.out.println(Thread.currentThread().getName() + "----" + output);
                        sem.release();
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        //10个生产者生产数据，消费者调用TestDo.doSome()进行处理，每个消费者处理1s
        for (int i = 0; i < 10; i++)
        {
            String input = i + "";
            try
            {
                sq.put(input);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
    
}
