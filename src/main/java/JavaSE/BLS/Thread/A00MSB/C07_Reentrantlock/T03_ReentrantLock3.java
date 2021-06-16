
package JavaSE.BLS.Thread.A00MSB.C07_Reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * reentrantlock和synchronized区别
 * 使用reentrantlock可以进行tryLock(尝试锁定)，如果这样无法锁定，或者在指定时间内无法锁定，线程可以决定是否继续等待
 */
public class T03_ReentrantLock3
{
    Lock lock = new ReentrantLock();
    
    void m1()
    {
        try
        {
            lock.lock();
            for (int i = 0; i < 3; i++)
            {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(i);
            }
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        } finally
        {
            lock.unlock();
        }
    }
    
    /**
     * 使用tryLock进行尝试锁定，不管锁定与否，方法都将继续执行
     * 可以根据tryLock的返回值来判定是否锁定
     * 也可以指定tryLock的时间，由于tryLock(time)抛出异常，所以要注意unclock的处理，必须放到finally中
     */
    void m2()
    {
		/*
		boolean locked = lock.tryLock();
		System.out.println("m2 ..." + locked);
		if(locked) lock.unlock();
		*/
        
        boolean locked = false;
        try
        {
            locked = lock.tryLock(4, TimeUnit.SECONDS);//5s内申请锁，能申请到就运行程序，否则不做操作
            System.out.println("m2 ..." + locked);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        } finally
        {
            if (locked) lock.unlock();
        }
        
    }
    
    public static void main(String[] args)
    {
        T03_ReentrantLock3 rl = new T03_ReentrantLock3();
        new Thread(rl::m1).start();
        try
        {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        new Thread(rl::m2).start();
    }
}
