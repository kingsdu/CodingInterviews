package JavaSE.BLS.Thread.ProducerConsumer.Lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class ResourcesGS_Lock
{
    private String name;
    private int count = 1;
    private boolean flag = false;
    private Lock lock = new ReentrantLock();
    /**
     * singleAll() 唤醒了所有的线程，浪费资源，其实对于消费者来说只需要唤醒生产者，生产者只需要唤醒消费者。
     * lock 一个锁对象上可以绑定多个监视器，可以实现该功能。
     */
    //一个锁上挂多个监视器对象
    Condition pro = lock.newCondition();//生产者监视器
    Condition con = lock.newCondition();//消费者监视器
    
    public void set(String name)
    {
        lock.lock();
        try
        {
            while (flag)
            {
                try
                {//wait()释放CPU执行权，也释放同步锁，使得其他线程可以使用同步控制块或者方法。
                    pro.await();//生产者睡了后，唤醒消费者
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            
            this.name = name + "---" + count++;
            System.out.println(Thread.currentThread().getName() + "..生产者.." + this.name);
            flag = true;
            con.signal();
        } finally
        {
            lock.unlock();
        }
        
    }
    
    public void out()
    {
        lock.lock();
        try
        {
            while (!flag)
            {
                try
                {
                    con.await();//消费者睡了后，唤醒生产者
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "........消费者......." + this.name);
            flag = false;
            pro.signal();
        } finally
        {
            lock.unlock();
        }
    }
}
