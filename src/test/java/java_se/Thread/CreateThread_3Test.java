package java_se.Thread;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CreateThread_3Test {

    @Test
    public void CreateThread_3_call() {
        CreateThread_3 callable = new CreateThread_3();

        FutureTask<String> futureTask = new FutureTask<String>(callable);

        new Thread(futureTask).start();

        //其实就三步：1 创建Callable实例
        //2将Callable实例设置进FutureTask实例中
        //3将FutureTask实例作为Runnable类型设置进Thread中
        try {
            System.out.println("子线程的返回结果："+futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}