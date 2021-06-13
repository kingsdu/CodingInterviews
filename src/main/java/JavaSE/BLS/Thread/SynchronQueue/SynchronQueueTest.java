package JavaSE.BLS.Thread.SynchronQueue;

import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;

/**
 *
 * 不存储元素的阻塞队列，每一个put操作必须等待一个take操作，否则不能继续添加元素。
 * 该队列非常适合传递性场景，比如将一个线程的数据传递给另一个线程，所以SynchronQueue具有很高的吞吐量
 *
 */
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
