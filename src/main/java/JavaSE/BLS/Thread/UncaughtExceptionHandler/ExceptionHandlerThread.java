package JavaSE.BLS.Thread.UncaughtExceptionHandler;

public class ExceptionHandlerThread implements Thread.UncaughtExceptionHandler
{
    @Override
    public void uncaughtException(Thread t, Throwable e)
    {
        System.out.println("Exception captured");
        System.out.println("发生异常的线程id:"+t.getId());
        e.printStackTrace(System.out);
    }
}
