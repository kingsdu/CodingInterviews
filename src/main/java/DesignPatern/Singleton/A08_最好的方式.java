package DesignPatern.Singleton;

/**
 * 不仅可以解决线程同步，还可以防止反序列化。
 *
 * 枚举类不会被反序列化，因为枚举类没有构造方法
 */
public enum A08_最好的方式
{
    
    INSTANCE;
    
    public void m()
    {
    }
    
    public static void main(String[] args)
    {
        for (int i = 0; i < 100; i++)
        {
            new Thread(() ->
            {
                System.out.println(A08_最好的方式.INSTANCE.hashCode());
            }).start();
        }
    }
    
}
