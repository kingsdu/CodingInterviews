package JavaSE.MSB.Thread.A03_Volatile;

/**
 * @Author: Du
 * @Date: 2021/6/11 18:25
 */
public class T06_NoVisibility
{
    private static volatile boolean ready = false;//1 加volatile
    private static int number;
    
    
    private static class ReaderThread extends Thread
    {
        @Override
        public void run()
        {
            while (!ready)
            {
                Thread.yield();
            }
            System.out.println(number);
        }
    }
    
    public static void main(String[] args) throws InterruptedException
    {
        Thread t = new ReaderThread();
        t.start();
        number = 42;//有序性问题，如果下面的语句先执行，输出number可能就是0
        ready = true;//不一定会马上停止(可见性问题)
        t.join();
    }
    
}
