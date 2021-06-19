package JavaSE.MSB.Thread.C07_Reentrantlock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

//循环栅栏,可以循环使用
public class T07_CyclicBarrier
{
    public static void main(String[] args)
    {
        CyclicBarrier barrier = new CyclicBarrier(20, () -> System.out.println("到20满人，等一下一批"));
        for (int i = 0; i < 100; i++)
        {
            new Thread(() ->
            {
                try
                {
                    barrier.await();//到20个线程后，就继续向下执行，所以输出5个满人
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                } catch (BrokenBarrierException e)
                {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
