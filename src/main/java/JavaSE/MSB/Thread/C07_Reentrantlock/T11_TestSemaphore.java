package JavaSE.MSB.Thread.C07_Reentrantlock;

import java.util.concurrent.Semaphore;

public class T11_TestSemaphore
{
    public static void main(String[] args)
    {
        Semaphore s = new Semaphore(2);
        //Semaphore s = new Semaphore(2, true);//是否公平
        //允许一个线程同时执行
        //Semaphore s = new Semaphore(1);
        new Thread(() ->
        {
            try
            {
                s.acquire();//在Semaphore中获取许可信号，获取后信号量--，没有许可信号就会等待
                System.out.println("T1 running...");
                Thread.sleep(200);
                System.out.println("T1 running...");
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            } finally
            {
                s.release();//信号量++
            }
        }).start();
        
        new Thread(() ->
        {
            try
            {
                s.acquire();//信号量--
                System.out.println("T2 running...");
                Thread.sleep(200);
                System.out.println("T2 running...");
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }finally
            {
                s.release();//信号量++
            }
        }).start();
    }
}
