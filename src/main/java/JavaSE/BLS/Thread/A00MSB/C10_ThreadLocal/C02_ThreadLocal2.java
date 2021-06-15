/**
 * ThreadLocal线程局部变量
 * <p>
 * ThreadLocal是使用空间换时间，synchronized是使用时间换空间
 * 比如在hibernate中session就存在与ThreadLocal中，避免synchronized的使用
 * <p>
 * 运行下面的程序，理解ThreadLocal
 *
 * @author 马士兵
 */
package JavaSE.BLS.Thread.A00MSB.C10_ThreadLocal;

import java.util.concurrent.TimeUnit;

public class C02_ThreadLocal2
{
    static ThreadLocal<Person> tl = new ThreadLocal<>();//每个线程内部都有一个ThreadLocal
    
    public static void main(String[] args)
    {
        new Thread(() ->
        {
            try
            {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            
            System.out.println("t1 " + tl.get());//t1 null
        }).start();
        
        new Thread(() ->
        {
            try
            {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            tl.set(new Person());
            System.out.println("t2 " + tl.get().name);//t2 zhangsan
        }).start();
    }
    
    static class Person
    {
        String name = "zhangsan";
    }
}


