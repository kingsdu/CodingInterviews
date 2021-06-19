package JavaSE.MSB.Thread.C03_Synchronized;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Du
 * @Date: 2021/6/13 20:33
 *
 *
 * synchronized获得的锁是可重入的
 */
public class C02_SynLock
{
    
    synchronized void m1()
    {
        System.out.println("m1 start");
        try
        {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        m2();
        System.out.println("m1 end");
    }
    
    synchronized void m2()
    {
        try
        {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("m2");
    }
    
    public static void main(String[] args)
    {
        new C02_SynLock().m1();
    }
}
