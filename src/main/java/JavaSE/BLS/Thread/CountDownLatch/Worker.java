package JavaSE.BLS.Thread.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class Worker extends Thread
{
    private String workerName;
    private CountDownLatch latch;
    
    public Worker(String workerName,CountDownLatch latch){
        this.workerName = workerName;
        this.latch = latch;
    }
    
    @Override
    public void run(){
        try
        {
            System.out.println("worker " + workerName + " is begin");
            Thread.sleep(1000l);
            System.out.println("worker " + workerName + " is end");
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        latch.countDown();
    }
    
}
