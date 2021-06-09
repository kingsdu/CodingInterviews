package JavaSE.BLS.Thread.CreateThread;

import java.util.concurrent.*;

/**
 * @Author: Du
 * @Date: 2021/6/9 17:20
 *
 * 启动线程的4种方法
 *
 */
public class T01_CreateThread_Method
{
    static class MyThread extends Thread{
        @Override
        public void run()
        {
            System.out.println("Hello MyThread");
        }
    }
    
    static class MyRun implements Runnable{
        @Override
        public void run()
        {
            System.out.println("Hello MyRun");
        }
    }
    
    
    static class MyCall implements Callable<String>{
    
        @Override
        public String call() throws Exception
        {
            System.out.println("Hello MyCall");
            return "Success";
        }
    }
    
    
    public static void main(String[] args) throws ExecutionException, InterruptedException
    {
        new MyThread().start();
        new Thread(new MyRun()).start();
        new Thread(()->{
            System.out.println("Hello Lambda");
        }).start();
    
        Thread t = new Thread(new FutureTask<String>(new MyCall()));
        t.start();
    
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(()->{
            System.out.println("Executors Lambda");
        });
    
        Future<String> f = service.submit(new MyCall());
        String s = f.get();//get是阻塞方法，获取到值后才继续向后运行
        System.out.println(s);
        service.shutdown();
    
    
        FutureTask<String> task = new FutureTask<>(new MyCall());
        Thread t0 = new Thread(task);
        t0.start();
        System.out.println(task.get());
    }
    
    
}
