package JavaSE.BLS.Thread.DelayQueue;

import java.util.concurrent.DelayQueue;

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
