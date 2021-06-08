package JavaSE.BLS.Thread.PriorityBlockingQueue;

import java.util.concurrent.PriorityBlockingQueue;

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
