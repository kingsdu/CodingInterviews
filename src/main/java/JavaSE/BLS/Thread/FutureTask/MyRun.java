package JavaSE.BLS.Thread.FutureTask;

public class MyRun implements Runnable
{
    @Override
    public void run()
    {
        try
        {
            Thread.sleep(1000l);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("特定线程2完成");
    }
}
