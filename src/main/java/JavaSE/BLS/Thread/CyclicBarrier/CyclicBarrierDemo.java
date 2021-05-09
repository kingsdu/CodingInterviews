package JavaSE.BLS.Thread.CyclicBarrier;

import java.util.concurrent.CyclicBarrier;

/**
 *
 * 有区别的是CyclicBarrier的计数器由自己控制，而CountDownLatch的计数器则由使用者来控制，
 * 在CyclicBarrier中线程调用await方法不仅会将自己阻塞还会将计数器减1，
 * 而在CountDownLatch中线程调用await方法只是将自己阻塞而不会减少计数器的值。
 *
 * 另外，CountDownLatch只能拦截一轮，而CyclicBarrier可以实现循环拦截。
 * 一般来说用CyclicBarrier可以实现CountDownLatch的功能，而反之则不能，
 * 例如上面的赛马程序就只能使用CyclicBarrier来实现。
 *
 * 总之，这两个类的异同点大致如此，至于何时使用CyclicBarrier，何时使用CountDownLatch，还需要读者自己去拿捏。
 *
 */
public class CyclicBarrierDemo
{
    public static void main(String[] args)
    {
        CyclicBarrier barrier = new CyclicBarrier(3,new TotalTask());
        BillTask worker1 = new BillTask("111",barrier);
        BillTask worker2 = new BillTask("222",barrier);
        BillTask worker3 = new BillTask("333",barrier);
        worker1.start();
        worker2.start();
        worker3.start();
        System.out.println("主线程结束");
    }

}
