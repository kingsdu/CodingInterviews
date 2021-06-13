package JavaSE.BLS.Thread.CountDownLatch;

import java.util.concurrent.CountDownLatch;


/**
 *
 * 是一个同步辅助类，在一组线程正在操作之前，它允许一个或多个线程一直等待。
 *
 * countDown(),递减锁存器的计数，如果锁存器到0，则释放所有等待的线程，否则线程一直在等待状态
 *
 * 场景1：5个线程去下载文件，当5个线程都下载完毕后，才能继续去合并文件
 *
 *
 */
public class CountDownLatchDemo
{
    
    //例子中当a b c 都开始后，才会调用 结束部分方法
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
