package JavaSE.BLS.Thread.FutureTask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *
 * 线程1执行完毕后才执行的线程2
 *
 */
public class FatureTaskDemo
{
    public static void main(String[] args) throws ExecutionException, InterruptedException
    {
        SonTask s1 = new SonTask("Thread son1");
        FutureTask<String> f1 = new FutureTask<>(s1);
        new Thread(f1).start();
        System.out.println(f1.get());
    
        FutureTask<Integer> f2 = new FutureTask<>(new MyRun(),1212);
        new Thread(f2).start();
        System.out.println("result "+f2.get());
    }
}
