package JavaSE.BLS.Thread.Singleton;

import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
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
        Hashtable h = new Hashtable();
        ConcurrentHashMap h1 = new ConcurrentHashMap();
        CopyOnWriteArrayList h2 = new CopyOnWriteArrayList();
        StringBuilder sb = new StringBuilder();
        StringBuffer sf = new StringBuffer();
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
