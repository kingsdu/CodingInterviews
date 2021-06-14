package JavaSE.BLS.Thread.A00MSB.C03;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Du
 * @Date: 2021/6/13 20:31
 */
/**
 * 面试题：模拟银行账户
 * 对业务写方法加锁
 * 对业务读方法不加锁
 * 这样行不行？
 *
 * 容易产生脏读问题（dirtyRead）
 *
 * 根据业务来决定，如果业务不需要控制脏读数据就可以，否则就不行，下面过程会产生数据脏读
 */
public class C01_Account
{
    String name;
    double balance;
    
    public synchronized void set(String name, double balance)
    {
        this.name = name;
        try
        {
            TimeUnit.SECONDS.sleep(2);//睡2s
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        this.balance = balance;
    }
    
    public /*synchronized*/ double getBalance(String name)
    {
        return this.balance;
    }
    
    
    public static void main(String[] args)
    {
        C01_Account a = new C01_Account();
        new Thread(() -> a.set("zhangsan", 100.0)).start();
        
        try
        {
            TimeUnit.SECONDS.sleep(1);//睡1s
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        
        System.out.println(a.getBalance("zhangsan"));//0.0 脏读
        
        try
        {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        
        System.out.println(a.getBalance("zhangsan"));
    }
}
