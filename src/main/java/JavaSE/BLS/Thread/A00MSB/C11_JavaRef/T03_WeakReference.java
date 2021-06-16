package JavaSE.BLS.Thread.A00MSB.C11_JavaRef;

import java.lang.ref.WeakReference;

/**
 * @Author: Du
 * @Date: 2021/6/15 21:00
 *
 * 弱引用：只要遭遇到GC就会回收
 * ThreadLocal的坑
 */
public class T03_WeakReference
{
    public static void main(String[] args)
    {
        WeakReference<M> m = new WeakReference<>(new M());
        
        System.out.println(m.get());
        System.gc();//finalize
        System.out.println(m.get());//null 遇到GC就会回收
        //如果有强引用指向一个弱引用，如果强引用被消除，弱引用就不用再管，会自动会被GC回收。一般用在集合里
        //WeakHashMap源码
        
        //重要！！！
        //t1是强引用指向ThreadLocal，ThreadLocal中的ThreadLocalMap的key存储的是ThreadLocal，这个key是一个弱引用
        //这样设计 当t1被消除后，ThreadLocalMap中的key指向ThreadLocal会自动被回收
        ThreadLocal<M> tl = new ThreadLocal<>();//一个t1对应一个ThreadLocal的key，多个就对应多个ThreadLocal的key
        tl.set(new M());
        //因为ThreadLocalMap是一直都存在的，且ThreadLocalMap中只有key是弱引用，但是value是强引用，所以value的值还存在，且因为key为null了，value不会被回收
        //所以使用ThreadLocal，里面对象不用了，一定要将里面对象移除，否则还是会有内存泄漏
        tl.remove();//remove掉 ThreadLocalMap中对应的Entry<key,map>删除
    }
}
