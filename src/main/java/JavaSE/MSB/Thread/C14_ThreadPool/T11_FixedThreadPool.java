/**
 * 线程池的概念
 * nasa
 */
package JavaSE.MSB.Thread.C14_ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//并行和并发
public class T11_FixedThreadPool
{
    public static void main(String[] args) throws InterruptedException, ExecutionException
    {
        long start = System.currentTimeMillis();
        getPrime(1, 200000);//计算质数,单线程运行
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        
        final int cpuCoreNum = 4;
        
        ExecutorService service = Executors.newFixedThreadPool(cpuCoreNum);//并行处理
        //分治
        MyTask t1 = new MyTask(1, 80000); //1-5 5-10 10-15 15-20
        MyTask t2 = new MyTask(80001, 130000);
        MyTask t3 = new MyTask(130001, 170000);
        MyTask t4 = new MyTask(170001, 200000);
        //异步执行
        Future<List<Integer>> f1 = service.submit(t1);
        Future<List<Integer>> f2 = service.submit(t2);
        Future<List<Integer>> f3 = service.submit(t3);
        Future<List<Integer>> f4 = service.submit(t4);
        //获取结果
        start = System.currentTimeMillis();
        f1.get();
        f2.get();
        f3.get();
        f4.get();
        end = System.currentTimeMillis();
        System.out.println(end - start);
    }
    
    static class MyTask implements Callable<List<Integer>>
    {
        int startPos, endPos;
        
        MyTask(int s, int e)
        {
            this.startPos = s;
            this.endPos = e;
        }
        
        @Override
        public List<Integer> call() throws Exception
        {
            List<Integer> r = getPrime(startPos, endPos);
            return r;
        }
        
    }
    
    static boolean isPrime(int num)//判断一个数是否质数
    {
        for (int i = 2; i <= num / 2; i++)
        {
            if (num % i == 0) return false;
        }
        return true;
    }
    
    static List<Integer> getPrime(int start, int end)
    {
        List<Integer> results = new ArrayList<>();
        for (int i = start; i <= end; i++)
        {
            if (isPrime(i)) results.add(i);
        }
        
        return results;
    }
}
