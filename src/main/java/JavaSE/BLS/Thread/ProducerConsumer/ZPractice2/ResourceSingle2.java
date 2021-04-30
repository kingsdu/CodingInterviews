package JavaSE.BLS.Thread.ProducerConsumer.ZPractice2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ResourceSingle2
{
    private String name;
    private String sex;
    private boolean flag = false;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    //线程任务中有共享数据，所以问题在此处出现
    public void set(String name,String sex){
        try
        {
            lock.lock();
            if(flag)
            {
                condition.await();
            }
            this.name = name;
            this.sex = sex;
            flag = true;
            condition.signal();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        } finally
        {
            lock.unlock();
        }
    }

    public void out(){
        try
        {
            lock.lock();
            if(!flag)
            {
               condition.await();
            }
            System.out.println(this.name + "----" + this.sex);
            flag = false;
            condition.signal();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        } finally
        {
            lock.unlock();
        }
    }
    
    
}
