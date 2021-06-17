package JavaSE.MSB.Thread.C02_Synchronized;

/**
 * @Author: Du
 * @Date: 2021/6/13 20:11
 */
public class C05_Synchronized5
{
    private static int count = 10;
    
    public synchronized static void m()
    { //
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }
    
    public static void mm()
    {   //static 没有this对象，这里等同于synchronized(C05_Synchronized5.class)
        synchronized (C05_Synchronized5.class)
        { //考虑一下这里写synchronized(this)是否可以？
            count--;
        }
    }
}
