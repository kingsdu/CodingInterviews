package JavaSE.MSB.Thread.C14_ThreadPool;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

//对某个任务进行分治操作,先一级一级的分给多个子线程做,完成后再从子线程一级一级的汇总到根节点
public class T14_ForkJoinPool
{
    static int[] nums = new int[1000000];
    static final int MAX_NUM = 50000;
    static Random r = new Random();
    
    //单线程执行
    static
    {
        long start = System.currentTimeMillis();
        for (int i = 0; i < nums.length; i++)
        {
            nums[i] = r.nextInt(100);
        }
        System.out.println("单线程结果：" + Arrays.stream(nums).sum()); //stream api
        long end = System.currentTimeMillis();
        System.out.println("1time " + (end - start));
    }
    
    //多线程执行（无返回值方法）
    static class AddTask extends RecursiveAction
    {//RecursiveAction 递归任务
        int start, end;
        
        AddTask(int s, int e)
        {
            start = s;
            end = e;
        }
        
        @Override
        protected void compute()
        {
            if (end - start <= MAX_NUM)
            {//每个任务最少执行50000个任务
                long sum = 0L;
                for (int i = start; i < end; i++) sum += nums[i];
                System.out.println("from:" + start + " to:" + end + " = " + sum);
            } else
            {
                int middle = start + (end - start) / 2;
                AddTask subTask1 = new AddTask(start, middle);
                AddTask subTask2 = new AddTask(middle, end);
                subTask1.fork();
                subTask2.fork();
            }
        }
        
    }
    
    //多线程执行（有返回值方法）
    static class AddTaskRet extends RecursiveTask<Long>
    {
        private static final long serialVersionUID = 1L;
        int start, end;
        
        AddTaskRet(int s, int e)
        {
            start = s;
            end = e;
        }
        
        @Override
        protected Long compute()
        {
            if (end - start <= MAX_NUM)
            {
                long sum = 0L;
                for (int i = start; i < end; i++) sum += nums[i];
                return sum;
            }
            
            int middle = start + ((end - start) >> 1);
            
            AddTaskRet subTask1 = new AddTaskRet(start, middle);
            AddTaskRet subTask2 = new AddTaskRet(middle, end);
            subTask1.fork();
            subTask2.fork();
            
            return subTask1.join() + subTask2.join();
        }
        
    }
    
    public static void main(String[] args) throws IOException
    {
        long start = System.currentTimeMillis();
        ForkJoinPool fjp = new ForkJoinPool();
        AddTaskRet task = new AddTaskRet(0, nums.length);
        fjp.execute(task);
        long result = task.join();
        System.out.println("ForkJoinPool 结果：" + result);
        long end = System.currentTimeMillis();
        System.out.println("2time " + (end - start));
        //阻塞线程
        //System.in.read();
        
    }
}
