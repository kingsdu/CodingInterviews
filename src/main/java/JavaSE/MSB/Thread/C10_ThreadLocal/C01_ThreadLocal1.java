package JavaSE.MSB.Thread.C10_ThreadLocal;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Du
 * @Date: 2021/6/15 19:45
 */
public class C01_ThreadLocal1
{
    volatile static Person p = new Person();
    
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
            System.out.println("t1 " + p.name);
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
            p.name = "lisi";
            System.out.println("t2 " + p.name);
        }).start();
    }
    
    static class Person
    {
        String name = "zhangsan";
    }
}

