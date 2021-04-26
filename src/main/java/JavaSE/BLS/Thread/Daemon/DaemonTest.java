package JavaSE.BLS.Thread.Daemon;

/**
 *
 * 当进程中所有非守护线程已结束或退出，即使仍有守护线程在运行，进程仍将结束。也就是当程序结束了，守护线程可能依然还未退出。
 *
 * 例子中 Thread B 就依然存在。
 */
public class DaemonTest
{
    
    public static void main(String[] args)
    {
        ThreadA a = new ThreadA();
        ThreadB b = new ThreadB();
        
        b.setDaemon(true);
        
        a.start();
        b.start();
    
        Thread mainThread = Thread.currentThread();
    
        System.out.println("ThreadA 是不是守护线程" + a.isDaemon());
        System.out.println("ThreadB 是不是守护线程" + b.isDaemon());
        System.out.println("mainThread 是不是守护线程" + mainThread.isDaemon());
    }
    
}
