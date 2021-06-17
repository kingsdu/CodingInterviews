/**
 * 认识Callable，对Runnable进行了扩展
 * 对Callable的调用，可以有返回值
 */
package JavaSE.MSB.Thread.C14_ThreadPool;

import java.util.concurrent.*;

//类似于Runnable 但是Callable有返回值
public class T03_Callable
{
    public static void main(String[] args) throws ExecutionException, InterruptedException
    {
        Callable<String> c = new Callable()
        {
            @Override
            public String call() throws Exception
            {
                return "Hello Callable";
            }
        };
        ExecutorService service = Executors.newCachedThreadPool();
        Future<String> future = service.submit(c); //异步,提交后主线程做自己的事情,因为是异步的,所以需要使用future.get()去获取返回值结果
        System.out.println(future.get()+"  ----");//阻塞，如果future.get()有结果就返回
        service.shutdown();
    }
    
}
