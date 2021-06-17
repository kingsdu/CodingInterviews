package JavaSE.MSB.Thread.C14_ThreadPool;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
/**
 *
 * 假设你能够提供一个服务
 * 这个服务查询各大电商网站(淘宝 京东 拼多多)同一类产品的价格并汇总展示
 *
 *
 */
//底层是ForkJoinPool
public class T06_CompletableFuture
{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start, end;

        /*start = System.currentTimeMillis();
        //并行执行,但是某一个过程出现问题时就会影响所有的性能
        priceOfTM();
        priceOfTB();
        priceOfJD();

        end = System.currentTimeMillis();
        System.out.println("use serial method call! " + (end - start));*/

        start = System.currentTimeMillis();
        //定义3个异步任务,分别去执行
        CompletableFuture<Double> futureTM = CompletableFuture.supplyAsync(()->priceOfTM());
        CompletableFuture<Double> futureTB = CompletableFuture.supplyAsync(()->priceOfTB());
        CompletableFuture<Double> futureJD = CompletableFuture.supplyAsync(()->priceOfJD());
        //所有任务完成后,继续执行
        CompletableFuture.allOf(futureTM, futureTB, futureJD).join();//堆任务的管理

        CompletableFuture.supplyAsync(()->priceOfTM())//先去拿数据
                .thenApply(String::valueOf)//拿到后转为String类型
                .thenApply(str-> "price1212 " + str)//然后拼一个price
                .thenAccept(System.out::println);//打印
        
        end = System.currentTimeMillis();
        System.out.println("use completable future! " + (end - start));

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double priceOfTM() {
        delay();
        return 1.00;
    }

    private static double priceOfTB() {
        delay();
        return 2.00;
    }

    private static double priceOfJD() {
        delay();
        return 3.00;
    }

    /*private static double priceOfAmazon() {
        delay();
        throw new RuntimeException("product not exist!");
    }*/

    private static void delay() {
        int time = new Random().nextInt(500);
        try {
            TimeUnit.MILLISECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("After %s sleep!\n", time);
    }
}
