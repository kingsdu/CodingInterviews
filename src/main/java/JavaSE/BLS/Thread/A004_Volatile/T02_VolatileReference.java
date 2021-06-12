package JavaSE.BLS.Thread.A004_Volatile;

import JavaSE.BLS.Thread.A002_ThreadBasic.SleepHelper;

/**
 * @Author: Du
 * @Date: 2021/6/11 16:29
 *
 * volatile 修饰引用类型 不可见
 *
 */
public class T02_VolatileReference
{
    private static class A
    {
        boolean running = true;
        
        void m()
        {
            System.out.println("m start");
            while (running)//running无法为false
            {
            }
            System.out.println("m end");
        }
    }
    
    private volatile static A a = new A();//修饰的是a，是类的引用，不会导致类中的所有方法都内存可见
    
    public static void main(String[] args)
    {
        new Thread(a::m, "t1").start();
        SleepHelper.sleepSeconds(1);
        a.running = false;
    }
}
