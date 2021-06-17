package JavaSE.MSB.Thread.A01;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @Author: Du
 * @Date: 2021/6/8 19:33
 *
 *
 * 单线程、多线程、超多线程并行性能比较
 *
 */
public class T01_MultiVSSingle_ContestSwitch
{
    
    private static double[] nums = new double[1_0000_0000];
    private static Random r = new Random();
    static DecimalFormat df = new DecimalFormat("0.00");
    
    static
    {
        for (int i = 0; i < nums.length; i++)
        {
            nums[i] += r.nextDouble();
        }
    }
    
    
    public static void main(String[] args) throws InterruptedException
    {
        m1();
        m2();
        m3();
    }
    
    /**
     *
     *
     * 单线程操作
     *
     */
    public static void m1()
    {
        long l = System.currentTimeMillis();
        
        double res = 0.0;
        for (int i = 0; i < nums.length; i++)
        {
            res += nums[i];
        }
        
        long l1 = System.currentTimeMillis();
        
        System.out.println((l1 - l) + "----------" + df.format(res));
    }
    
    
    static double res1 = 0.0, res2 = 0.0, res = 0.0;
    
    /**
     *
     * 两个线程并行
     *
     * @throws InterruptedException
     */
    public static void m2() throws InterruptedException
    {
        Thread t1 = new Thread(() ->
        {
            for (int i = 0; i < nums.length / 2; i++)
            {
                res1 += nums[i];
            }
        });
        
        Thread t2 = new Thread(() ->
        {
            for (int i = nums.length / 2; i < nums.length; i++)
            {
                res2 += nums[i];
            }
        });
        
        long l = System.currentTimeMillis();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        
        long s = System.currentTimeMillis();
        
        res = res1 + res2;
        System.out.println((s - l) + "----------" + df.format(res));
    }
    
    
    /**
     *
     * 10000个线程并行
     *
     * @throws InterruptedException
     */
    public static void m3() throws InterruptedException
    {
        final int theadCount = 16;
        Thread[] threads = new Thread[theadCount];
        double[] results = new double[theadCount];
        final int segmentCount = nums.length / theadCount;
        CountDownLatch latch = new CountDownLatch(theadCount);
        
        for (int i = 0; i < theadCount; i++)
        {
            int m = i;
            
            threads[i] = new Thread(() ->
            {
                for (int j = m * segmentCount; j < (m + 1) * segmentCount && j < nums.length; j++)
                {
                    results[m] += nums[j];
                }
            });
            
            latch.countDown();
        }
        
        double result3 = 0.0;
        
        long l = System.currentTimeMillis();
        for (Thread t : threads)
        {
            t.start();
        }
        
        latch.await();
        
        for (int i = 0; i < results.length; i++)
        {
            result3 += results[i];
        }
        
        long s = System.currentTimeMillis();
        
        System.out.println((s - l) + "----------" + df.format(res));
    }
}
