package JavaSE.MSB.Thread.A04_Lock;

import JavaSE.MSB.Thread.A01_Fun.SleepHelper;

/**
 * @Author: Du
 * @Date: 2021/6/13 17:26
 */
public class SynchronizeLock
{
    //synchronized是可重入锁
    synchronized void m1(){
        System.out.println("m1 start");
        SleepHelper.sleepSeconds(1);
        m2();//重入到m2
        System.out.println("m1 end");
    }
    
    synchronized void m2(){
        SleepHelper.sleepSeconds(2);
        System.out.println("m2");
    }
    
    public static void main(String[] args)
    {
        new SynchronizeLock().m1();
    }
}
