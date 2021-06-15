package JavaSE.BLS.Thread.A00MSB.C08_InterView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * notify之后，t1必须释放锁，t2退出后，也必须notify，通知t1继续执行
 * 整个通信过程比较繁琐
 * <p>
 * 使用Latch（门闩）替代wait notify来进行通知
 * 好处是通信方式简单，同时也可以指定等待时间
 * 使用await和countdown方法替代wait和notify
 * CountDownLatch不涉及锁定，当count的值为零时当前线程继续运行
 *
 * 当不涉及同步，只是涉及线程通信的时候，用synchronized + wait/notify就显得太重了
 * 这时应该考虑countdownlatch/cyclicbarrier/semaphore
 *
 */
public class T05_CountDownLatch
{
    
    // 添加volatile，使t2能够得到通知
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
        T05_CountDownLatch c = new T05_CountDownLatch();
        CountDownLatch latch = new CountDownLatch(1);
        new Thread(() ->
        {
            System.out.println("t2启动");
            if (c.size() != 5)
            {
                try
                {
                    latch.await();
                    //也可以指定等待时间
                    //latch.await(5000, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            System.out.println("t2 结束");
            latch.countDown();
            
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
            for (int i = 0; i < 10; i++)
            {
                c.add(new Object());
                System.out.println("add " + i);
                
                if (c.size() == 5)
                {
                    // 打开门闩，让t2得以执行
                    latch.countDown();
                    try
                    {
                        latch.await();
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
                
                //这个地方必须sleep，不等待的话可能在放开栅栏后t1还能继续强到线程，或者用2个门栓
//				try {
//					TimeUnit.SECONDS.sleep(1);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
            }
            
        }, "t1").start();
        
    }
}
