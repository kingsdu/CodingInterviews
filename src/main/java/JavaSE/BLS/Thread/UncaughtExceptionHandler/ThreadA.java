package JavaSE.BLS.Thread.UncaughtExceptionHandler;

public class ThreadA implements Runnable
{
    @Override
    public void run()
    {
        Integer.parseInt("AA");
    }
}
