package JavaSE.BLS.Thread.ThreadState;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Du
 * @Date: 2021/6/9 17:59
 */
public class T01_ThreadState
{
    
    public static void main(String[] args) throws InterruptedException
    {
        test05();
    }
    
    private static void test05()
    {   //LockSupport 和 synchronized的区别
        Thread t5 = new Thread(()->{
            LockSupport.park();
        });
        
        t5.start();
        
        SleepHelper.sleepSeconds(1);
    
        System.out.println("8: "+t5.getState());//WAITING
        LockSupport.unpark(t5);
    }
    
    private static void test04()
    {   //Lock 和 synchronized的区别
        final Lock lock = new ReentrantLock();//使用JUC的锁，CAS实现，盲等待，所以进入waiting状态，只有synchronized是BLOCKED
        Thread t4 = new Thread(() ->
        {
            lock.lock();
            System.out.println("t4 得到了锁 o");
            lock.unlock();
        });
    
        new Thread(()->{
            lock.lock();
            SleepHelper.sleepSeconds(5);
            lock.unlock();
        }).start();
        
        SleepHelper.sleepSeconds(1);
        
        t4.start();
        SleepHelper.sleepSeconds(1);
        System.out.println("7:"+t4.getState());//WAITING
    }
    
    private static void test03()
    {
        final Byte o = new Byte("1");
        Thread t3 = new Thread(() ->
        {
            synchronized (o){
                System.out.println("t3 得到了锁 o");
            }
        });
        
        //先启动线程，锁住锁5s
        new Thread(()->{
            synchronized (o){
                SleepHelper.sleepSeconds(5);
            }
        }).start();
    
        SleepHelper.sleepSeconds(1);//保证锁已经被锁住
        
        t3.start();//申请锁，但是锁被占住了
        SleepHelper.sleepSeconds(1);
        System.out.println("6:"+t3.getState());//所以是BLOCKED，只有synchronized是BLOCKED
    }
    
    private static void test02()
    {
        Thread t2 = new Thread(() ->
        {
            LockSupport.park();//阻塞
            System.out.println("t2 go on!");
            SleepHelper.sleepSeconds(5);
        });
        
        t2.start();
        SleepHelper.sleepSeconds(1);//保证t2开始执行
        System.out.println("4:"+t2.getState());//park，所以WAITING
    
        LockSupport.unpark(t2);//叫醒t2
        SleepHelper.sleepSeconds(1);
        System.out.println("5:"+t2.getState());//醒了后继续sleep，传了时间，所以是TIMED_WAITING
    }
    
    private static void test01() throws InterruptedException
    {
        Thread t1 = new Thread(() ->
        {
            System.out.println("2:" + Thread.currentThread().getState());//Runnable
            for (int i = 0; i < 3; i++)
            {
                SleepHelper.sleepSeconds(1);
                System.out.print(i + " ");
            }
        });
        
        System.out.println("1:" + t1.getState());//刚刚new出来
        t1.start();
        t1.join();//等待t1执行完毕
        System.out.println("3:" + t1.getState());
    }
}
