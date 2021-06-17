package JavaSE.MSB.Thread.C07_Reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;


/*
可以暂停某个线程，然后可以在让其继续
 */
public class T13_TestLockSupport
{
    public static void main(String[] args)
    {
        Thread t = new Thread(() ->
        {
            for (int i = 0; i < 10; i++)
            {
                System.out.println(i);
                if (i == 5)
                {
                    LockSupport.park();//当线程运行到5时，停住线程
                }
                try
                {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        LockSupport.unpark(t);//unpark重启等待下线程
    }
}
