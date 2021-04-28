package JavaSE.BLS.Thread.ForkJoinTask;

import java.util.concurrent.RecursiveTask;

public class A01_CountTask extends RecursiveTask<Integer>
{
    private static int splitSize = 2;
    private int start, end;
    
    public A01_CountTask(int start, int end)
    {
        this.start = start;
        this.end = end;
    }
    
    @Override
    protected Integer compute()
    {
        int sum = 0;
        boolean canCompute = (end - start) <= splitSize;
        if (canCompute)
        {
            for (int i = start; i <= end; i++)
            {
                sum += i;
            }
        } else
        {
            int middle = (start + end) / 2;
            A01_CountTask firstTask = new A01_CountTask(start, middle);
            A01_CountTask secondTask = new A01_CountTask(middle + 1, end);
            firstTask.fork();
            secondTask.fork();
            
            int firstResult = firstTask.join();
            int secondResult = secondTask.join();
            
            sum = firstResult + secondResult;
        }
        return sum;
    }
}
