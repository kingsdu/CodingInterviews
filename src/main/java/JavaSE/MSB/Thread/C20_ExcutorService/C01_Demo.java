package JavaSE.MSB.Thread.C20_ExcutorService;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Du
 * @Date: 2021/6/18 15:24
 */
public class C01_Demo
{
    
    public static void main(String[] args) throws ExecutionException, InterruptedException
    {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        ArrayList<Callable<Integer>> callables = Lists.newArrayList(new Callable<Integer>()
        {
            @Override
            public Integer call() throws Exception
            {
                System.out.println("1");
                return 1;
            }
        }, new Callable<Integer>()
        {
            @Override
            public Integer call() throws Exception
            {
                try
                {
                    Thread.sleep(1000);
                    System.out.println("2");
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                return 2;
            }
        });
        Integer integer = threadPool.invokeAny(callables);
        System.out.println(integer);
    }
}
