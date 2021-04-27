package JavaSE.BLS.Thread.Singleton;


/**
 *
 * 普通模式，线程不安全
 *
 */
public class A01_Singleton_Common
{
    
    private static A01_Singleton_Common instance;
    
    private A01_Singleton_Common()
    {
    }
    
    public static A01_Singleton_Common getInstance()
    {
        if (instance == null)
        {
            instance = new A01_Singleton_Common();
        }
        return instance;
    }
}
