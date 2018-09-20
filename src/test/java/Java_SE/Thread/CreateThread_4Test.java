package Java_SE.Thread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CreateThread_4Test {

    /**
     * 多个线程
     */
    @Test
    public void createThread_4_call() {
        ExecutorService exec = Executors.newCachedThreadPool();
        List<Future<String>> list = new ArrayList<Future<String>>();

        for (int i = 0; i < 30; i++) {
            CreateThread_4 callable = new CreateThread_4(i);//创建Callable接口实例
            list.add(exec.submit(callable));//将callable接口实例提交进线程池
        }

        for (Future<String> fs : list) {
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 一个线程
     */
    @Test
    public void createThread_4_call_1() {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        Future<String> future = threadPool.submit(new CreateThread_4(190));
        try {
            System.out.println(future.get());
        } catch (Exception e) {

        } finally {
            threadPool.shutdown();
        }
    }
}