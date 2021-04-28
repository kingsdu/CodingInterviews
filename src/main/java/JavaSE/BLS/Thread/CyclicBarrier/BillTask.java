package JavaSE.BLS.Thread.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class BillTask extends Thread
{
    private String billName;
    private CyclicBarrier barrier;
    
    public BillTask(String workerName,CyclicBarrier barrier){
        this.billName = workerName;
        this.barrier = barrier;
    }
    
    @Override
    public void run(){
        try
        {
            System.out.println("区："+billName+" 运算开始");
            Thread.sleep(1000l);
            System.out.println("区："+billName+" 运算完毕，等待中。。。");
            barrier.await();
            System.out.println("全部运算结束 "+billName+" 开始后面的工作");
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        } catch (BrokenBarrierException e)
        {
            e.printStackTrace();
        }
    }

}
