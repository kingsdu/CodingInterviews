package JavaSE.BLS.Thread.A00MSB.C08_InterView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 阅读下面的程序，并分析输出结果
 * 可以读到输出结果并不是size=5时t2退出，而是t1结束时t2才接收到通知而退出
 * 想想这是为什么？
 * <p>
 * 因为这里使用wait和notify做到，wait会释放锁，而notify不会释放锁
 * 需要注意的是，运用这种方法，必须要保证t2先执行，也就是首先让t2监听才可以
 */
public class T03_NotifyHoldingLock
{
    volatile List lists = new ArrayList();
    
    public void add(Object o)
    {
        lists.add(o);
    }
    
    public int size()
    {
        return lists.size();
    }
    
    public static void main(String[] args)
    {
        T03_NotifyHoldingLock c = new T03_NotifyHoldingLock();
        
        final Object lock = new Object();
        
        new Thread(() ->
        {
            synchronized (lock)
            {
                System.out.println("t2启动");
                if (c.size() != 5)
                {
                    try
                    {
                        lock.wait();//当线程不等于5时，sleep线程t2
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2 结束");
            }
            
        }, "t2").start();
        
        try
        {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e1)
        {
            e1.printStackTrace();
        }
        
        new Thread(() ->
        {
            System.out.println("t1启动");
            synchronized (lock)
            {
                for (int i = 0; i < 10; i++)
                {
                    c.add(new Object());
                    System.out.println("add " + i);
                    if (c.size() == 5)
                    {   //notify不释放锁，所以wait回来 t1继续还继续执行
                        lock.notify();//当线程等于5时，唤醒线程t2
                    }
                    try
                    {
                        TimeUnit.SECONDS.sleep(1);//并sleep t1保证t2先拿到锁，但是没用。因为notify不释放锁
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }, "t1").start();
        
        
    }
}
