
package JavaSE.MSB.Thread.C07_Reentrantlock;

import java.util.concurrent.TimeUnit;

/**
 * ReentrantLock用于替代synchronized
 * 本例中由于m1锁定this,只有m1执行完毕的时候,m2才能执行
 * 这里是复习synchronized最原始的语义
 */
public class T01_ReentrantLock_syn
{
    synchronized void m1()
    {
        for (int i = 0; i < 10; i++)
        {
            try
            {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println(i);
            if (i == 2) m2();//synchronized是可重入锁
        }
    }
    
    synchronized void m2()
    {
        System.out.println("m2 ...");
    }
    
    public static void main(String[] args)
    {
        T01_ReentrantLock_syn rl = new T01_ReentrantLock_syn();
        new Thread(rl::m1).start();
        try
        {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
