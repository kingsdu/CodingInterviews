package JavaSE.MSB.Thread.C02_Synchronized;

/**
 * @Author: Du
 * @Date: 2021/6/13 19:48
 *
 * synchronized this，静态代码块对象加锁
 */
public class C02_Synchronized2
{
    private int count = 10;
    
    public void m()
    {
        synchronized (this)
        { //任何线程要执行下面的代码，必须先拿到this的锁
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }
    
    public static void main(String[] args)
    {
        C02_Synchronized2 c02 = new C02_Synchronized2();
        for (int i = 0; i < 10; i++)
        {
            new Thread(()->{
                c02.m();
            }).start();
        }
    }
}
