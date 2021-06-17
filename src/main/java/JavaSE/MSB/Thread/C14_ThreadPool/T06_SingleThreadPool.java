package JavaSE.MSB.Thread.C14_ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//一个线程的线程池,保证任务是顺序执行的
//为什么要有单线程的线程池?
//1 线程池有任务队列
//2 线程池有完整的生命周期
public class T06_SingleThreadPool
{
    public static void main(String[] args)
    {
        //Executors 线程池的工厂
        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++)
        {
            final int j = i;
            service.execute(() ->
            {
                System.out.println(j + " " + Thread.currentThread().getName());
            });
        }
        
    }
}
