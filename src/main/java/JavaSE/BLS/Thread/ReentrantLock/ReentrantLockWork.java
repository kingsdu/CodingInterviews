package JavaSE.BLS.Thread.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockWork
{
    /**
     *
     * 两个使用不同的ReentrantLock，每次执行的结果都不一样
     *
     * 使用同一个ReentrantLock，按序执行
     *
     * 注意体会！
     *
     *
     */
    final ReentrantLock lock = new ReentrantLock();
    public void get()
    {//不同的锁对象，就会存在线程安全问题
//        final ReentrantLock lock = new ReentrantLock();
        try
        {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "get begin");
            Thread.sleep(1000l);
            System.out.println(Thread.currentThread().getName() + "get end");
            lock.unlock();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    
    
    public void put()
    {
//        final ReentrantLock lock = new ReentrantLock();
        try
        {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "put begin");
            Thread.sleep(1000l);
            System.out.println(Thread.currentThread().getName() + "put end");
            lock.unlock();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
