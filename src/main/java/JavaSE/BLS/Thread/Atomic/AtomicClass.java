package JavaSE.BLS.Thread.Atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * 原子操作，采用非阻塞同步（没有其他线程争用共享数据就操作成功，有冲突则采取补偿措施，比如不断尝试，直到成功为止），不会阻塞线程。
 *
 */
public class AtomicClass
{
    
    public static void main(String[] args)
    {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.getAndSet(10));
        System.out.println(atomicInteger.getAndIncrement());
        System.out.println(atomicInteger.getAndAdd(10));
        System.out.println(atomicInteger.get());
    }

}
