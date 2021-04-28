package JavaSE.BLS.Thread.CyclicBarrier;

public class TotalTask extends Thread
{
    @Override
    public void run(){
        System.out.println("所有子任务都执行完毕，开始执行主任务了");
    }
}
