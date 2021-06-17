package JavaSE.MSB.Thread.C02_Synchronized;

/**
 * @Author: Du
 * @Date: 2021/6/13 20:25
 *
 *
 * 在执行m1的过程中可以继续执行m2
 */
public class C06_Synchronized6
{
    public synchronized void m1()
    {
        System.out.println(Thread.currentThread().getName() + " m1 start...");
        try
        {
            Thread.sleep(10000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m1 end");
    }
    
    public void m2()
    {
        try
        {
            Thread.sleep(5000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m2 ");
    }
    
    public static void main(String[] args)
    {
        C06_Synchronized6 t = new C06_Synchronized6();
        
        new Thread(t::m1, "t1").start();
        new Thread(t::m2, "t2").start();
    }
    
}
