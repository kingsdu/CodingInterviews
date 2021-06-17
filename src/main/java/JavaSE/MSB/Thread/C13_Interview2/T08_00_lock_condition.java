package JavaSE.MSB.Thread.C13_Interview2;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//类似于synchronized的变种
public class T08_00_lock_condition
{
    public static void main(String[] args)
    {
        
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();
        
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        
        new Thread(() ->
        {
            try
            {
                lock.lock();
                for (char c : aI)
                {
                    System.out.print(c);
                    condition.signal();
                    condition.await();
                }
                condition.signal();
                
            } catch (Exception e)
            {
                e.printStackTrace();
            } finally
            {
                lock.unlock();
            }
        }, "t1").start();
        
        new Thread(() ->
        {
            try
            {
                lock.lock();
                for (char c : aC)
                {
                    System.out.print(c);
                    condition.signal();
                    condition.await();
                }
                condition.signal();
                
            } catch (Exception e)
            {
                e.printStackTrace();
            } finally
            {
                lock.unlock();
            }
            
        }, "t2").start();
    }
}


