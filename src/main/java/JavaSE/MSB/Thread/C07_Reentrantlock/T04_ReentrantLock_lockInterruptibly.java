
package JavaSE.MSB.Thread.C07_Reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * reentrantlock和synchronized区别
 * 使用ReentrantLock还可以调用lockInterruptibly方法，可以对线程interrupt方法做出响应，
 * 在一个线程等待锁的过程中，可以被打断
 */
public class T04_ReentrantLock_lockInterruptibly
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
                TimeUnit.SECONDS.sleep(3);
                System.out.println("t1 end");
            } catch (InterruptedException e)
            {
                System.out.println("t1 interrupted!");
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
                
                //可以对interrupt()方法做出响应，可以打断t1的锁，但是打断后会直接执行catch部分的代码，后t1又会重新拿到执行权继续执行
                lock.lockInterruptibly();
                
                System.out.println("t2 start");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("t2 end");
            } catch (InterruptedException e)
            {
                if (t1.isInterrupted())
                    System.out.println("t2 interrupted!");
                System.out.println("t2 interrupted!");
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
