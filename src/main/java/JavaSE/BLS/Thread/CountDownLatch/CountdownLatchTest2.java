package JavaSE.BLS.Thread.CountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * 百米赛跑，4名运动员选手到达场地等待裁判口令，裁判一声口令，选手听到后同时起跑，当所有选手到达终点，裁判进行汇总排名
 *
 */
public class CountdownLatchTest2
{
    public static void main(String[] args)
    {
        ExecutorService service = Executors.newCachedThreadPool();
        final CountDownLatch cdOrder = new CountDownLatch(1);
        final CountDownLatch cdAnswer = new CountDownLatch(4);
        for (int i = 0; i < 4; i++)
        {
            Runnable runnable = new Runnable()
            {
                @Override
                public void run()
                {
                    try
                    {
                        System.out.println("选手" + Thread.currentThread().getName() + "正在等待裁判发布口令");
                        cdOrder.await();
                        System.out.println("选手" + Thread.currentThread().getName() + "已接受裁判口令");
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println("选手" + Thread.currentThread().getName() + "到达终点");
                        cdAnswer.countDown();
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            };
            service.execute(runnable);
        }
        try
        {
            Thread.sleep((long) (Math.random() * 10000));
            System.out.println("裁判" + Thread.currentThread().getName() + "即将发布口令");
            cdOrder.countDown();
            System.out.println("裁判" + Thread.currentThread().getName() + "已发送口令，正在等待所有选手到达终点");
            cdAnswer.await();
            System.out.println("所有选手都到达终点");
            System.out.println("裁判" + Thread.currentThread().getName() + "汇总成绩排名");
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        service.shutdown();
    }
}
