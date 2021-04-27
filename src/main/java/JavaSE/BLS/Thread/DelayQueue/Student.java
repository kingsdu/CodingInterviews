package JavaSE.BLS.Thread.DelayQueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Student implements Delayed
{
    private String name;
    private long submitTime;
    private long workTime;
    
    public String getName()
    {
        return this.name + "交卷，用时" + workTime;
    }
    
    /**
     * NANOSECONDS : 纳秒
     *
     * @param name
     * @param submitTime
     */
    public Student(String name, long submitTime)
    {
        this.name = name;
        this.submitTime = submitTime;
        this.submitTime = TimeUnit.NANOSECONDS.convert(submitTime, TimeUnit.MILLISECONDS) + System.nanoTime();
        System.out.println(this.name + "交卷，用时" + workTime);
    }
    
    
    @Override
    public long getDelay(TimeUnit unit)
    {
        return unit.convert(submitTime - System.nanoTime(), unit.NANOSECONDS);
//        return 1000l;
    }
    
    @Override
    public int compareTo(Delayed o)
    {
        Student that = (Student) o;
        return submitTime > that.submitTime ? 1 : (submitTime < that.submitTime ? -1 : 0);
    }
}
