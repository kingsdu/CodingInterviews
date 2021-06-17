/**
 * 代码不好维护
 */
package JavaSE.MSB.Thread.C17_Future_to_loom;

import com.google.common.util.concurrent.*;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

//可以使用google提供的并发包解决这个问题
public class T02_ListenableFuture
{
    public static void main(String[] args)
    {
        ListeningExecutorService service =
                MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(2));
        ListenableFuture<Integer> future = service.submit(new Callable<Integer>()
        {
            @Override
            public Integer call() throws Exception
            {
                return 8;
            }
        });
        
        Futures.addCallback(future, new FutureCallback<Integer>()
        {
            @Override
            public void onSuccess(@Nullable Integer integer)
            {
                System.out.println(integer);
            }
            
            @Override
            public void onFailure(Throwable throwable)
            {
                throwable.printStackTrace();
            }
        }, service);
        
        service.shutdown();
    }
}

