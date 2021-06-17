package JavaSE.MSB.Thread.C14_ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//流式处理
public class T15_ParallelStreamAPI
{
    public static void main(String[] args)
    {
        List<Integer> nums = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 10000; i++) nums.add(1000000 + r.nextInt(1000000));
        
        //System.out.println(nums);
        
        long start = System.currentTimeMillis();
        nums.forEach(v -> isPrime(v));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        
        //parallel stream api
        
        start = System.currentTimeMillis();
        nums.parallelStream().forEach(T15_ParallelStreamAPI::isPrime);//并行处理,线程不需要同步时使用并行处理
        end = System.currentTimeMillis();
        
        System.out.println(end - start);
    }
    
    static boolean isPrime(int num)
    {
        for (int i = 2; i <= num / 2; i++)
        {
            if (num % i == 0) return false;
        }
        return true;
    }
}
