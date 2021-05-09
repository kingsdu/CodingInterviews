package JavaSE.BLS.Thread.Daemon;

public class ThreadA extends Thread
{
    @Override
    public void run(){
        for (int i = 0; i < 15; i++)
        {
            System.out.println("ThreadA 第" + i + "次执行");
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
