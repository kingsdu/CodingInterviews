package DesignPatern.Singleton;

/**
 * lazy loading
 * 也称懒汉式
 * 虽然达到了按需初始化的目的，但却带来线程不安全的问题
 */
public class A03_懒汉式线程不安全
{
    private static A03_懒汉式线程不安全 INSTANCE;
    
    private A03_懒汉式线程不安全()
    {
    }
    
    public static A03_懒汉式线程不安全 getInstance()
    {
        if (INSTANCE == null)
        {
            try
            {
                Thread.sleep(1);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            INSTANCE = new A03_懒汉式线程不安全();
        }
        return INSTANCE;
    }
    public void m()
    {
        System.out.println("m");
    }
    
    public static void main(String[] args)
    {
        //多线程会有问题
        for (int i = 0; i < 100; i++)
        {
            new Thread(() ->
                    System.out.println(A03_懒汉式线程不安全.getInstance().hashCode())
            ).start();
        }
    }
}
