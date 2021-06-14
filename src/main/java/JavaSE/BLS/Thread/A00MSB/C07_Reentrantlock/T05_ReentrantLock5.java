
package JavaSE.BLS.Thread.A00MSB.C07_Reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Reentrantlock和synchronized区别
 * ReentrantLock默认是非公平锁
 * ReentrantLock还可以指定为公平锁
 *
 * 公平锁，谁在前等待，谁就先被执行，先来后到，跟等待时间没有关系
 * 如果来了一把新锁，会不会检查是否有锁的等待队列的，是公平锁的关键。非公平锁不会检查，就可能会一上来就抢夺锁。
 * 凡是公平锁 并不是一定公平。
 */
public class T05_ReentrantLock5 extends Thread
{
    
    private static ReentrantLock lock = new ReentrantLock(true); //参数为true表示为公平锁，请对比输出结果
    
    public void run()
    {
        for (int i = 0; i < 100; i++)
        {
            lock.lock();
            try
            {
                System.out.println(Thread.currentThread().getName() + "获得锁");
            } finally
            {
                lock.unlock();
            }
        }
    }
    
    public static void main(String[] args)
    {
        T05_ReentrantLock5 rl = new T05_ReentrantLock5();
        Thread th1 = new Thread(rl);
        Thread th2 = new Thread(rl);
        th1.start();
        th2.start();
    }
}
