package JavaSE.MSB.Collection.A03_Map;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

//无界
//只有put 和 take 在没有元素 或者 元素满了的时候会 阻塞
public class T05_LinkedBlockingQueue
{
    static BlockingQueue<String> strs = new LinkedBlockingQueue<>();
    
    static Random r = new Random();
    
    public static void main(String[] args)
    {
        new Thread(() ->
        {
            for (int i = 0; i < 20; i++)
            {
                try
                {
                    strs.put("a" + i); //如果满了，就会等待
                    TimeUnit.MILLISECONDS.sleep(r.nextInt(1000));
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }, "p1").start();
        
        for (int i = 0; i < 5; i++)
        {
            new Thread(() ->
            {
                for (; ; )
                {
                    try
                    {
                        System.out.println(Thread.currentThread().getName() + " take -" + strs.take()); //如果空了，就会等待
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }, "c" + i).start();
        }
    }
}
