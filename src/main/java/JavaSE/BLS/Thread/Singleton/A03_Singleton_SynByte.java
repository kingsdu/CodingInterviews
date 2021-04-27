package JavaSE.BLS.Thread.Singleton;

/**
 *
 * 线程安全，性能高
 *
 */
public class A03_Singleton_SynByte
{
    
    private static A03_Singleton_SynByte instance;
    private static byte[] lock = new byte[1];
    
    private A03_Singleton_SynByte()
    {
    }
    
    public static A03_Singleton_SynByte getInstance()
    {
        if (instance == null)
        {
            synchronized (lock)
            {
                if (instance == null)
                {
                    instance = new A03_Singleton_SynByte();
                }
            }
        }
        return instance;
    }
    
    
}
