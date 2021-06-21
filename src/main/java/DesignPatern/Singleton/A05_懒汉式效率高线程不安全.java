package DesignPatern.Singleton;

/**
 * lazy loading
 * 也称懒汉式
 * 虽然达到了按需初始化的目的，但却带来线程不安全的问题
 * 可以通过synchronized解决，但也带来效率下降
 */
public class A05_懒汉式效率高线程不安全
{
    private static A05_懒汉式效率高线程不安全 INSTANCE;
    
    private A05_懒汉式效率高线程不安全()
    {
    }
    
    public static A05_懒汉式效率高线程不安全 getInstance()
    {
        if (INSTANCE == null)
        {
            //妄图通过减小同步代码块的方式提高效率，然后线程也不安全
            synchronized (A05_懒汉式效率高线程不安全.class)
            {
                try
                {
                    Thread.sleep(1);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                INSTANCE = new A05_懒汉式效率高线程不安全();
            }
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
            new Thread(() ->
            {
                System.out.println(A05_懒汉式效率高线程不安全.getInstance().hashCode());
            }).start();
        }
    }
}
