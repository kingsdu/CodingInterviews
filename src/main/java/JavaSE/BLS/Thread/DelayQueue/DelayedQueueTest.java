package JavaSE.BLS.Thread.DelayQueue;

import java.util.concurrent.DelayQueue;

public class DelayedQueueTest
{
    
    public static void main(String[] args)
    {
        final DelayQueue<Student> bq = new DelayQueue<>();
        for (int i = 0; i < 5; i++)
        {
            Student student = new Student("学生" + i, Math.round((Math.random() * 10 + i)));
            bq.put(student);
        }
        
        System.out.println("bq.peek()" + bq.peek().getName());
    }
}
