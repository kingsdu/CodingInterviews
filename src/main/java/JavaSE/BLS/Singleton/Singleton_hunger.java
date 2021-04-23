package JavaSE.BLS.Singleton;

/**
 *
 * 饿汉式
 *
 * 一来就创建类
 *
 */
public class Singleton_hunger
{
    private static final Singleton_hunger singleton_hunger = new Singleton_hunger();
    
    private Singleton_hunger()
    {
    }
    
    public static Singleton_hunger getInstance(){
        return singleton_hunger;
    }
    
}
