package JavaSE.MSB.Thread.C07_Reentrantlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


/*
读锁是共享锁
写锁是排他锁

重点掌握
 */
public class T10_ReadWriteLock
{
    static Lock lock = new ReentrantLock();
    private static int value;
    
    static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    static Lock readLock = readWriteLock.readLock();
    static Lock writeLock = readWriteLock.writeLock();
    
    public static void read(Lock lock)
    {
        try
        {
            lock.lock();
            Thread.sleep(1000);
            System.out.println("read over!");
            //模拟读取操作
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        } finally
        {
            lock.unlock();
        }
    }
    
    public static void write(Lock lock, int v)
    {
        try
        {
            lock.lock();
            Thread.sleep(1000);
            value = v;
            System.out.println("write over!");
            //模拟写操作
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        } finally
        {
            lock.unlock();
        }
    }
    
    
    public static void main(String[] args)
    {
        //Runnable readR = ()-> read(lock);//读线程逐个执行
        Runnable readR = () -> read(readLock);//读线程并发执行
        
        //Runnable writeR = ()->write(lock, new Random().nextInt());//写线程逐个执行
        Runnable writeR = () -> write(writeLock, new Random().nextInt());//写线程逐个执行
        
        for (int i = 0; i < 18; i++) new Thread(readR).start();
        for (int i = 0; i < 2; i++) new Thread(writeR).start();
    }
}
