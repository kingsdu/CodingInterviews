package JavaSE.MSB.Thread.C08_InterView;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 * 方法2，t1必须要有sleep方法
 *
 * 方法2存在的问题：
 * 给lists添加volatile之后，t2能够接到通知，但是，t2线程的死循环很浪费cpu，如果不用死循环，
 * 而且，如果在if 和 break之间被别的线程打断，得到的结果也不精确，
 * 该怎么做呢？
 *
 * 1、volatile尽量修饰简单值，volatile修饰对象，对象中的引用变了，volatile监测不到
 */
public class T02_Volatile_synchronizedList
{
    
    //添加volatile，使t2能够得到通知
    //volatile List lists = new LinkedList();
    volatile List lists = Collections.synchronizedList(new LinkedList<>());//同步容器，同时用volatile修饰，使其值改变时能够得到通知
    
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
        T02_Volatile_synchronizedList c = new T02_Volatile_synchronizedList();
        new Thread(() ->
        {
            for (int i = 0; i < 10; i++)
            {
                c.add(new Object());
                System.out.println("add " + i);
				//必须要sleep，没用sleep不行
				try {
                    TimeUnit.MILLISECONDS.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
            }
        }, "t1").start();
        
        new Thread(() ->
        {
            while (true)
            {
                if (c.size() == 5)
                {
                    break;
                }
            }
            System.out.println("t2 结束");
        }, "t2").start();
    }
}
