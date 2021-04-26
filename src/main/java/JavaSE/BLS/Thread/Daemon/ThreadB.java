package JavaSE.BLS.Thread.Daemon;

public class ThreadB extends Thread
{
    @Override
    public void run()
    {
        for (int i = 0; i < 1115; i++)
        {
            System.out.println("守护线程 ThreadB 第" + i + "次执行");
            try
            {
                Thread.sleep(7);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
