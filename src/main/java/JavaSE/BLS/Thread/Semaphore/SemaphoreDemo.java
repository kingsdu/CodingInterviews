package JavaSE.BLS.Thread.Semaphore;

import java.util.concurrent.Semaphore;


/**
 *
 * 计数的信号量，维护了一个许可集合，如果有必要，在许可前会阻塞每一个acquire()，直到release释放许可
 *
 *
 */
public class SemaphoreDemo
{
    
    public static void main(String[] args)
    {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 10; i++)
        {
            final int no = i;
            Runnable thread = new Runnable()
            {
                @Override
                public void run()
                {
                    try
                    {
                        System.out.println("用户" + no + "连接上了");
                        Thread.sleep(300l);
                        //同一时刻只能允许3个人访问资源
                        semaphore.acquire();
                        System.out.println("用户" + no + "开始访问后台");
                        semaphore.release();//释放一个，下一个才能进
                        System.out.println("用户" + no + "访问结束");
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            };
            new Thread(thread).start();
        }
        System.out.println("main thread end!");
    }
    
}
