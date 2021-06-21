package DesignPatern.Singleton;

/**
 * 跟01是一个意思
 */
public class A02_恶汉式的另一种写法
{
    private static final A02_恶汉式的另一种写法 INSTANCE;
    
    static
    {
        INSTANCE = new A02_恶汉式的另一种写法();
    }
    
    private A02_恶汉式的另一种写法()
    {
    }
    
    public static A02_恶汉式的另一种写法 getInstance()
    {
        return INSTANCE;
    }
    
    public void m()
    {
        System.out.println("m");
    }
    
    public static void main(String[] args)
    {
        A02_恶汉式的另一种写法 m1 = A02_恶汉式的另一种写法.getInstance();
        A02_恶汉式的另一种写法 m2 = A02_恶汉式的另一种写法.getInstance();
        System.out.println(m1 == m2);
    }
}
