package JavaSE.MSB.Thread.C06_Unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Du
 * @Date: 2021/6/18 21:07
 * <p>
 * 利用 UnSafe 实现CAS
 */
public class C03_Unsafe_CAS
{
    static final Unsafe UNSAFE;
    static final long A_OFFSET;
    static final long COUNTER_OFFSET;
    
    static
    {
        try
        {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            UNSAFE = (Unsafe) theUnsafe.get(null);
            Class<C03_Unsafe_CAS> c06_demoClass = C03_Unsafe_CAS.class;
            A_OFFSET = UNSAFE.staticFieldOffset(c06_demoClass.getDeclaredField("a"));
            COUNTER_OFFSET = UNSAFE.staticFieldOffset(c06_demoClass.getDeclaredField("counter"));
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
    
    static volatile int a = 0;
    static volatile int counter = 1;
    
    
    public static void lock()
    {
        for (; ; )
        {   //读取传入对象o在内存中偏移量为offset位置的值与期望值expected作比较,
            // 相等就把x值赋值给offset位置的值。方法返回true,不相等，就取消赋值，方法返回false。
            if (UNSAFE.compareAndSwapInt(C03_Unsafe_CAS.class, COUNTER_OFFSET, 1, 0))
            {
                break;
            }
            Thread.yield();//让出CPU，优化自旋锁
        }
    }
    
    public static void unlock()
    {
        counter = 1;
    }
    
    
    public static void inc() throws InterruptedException
    {
        lock();
        a++;
        //Thread.sleep(100);
        unlock();
    }
    
    public static void main(String[] args) throws InterruptedException
    {
        ExecutorService executorService = Executors.newCachedThreadPool();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++)
        {
            executorService.execute(() ->
            {
                try
                {
                    inc();
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println(a);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
