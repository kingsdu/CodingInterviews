package JavaSE.MSB.Thread.A03_Volatile;

import JavaSE.MSB.Thread.A01.SleepHelper;

/**
 * @Author: Du
 * @Date: 2021/6/11 16:17
 *
 *
 *
 *
 *
 */
public class T01_HelloVolatile
{
    private static boolean running = true;//每个线程单独具备一个running
//    private static volatile boolean running = true;//可以用volatile修饰running所有线程都可见
    
    
    public static void main(String[] args)
    {
        new Thread(T01_HelloVolatile::m, "t1").start();//注意这个写法
        SleepHelper.sleepSeconds(1);
        running = false;
    }
    
    private static void m()
    {
        System.out.println("m start");
        while (running)
        {  //println里面触发synchronized，synchronized会触发本地缓存和主内存之间的数据，进行刷新和同步，所以会执行主线程的running = false;
            System.out.println("Hello");
        }
        System.out.println("m end!");
    }
    
}
