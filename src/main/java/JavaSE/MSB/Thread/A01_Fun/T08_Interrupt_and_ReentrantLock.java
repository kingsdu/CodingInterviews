package JavaSE.MSB.Thread.A01_Fun;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Du
 * @Date: 2021/6/10 17:55
 *
 * lock.lockInterruptibly();可以打断锁的状态
 *
 *
 */
public class T08_Interrupt_and_ReentrantLock
{
    private static ReentrantLock lock = new ReentrantLock();
    
    public static void main(String[] args)
    {
        t01();
    }
    
    private static void t01()
    {
        Thread t1 = new Thread(() ->
        {
            lock.lock();
            try
            {
                SleepHelper.sleepSeconds(5);
            } catch (Exception e)
            {
                lock.unlock();
            }
            System.out.println("t1 end");
        });
    
        t1.start();
        
        SleepHelper.sleepSeconds(1);
    
        Thread t2 = new Thread(() ->
        {
            System.out.println("t2 start");
            try
            {
                lock.lockInterruptibly();//有线程重置 锁标志位，就抛出异常
            } catch (Exception e)
            {
                System.out.println("t2 catch");
                e.printStackTrace();
            }finally
            {
                lock.unlock();
            }
            System.out.println("t2 end");
        });
        
        t2.start();
    
        SleepHelper.sleepSeconds(1);
        
        t2.interrupt();
    }
    
    
}
