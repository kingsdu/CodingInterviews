package Java_SE.Thread;

import java.util.concurrent.Callable;

/**
 * 方法4：不通过FutureTask，来实现Callable实例作为线程的执行体
 */
public class CreateThread_4 implements Callable<String> {

    private static int ticket;

    public CreateThread_4(int ticket){
        this.ticket = ticket;
    }

    public String call() throws Exception {
        return "this task num is "+ ticket;
    }

}
