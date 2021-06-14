package JavaSE.BLS.Thread.A00MSB.C02_Synchronized;

/**
 * @Author: Du
 * @Date: 2021/6/13 19:49
 */
public class C03_Synchronized3
{
    private int count = 10;
    
    public synchronized void m()
    { //等同于在方法的代码执行时要synchronized(this)
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }
    
    public static void main(String[] args)
    {
        C03_Synchronized3 c03 = new C03_Synchronized3();
        for (int i = 0; i < 10; i++)
        {
            new Thread(()->{
                c03.m();
            }).start();
        }
    }
}
