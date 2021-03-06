package JavaSE.MSB.Thread.C03_Synchronized;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Du
 * @Date: 2021/6/13 20:37
 *
 * 程序在执行过程中，如果出现异常，默认情况锁会被释放
 * 所以，在并发处理的过程中，有异常要多加小心，不然可能会发生不一致的情况。
 * 比如，在一个web app处理过程中，多个servlet线程共同访问同一个资源，这时如果异常处理不合适，
 * 在第一个线程中抛出异常，其他线程就会进入同步代码区，有可能会访问到异常产生时的数据。
 * 因此要非常小心的处理同步业务逻辑中的异常
 *
 * synchronized的底层实现
 * JDK早期的 重量级 - OS
 * 后来的改进
 * 锁升级的概念：
 *     我就是厕所所长 （一 二）
 *
 * sync (Object)
 * markword 记录这个线程ID （偏向锁）
 * 如果线程争用：升级为 自旋锁
 * 10次以后，
 * 升级为重量级锁 - OS
 *
 * 执行时间短（加锁代码），线程数少，用自旋
 * 执行时间长，线程数多，用系统锁
 *
 */
public class C04_SynException
{
    int count = 0;
    
    synchronized void m()
    {
        System.out.println(Thread.currentThread().getName() + " start");
        while (true)
        {
            count++;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
            try
            {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            
            if (count == 5)
            {
                int i = 1 / 0; //此处抛出异常，锁将被释放，要想不被释放，可以在这里进行catch，然后让循环继续
                System.out.println(i);
//                try
//                {
//                    int i = 1 / 0; //此处抛出异常，锁将被释放，要想不被释放，可以在这里进行catch，然后让循环继续
//                    System.out.println(i);
//                } catch (Exception e)
//                {
//                    e.printStackTrace();
//                }
            }
        }
    }
    
    public static void main(String[] args)
    {
        C04_SynException t = new C04_SynException();
        Runnable r = new Runnable()
        {
            @Override
            public void run()
            {
                t.m();
            }
        };
        new Thread(r, "t1").start();
        
        try
        {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        
        new Thread(r, "t2").start();
    }
}
