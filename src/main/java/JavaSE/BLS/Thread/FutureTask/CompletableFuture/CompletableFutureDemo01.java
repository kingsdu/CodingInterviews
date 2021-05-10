package JavaSE.BLS.Thread.FutureTask.CompletableFuture;

import java.util.concurrent.CompletableFuture;

/**
 *
 * Java 8开始引入了CompletableFuture，它针对Future做了改进，
 * 可以传入回调对象，当异步任务完成或者发生异常时，自动调用回调对象的回调方法。
 *
 * 多个CompletableFuture可以串行执行，
 * 例如，定义两个CompletableFuture，
 * 第一个CompletableFuture根据证券名称查询证券代码，
 * 第二个CompletableFuture根据证券代码查询证券价格
 *
 */
public class CompletableFutureDemo01
{
    public static void main(String[] args) throws Exception
    {
        // 第一个任务:
        CompletableFuture<String> cfQuery = CompletableFuture.supplyAsync(() ->
        {
            return queryCode("中国石油");
        });
        // cfQuery成功后继续执行下一个任务:
        CompletableFuture<Double> cfFetch = cfQuery.thenApplyAsync((code) ->
        {
            return fetchPrice(code);
        });
        // cfFetch成功后打印结果:
        cfFetch.thenAccept((result) ->
        {
            System.out.println("price: " + result);
        });
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(2000);
    }
    
    
    static String queryCode(String name)
    {
        try
        {
            Thread.sleep(100);
        } catch (InterruptedException e)
        {
        }
        return "601857";
    }
    
    static Double fetchPrice(String code)
    {
        try
        {
            Thread.sleep(100);
        } catch (InterruptedException e)
        {
        }
        return 5 + Math.random() * 20;
    }
    
}
