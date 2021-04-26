package JavaSE.BLS.Thread.ReentrantReadLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
 *
 * ReentrantReadWriteLock 可以实现更为复杂的业务机制
 *
 * 例如下面实现了一个读写分离的锁机制
 *
 *
 */
public class A02_ReentrantReadLockMain
{
    
    private final Map<String, Object> map = new HashMap<>();
    
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    
    public Object readWrite(String id)
    {
        Object value = null;
        rwl.readLock().lock();
        try
        {
            value = map.get(id);
            
            if (value == null)
            {
                rwl.readLock().unlock();
                try
                {
                    rwl.writeLock().lock();
                    if (value == null)
                    {
                        value = "aaa";
                    }
                } finally
                {
                    rwl.writeLock().unlock();
                }
            }
        } finally
        {
            rwl.readLock().unlock();
        }
        return value;
    }
}
