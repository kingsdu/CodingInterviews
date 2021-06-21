package DesignPatern.Singleton;

/**
 * lazy loading
 * 也称懒汉式
 * 虽然达到了按需初始化的目的，但却带来线程不安全的问题
 * 可以通过synchronized解决，但也带来效率下降
 */
public class A04_懒汉式线程安全效率低
{
    private static A04_懒汉式线程安全效率低 INSTANCE;
    
    private A04_懒汉式线程安全效率低()
    {
    }
    
    public static synchronized A04_懒汉式线程安全效率低 getInstance()
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
            INSTANCE = new A04_懒汉式线程安全效率低();
        }
        return INSTANCE;
    }
    
    public void m()
    {
        System.out.println("m");
    }
    
    public static void main(String[] args)
    {
        for (int i = 0; i < 100; i++)
        {
            new Thread(() -> System.out.println(A04_懒汉式线程安全效率低.getInstance().hashCode())
            ).start();
        }
    }
}
