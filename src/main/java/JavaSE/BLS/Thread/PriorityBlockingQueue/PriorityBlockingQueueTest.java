package JavaSE.BLS.Thread.PriorityBlockingQueue;

import java.util.concurrent.PriorityBlockingQueue;

/**
 *
 * PriorityBlockingQueue不会阻塞生产者，只会在没有消费者的时候，阻塞消费者数据
 * 所以生产者的速度不能 > 消费者 ，否则系统资源可能被消耗殆尽
 *
 */
public class PriorityBlockingQueueTest
{
    
    public static void main(String[] args) throws InterruptedException
    {
        PriorityBlockingQueue<Student> pr = new PriorityBlockingQueue();
        pr.put(new Student("aa",11));
        pr.put(new Student("bb",21));
        pr.put(new Student("cc",6));
        pr.put(new Student("dd",31));
        
        //优先级队列是在取数据时才进行比较判断
        System.out.println(pr.take());
        System.out.println(pr.take());
        System.out.println(pr.take());
        System.out.println(pr.take());
    }
    
    
}
