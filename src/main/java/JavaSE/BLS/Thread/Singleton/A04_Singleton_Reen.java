package JavaSE.BLS.Thread.Singleton;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * 线程安全，性能高
 *
 */
public class A04_Singleton_Reen
{
    private static A04_Singleton_Reen instance;
    private static ReentrantLock lock = new ReentrantLock();
    
    private A04_Singleton_Reen()
    {
    }
    
    public static A04_Singleton_Reen getInstance()
    {
        if (instance == null)
        {
            lock.lock();
            if (instance == null)
            {
                instance = new A04_Singleton_Reen();
            }
            lock.unlock();
        }
        return instance;
    }
}
