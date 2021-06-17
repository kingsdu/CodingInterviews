/*
Condition本质是锁资源上不同的等待队列
 */
package JavaSE.MSB.Thread.C13_Interview2;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class T09_00_lock_condition
{
    public static void main(String[] args)
    {
        
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();
        
        Lock lock = new ReentrantLock();
        Condition conditionT1 = lock.newCondition();//等待队列1
        Condition conditionT2 = lock.newCondition();//等待队列2
        
        new Thread(() ->
        {
            try
            {
                lock.lock();
                
                for (char c : aI)
                {
                    System.out.print(c);//T1完成
                    conditionT2.signal();//叫醒等待T2中的等待元素
                    conditionT1.await();//T1等待
                }
                
                conditionT2.signal();
                
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
                    System.out.print(c);//T2完成
                    conditionT1.signal();//叫醒T1
                    conditionT2.await();//T2等待
                }
                
                conditionT1.signal();
                
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


