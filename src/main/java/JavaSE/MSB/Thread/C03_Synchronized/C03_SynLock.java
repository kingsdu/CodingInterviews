package JavaSE.MSB.Thread.C03_Synchronized;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Du
 * @Date: 2021/6/13 20:34
 *
 * 可重入锁举例
 *
 * 这里是继承中有可能发生的情形，子类调用父类的同步方法
 * 父类和子类时同一把锁
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
        new C03_SynLock_child().m();
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
