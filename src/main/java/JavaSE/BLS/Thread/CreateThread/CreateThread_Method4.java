package JavaSE.BLS.Thread.CreateThread;

import java.util.concurrent.Callable;

/**
 * 方法4：不通过FutureTask，来实现Callable实例作为线程的执行体
 */
public class CreateThread_Method4 implements Callable<String> {

    private static int ticket;

    public CreateThread_Method4(int ticket){
        this.ticket = ticket;
    }

    public String call() throws Exception {
        return "this task num is "+ ticket;
    }

}
