
package JavaSE.MSB.Thread.C14_ThreadPool;

import java.util.concurrent.*;


//Future 获取Callable未来获取返回值的结果
//FutureTask 即可以调用执行某个任务,也可以获取执行任务的执行结果
public class T05_Future
{
    public static void main(String[] args) throws InterruptedException, ExecutionException
    {
        FutureTask<Integer> task = new FutureTask<>(() ->
        {
            TimeUnit.MILLISECONDS.sleep(500);
            return 1000;
        });
        new Thread(task).start();//即可以执行任务
        System.out.println(task.get());//也可获取执行结果
    }
}
