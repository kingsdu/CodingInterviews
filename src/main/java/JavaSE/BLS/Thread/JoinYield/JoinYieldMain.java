package JavaSE.BLS.Thread.JoinYield;

public class JoinYieldMain
{
    public static void main(String[] args)
    {
        JoinYieldDemo demo = new JoinYieldDemo();
        Thread t1 = new Thread(demo);
        Thread t2 = new Thread(demo);
    
        t1.start();
        t2.start();
    
        try
        {
            t1.join();//主线程执行到这里，知道t1要加入执行，主线程会释放执行权、执行资格并处于冻结状态，等待t1执行完毕后再开始继续执行
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        
        for (int i = 0; i < 50; i++)
        {
            System.out.println("main------>" + i);
        }
        System.out.println("over");
    }
}
