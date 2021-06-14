package JavaSE.BLS.Thread.A00MSB.C03;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Du
 * @Date: 2021/6/13 20:34
 *
 * 可重入锁举例
 *
 * 一个同步方法可以调用另外一个同步方法，一个线程已经拥有某个对象的锁，再次申请的时候仍然会得到该对象的锁.
 * 也就是说synchronized获得的锁是可重入的
 * 这里是继承中有可能发生的情形，子类调用父类的同步方法
 *
 *
 */
public class C03_SynLock
{
    synchronized void m()
    {
        System.out.println("m start");
        try
        {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("m end");
    }
    
    public static void main(String[] args)
    {
        new C03_SynLock().m();
    }
}

class C03_SynLock_child extends C03_SynLock
{
    @Override
    synchronized void m()
    {
        System.out.println("child m start");
        super.m();
        System.out.println("child m end");
    }
}
