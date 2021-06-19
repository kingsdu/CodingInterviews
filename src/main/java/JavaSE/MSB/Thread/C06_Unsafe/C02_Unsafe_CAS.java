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
 * 实现CAS
 */
public class C02_Unsafe_CAS
{
    static final Unsafe UNSAFE;
    static final long A_OFFSET;
    
    static
    {
        try
        {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            UNSAFE = (Unsafe) theUnsafe.get(null);
            Class<C02_Unsafe_CAS> c06_demoClass = C02_Unsafe_CAS.class;
            A_OFFSET = UNSAFE.staticFieldOffset(c06_demoClass.getDeclaredField("a"));
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
    
    static volatile int a = 0;
    
    public static void inc()
    {
        for (; ; )
        {
            int t = a;
            if (UNSAFE.compareAndSwapInt(C02_Unsafe_CAS.class, A_OFFSET, t, ++t))
            {
                break;
            }
            Thread.yield();
        }
    }
    
    public static void main(String[] args) throws InterruptedException
    {
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++)
        {
            executorService.execute(() -> inc());
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println(a);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
