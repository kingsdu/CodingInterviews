package JavaSE.BLS.Thread.ForkJoinTask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class A01_ForkJoinTaskDemo
{
    public static void main(String[] args) throws ExecutionException, InterruptedException
    {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        A01_CountTask task = new A01_CountTask(1,5);
        ForkJoinTask<Integer> result = forkJoinPool.submit(task);
        System.out.println("1-5相加最终结果 = "+result.get());
        
        A01_CountTask task2 = new A01_CountTask(1,100);
        ForkJoinTask<Integer> result2 = forkJoinPool.submit(task2);
        System.out.println("1-100相加最终结果 = "+result2.get());
    }
}
