package JavaSE.MSB.Thread.C02_Synchronized;

/**
 * @Author: Du
 * @Date: 2021/6/13 19:51
 */
public class C04_Synchronized4
{
    private int count = 10;
    
    public synchronized void m()
    { //等同于在方法的代码执行时要synchronized(this)
        count--;
        System.out.println(Thread.currentThread().getName() + " m count = " + count);
    }
    
    public void n()
    { //访问这个方法的时候不需要上锁
        count++;
        System.out.println(Thread.currentThread().getName() + " n count = " + count);
    }
    
    //可以在调用m的适合同时调用n
    public static void main(String[] args)
    {
        C04_Synchronized4 c04 = new C04_Synchronized4();
        for (int i = 0; i < 10; i++)
        {
            new Thread(()->{
                c04.m();
                c04.n();
            }).start();
        }
    }
}
