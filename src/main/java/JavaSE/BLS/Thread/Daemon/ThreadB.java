package JavaSE.BLS.Thread.Daemon;

public class ThreadB extends Thread
{
    @Override
    public void run()
    {//JRE判断程序执行完毕的标准是：前台线程是否执行完毕，完毕了就结束，不去考虑守护线程
        for (int i = 0; i < 115; i++)//主线程结束即使守护线程没有运行完，整个线程也会结束
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
