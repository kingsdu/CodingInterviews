
package JavaSE.MSB.Thread.C08_InterView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 面试题：（淘宝）
 * 实现一个容器，提供两个方法，add，size
 * 写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数，当个数到5个时，线程2给出提示并结束
 * <p>
 * 方法1
 * 分析下面这个程序，能完成这个功能吗？
 * <p>
 * 问题：在放入和拿出对象的容器需要是同步容器
 */
public class T01_WithoutVolatile
{
    
    List lists = new ArrayList();
    
    public void add(Object o)
    {
        lists.add(o);
    }
    
    public int size()
    {
        return lists.size();
    }
    
    public static void main(String[] args)
    {
        T01_WithoutVolatile c = new T01_WithoutVolatile();
        
        new Thread(() ->
        {
            for (int i = 0; i < 10; i++)
            {
                c.add(new Object());//ArrayList并不是同步容器，所以这里很可能会发生并发问题
                System.out.println("add " + i);
                try
                {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }, "t1").start();
        
        new Thread(() ->
        {
            while (true)
            {
                if (c.size() == 5)//不会有等于5的时刻
                {
                    break;
                }
            }
            System.out.println("t2 结束");
        }, "t2").start();
    }
}
