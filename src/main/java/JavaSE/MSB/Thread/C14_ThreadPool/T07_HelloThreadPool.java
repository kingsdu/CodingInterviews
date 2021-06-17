package JavaSE.MSB.Thread.C14_ThreadPool;

import java.io.IOException;
import java.util.concurrent.*;

public class T07_HelloThreadPool
{

    static class Task implements Runnable {
        private int i;

        public Task(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " Task " + i);
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            return "Task{" +
                    "i=" + i +
                    '}';
        }
    }

    public static void main(String[] args) {
        //corePoolSize:核心线程永远占住,内存不足也不会回收
        //maximumPoolSize:最大线程,最多线程是多少
        //keepAliveTime:多长时间归还非核心线程,有参数也指定核心线程是否回收
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(2, 4,
                60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(4),//线程池中使用的线程队列
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());//线程满了,任务队列也满了,还有线程来了就执行拒绝策略,JDK提供了4种处理方式,也可以自定义处理方式

        for (int i = 0; i < 8; i++) {
            tpe.execute(new Task(i));
        }

        System.out.println(tpe.getQueue());

        tpe.execute(new Task(100));

        System.out.println(tpe.getQueue());

        tpe.shutdown();
    }
}
