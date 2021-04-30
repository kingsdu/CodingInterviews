package JavaSE.BLS.Thread.JoinYield;

public class JoinYieldDemo implements Runnable
{
    @Override
    public void run()
    {
        for (int i = 0; i <= 40; i++)
        {
            System.out.println(Thread.currentThread().getName() + "----" + i);
            Thread.yield();//线程临时暂停，将执行权释放，让其他线程有机会获取执行权。
        }
    }
}
