package JavaSE.BLS.Thread.CopyOnWrite;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 *
 * 基于 copy on write机制实现一个 线程安全的 Hashmap
 *
 * copy on write 应用于读多，写少的场景
 *
 * @param <K>
 * @param <V>
 */
public class CopyOnWriteMap<K,V> implements Map<K,V>,Cloneable
{
    private volatile Map<K,V> internalMap;
    
    @Override
    public int size()
    {
        return internalMap.size();
    }
    
    @Override
    public boolean isEmpty()
    {
        return internalMap.isEmpty();
    }
    
    @Override
    public boolean containsKey(Object key)
    {
        return false;
    }
    
    @Override
    public boolean containsValue(Object value)
    {
        return false;
    }
    
    @Override
    public V get(Object key)
    {
        return internalMap.get(key);
    }
    
    @Override
    public V put(K key, V value)
    {
        synchronized (this){
            Map<K,V> newMap = new HashMap<>(internalMap);
            V val = newMap.put(key, value);//copy on write
            internalMap = newMap;
            return val;
        }
    }
    
    @Override
    public V remove(Object key)
    {
        return null;
    }
    
    @Override
    public void putAll(Map<? extends K, ? extends V> m)
    {
    
    }
    
    @Override
    public void clear()
    {
    
    }
    
    @Override
    public Set<K> keySet()
    {
        return null;
    }
    
    @Override
    public Collection<V> values()
    {
        return null;
    }
    
    @Override
    public Set<Entry<K, V>> entrySet()
    {
        return null;
    }
}
