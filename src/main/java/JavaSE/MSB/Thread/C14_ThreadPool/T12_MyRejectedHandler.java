package JavaSE.MSB.Thread.C14_ThreadPool;

import java.util.concurrent.*;
//自定义策略,根据业务逻辑
public class T12_MyRejectedHandler
{
    public static void main(String[] args)
    {
        ExecutorService service = new ThreadPoolExecutor(4, 4,
                0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(6),
                Executors.defaultThreadFactory(),
                new MyHandler());
    }
    
    static class MyHandler implements RejectedExecutionHandler
    {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor)
        {
            //log("r rejected")
            //save r kafka mysql redis
            //try 3 times
            if (executor.getQueue().size() < 10000)
            {
                //try put again();
            }
        }
    }
}
