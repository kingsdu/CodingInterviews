package JavaSE.BLS.Thread.DelayQueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Student implements Delayed
{
    private String name;
    private long workTime;
    
    /**
     * NANOSECONDS : 纳秒
     *
     * @param name
     * @param submitTime
     */
    public Student(String name, long submitTime)
    {
        this.name = name;
        this.workTime = submitTime;
    }
    
    @Override
    public String toString()
    {
        return this.name + "交卷，用时" + workTime;
    }
    
    @Override
    public long getDelay(TimeUnit unit)
    {
        return this.workTime - System.currentTimeMillis();
    }
    
    /**
     *
     * 当调用getDelay后，会再调用compareTo比较，剩余时间短的先出队列
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Delayed o)
    {
        Student other = (Student) o;
        return ((Long)(this.workTime)).compareTo((other.workTime));
    }
}
