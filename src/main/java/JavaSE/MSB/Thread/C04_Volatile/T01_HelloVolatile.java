package JavaSE.MSB.Thread.C04_Volatile;

import JavaSE.MSB.Thread.C00_Common.SleepHelper;

/**
 * volatile 关键字，使一个变量在多个线程间可见
 * A B线程都用到一个变量，java默认是A线程中保留一份copy，这样如果B线程修改了该变量，则A线程未必知道
 * 使用volatile关键字，会让所有线程都会读到变量的修改值
 *
 * 在下面的代码中，running是存在于堆内存的t对象中
 * 当线程t1开始运行的时候，会把running值从内存中读到t1线程的工作区，在运行过程中直接使用这个copy，并不会每次都去
 * 读取堆内存，这样，当主线程修改running的值之后，t1线程感知不到，所以不会停止运行
 *
 * 使用volatile，将会强制所有线程都去堆内存中读取running的值
 *
 * 可以阅读这篇文章进行更深入的理解
 * http://www.cnblogs.com/nexiyi/p/java_memory_model_and_thread.html
 *
 * volatile并不能保证多个线程共同修改running变量时所带来的不一致问题，也就是说volatile不能替代synchronized
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
            //System.out.println("Hello");
        }
        System.out.println("m end!");
    }
    
}
