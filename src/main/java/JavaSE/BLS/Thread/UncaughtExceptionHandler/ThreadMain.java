package JavaSE.BLS.Thread.UncaughtExceptionHandler;


/**
 *
 * 每个线程的异常必须自己捕获，自己处理，不要委托到外部。
 * 因为线程是独立执行的代码片段
 *
 *
 */
public class ThreadMain
{
    
    public static void main(String[] args)
    {
        ThreadA a = new ThreadA();
        Thread thread = new Thread(a);
        
        thread.setUncaughtExceptionHandler(new ExceptionHandlerThread());
        
        thread.start();
    }
}
