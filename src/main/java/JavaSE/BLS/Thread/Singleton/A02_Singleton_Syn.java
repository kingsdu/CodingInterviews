package JavaSE.BLS.Thread.Singleton;

/**
 * 线程安全，但并发性不高
 */
public class A02_Singleton_Syn
{
    
    private static A02_Singleton_Syn instance;
    
    private A02_Singleton_Syn()
    {
    }
    
    public static synchronized A02_Singleton_Syn getInstance()
    {
        if (instance == null)
        {
            instance = new A02_Singleton_Syn();
        }
        return instance;
    }
}
