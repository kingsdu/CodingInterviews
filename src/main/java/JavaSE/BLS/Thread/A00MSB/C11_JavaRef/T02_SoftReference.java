/**
 * 软引用
 * 软引用是用来描述一些还有用但并非必须的对象。
 * 对于软引用关联着的对象，在系统将要发生内存溢出异常之前，将会把这些对象列进回收范围进行第二次回收。
 * 如果这次回收还没有足够的内存，才会抛出内存溢出异常。
 * -Xmx20M
 */
package JavaSE.BLS.Thread.A00MSB.C11_JavaRef;

import java.lang.ref.SoftReference;

//软引用非常适合缓存使用，这种内存不是必须的，需要新的空间就可以把软引用的数据清掉，否则就留着
//当有对象被软引用指向，系统内存不够用就会回收，不够用就不会回收
//设置运行参数 -Xms20M -Xmx30M
public class T02_SoftReference
{
    public static void main(String[] args)
    {
        SoftReference<byte[]> m = new SoftReference<>(new byte[1024 * 1024 * 10]);//10M
        //m = null;
        System.out.println(m.get());//获取字节数组，输出hashcode值
        System.gc();//设置参数后内存不够，会被GC清除
        try
        {
            Thread.sleep(500);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println(m.get());//如果被回收 输出应该是null
        
        //再分配一个数组，heap将装不下，这时候系统会垃圾回收，先回收一次，如果不够，会把软引用干掉
        byte[] b = new byte[1024 * 1024 * 15];//15M
        System.out.println(m.get());
    }
}


