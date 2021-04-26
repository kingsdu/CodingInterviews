package JavaSE.BLS.Thread.ReentrantReadLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class A01_ReentrantReadLockWork
{
    final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public void get()
    {
        try
        {
            lock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + "get begin");
            Thread.sleep(1000l);
            System.out.println(Thread.currentThread().getName() + "get end");
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }finally
        {
            lock.readLock().unlock();
        }
    }
    
    
    public void put()
    {
        try
        {
            lock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + "put begin");
            Thread.sleep(1000l);
            System.out.println(Thread.currentThread().getName() + "put end");
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }finally
        {
            lock.writeLock().unlock();
        }
    }

}
