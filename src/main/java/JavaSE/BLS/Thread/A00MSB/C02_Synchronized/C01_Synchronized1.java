package JavaSE.BLS.Thread.A00MSB.C02_Synchronized;

/**
 * @Author: Du
 * @Date: 2021/6/13 19:47
 * <p>
 * synchronized关键字对某个对象加锁
 */
public class C01_Synchronized1
{
    private int count = 10;
    private Object o = new Object();//不要用String Integer Long 等基本对象，可能会发生死锁
    
    public void m()
    {
        synchronized (o)
        { //任何线程要执行下面的代码，必须先拿到o的锁
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }
    
    public static void main(String[] args)
    {
        C01_Synchronized1 c01 = new C01_Synchronized1();
        for (int i = 0; i < 10; i++)
        {
            new Thread(() ->
            {
                c01.m();
            }).start();
        }
    }
}
