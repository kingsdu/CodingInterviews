
package JavaSE.MSB.Thread.C07_Reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * reentrantlock和synchronized区别
 * 使用ReentrantLock还可以调用lockInterruptibly方法，可以对线程interrupt方法做出响应，
 * 在一个线程等待锁的过程中，可以被打断
 */
public class T04_ReentrantLock4
{
    public static void main(String[] args)
    {
        Lock lock = new ReentrantLock();
        
        Thread t1 = new Thread(() ->
        {
            try
            {
                lock.lock();
                System.out.println("t1 start");
                TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
                System.out.println("t1 end");
            } catch (InterruptedException e)
            {
                System.out.println("interrupted!");
            } finally
            {
                lock.unlock();
            }
        });
        t1.start();
        
        Thread t2 = new Thread(() ->
        {
            try
            {
                //lock.lock();//这种方式无法打断线程t1
                lock.lockInterruptibly(); //可以对interrupt()方法做出响应，可以打断t1的锁
                System.out.println("t2 start");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("t2 end");
            } catch (InterruptedException e)
            {
                System.out.println("interrupted!");
            } finally
            {
                //lock.unlock();
            }
        });
        t2.start();
        
        try
        {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        t2.interrupt(); //打断线程2的等待
        
    }
}
