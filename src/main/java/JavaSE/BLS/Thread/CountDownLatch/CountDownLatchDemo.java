package JavaSE.BLS.Thread.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo
{
    public static void main(String[] args) throws InterruptedException
    {
        CountDownLatch latch = new CountDownLatch(3);
        Worker worker1 = new Worker("a",latch);
        Worker worker2 = new Worker("b",latch);
        Worker worker3 = new Worker("c",latch);
        
        worker1.start();
        worker2.start();
        worker3.start();
        
        latch.await();
        //主线程会等待3个线程执行完毕，再向下执行
        System.out.println("main thread end");
    }
}
