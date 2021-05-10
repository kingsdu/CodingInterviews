package JavaSE.BLS.Thread.FutureTask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *
 * 每次执行后都可以返回执行结果
 *
 */
public class FatureTaskDemo
{
    public static void main(String[] args) throws ExecutionException, InterruptedException
    {
        SonTask s1 = new SonTask("Thread son1");
        FutureTask<String> f1 = new FutureTask<>(s1);
        new Thread(f1).start();
        System.out.println(f1.get());//阻塞式方法
    
        FutureTask<Integer> f2 = new FutureTask<>(new MyRun(),1212);
        new Thread(f2).start();
        System.out.println("result "+f2.get());
    }
}
