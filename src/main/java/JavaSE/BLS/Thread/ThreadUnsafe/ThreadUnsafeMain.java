package JavaSE.BLS.Thread.ThreadUnsafe;

public class ThreadUnsafeMain
{
    public static void main(String[] args)
    {
        ThreadWork t = new ThreadWork();
    
        /**
         *
         * 5个线程，先休息1s，醒来在执行线程，给的总线程的执行时间是1s，所以会产生线程不安全的现象
         *
         * 当加上synchronized后，5个线程就逐个执行，恢复正常
         */
        for (int i = 0; i < 115; i++)
        {
            ThreadA a = new ThreadA(t);
            a.start();
        }
    
        try
        {
            Thread.sleep(5100l);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    
        System.out.println("5人干完活，count最后为："+t.count);
    }
}
