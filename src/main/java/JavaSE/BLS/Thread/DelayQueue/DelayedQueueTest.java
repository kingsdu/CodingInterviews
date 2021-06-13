package JavaSE.BLS.Thread.DelayQueue;

import java.util.concurrent.DelayQueue;

/**
 *
 * 支持延时获取元素的使用优先级队列的实现的无阻塞队列，队列中的元素必须实现Delayed和Comparable接口
 *
 * 在创建元素时可以指定多久才能从队列中重新获取当前元素，只有满足延时的队列中才能获取元素
 *
 * 可以用于
 * 1 缓存系统的设计，时间到了清除缓存
 * 2 定时任务的调度，到了某个时刻执行某个任务
 *
 */
public class DelayedQueueTest
{
    
    public static void main(String[] args) throws InterruptedException
    {
        final DelayQueue<Student> bq = new DelayQueue<>();
        bq.put(new Student("学生1",System.currentTimeMillis()+3000));
        bq.put(new Student("学生2",System.currentTimeMillis()+2000));
        bq.put(new Student("学生3",System.currentTimeMillis()+1000));
        bq.put(new Student("学生4",System.currentTimeMillis()+4000));
    
        System.out.println("--------------------------");
        while (!bq.isEmpty()){
            System.out.println(bq.take());
        }
    }
}
