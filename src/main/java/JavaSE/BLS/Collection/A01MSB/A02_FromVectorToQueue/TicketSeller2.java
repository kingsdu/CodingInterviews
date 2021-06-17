
package JavaSE.BLS.Collection.A01MSB.A02_FromVectorToQueue;

import java.util.Vector;
import java.util.concurrent.TimeUnit;

/**
 * 有N张火车票，每张票都有一个编号
 * 同时有10个窗口对外售票
 * 请写一个模拟程序
 * <p>
 * 分析下面的程序可能会产生哪些问题？
 * <p>
 * 看下面注释
 */
public class TicketSeller2
{
    static Vector<String> tickets = new Vector<>();
    static
    {
        for (int i = 0; i < 1000; i++) tickets.add("票 编号：" + i);
    }
    public static void main(String[] args)
    {
        for (int i = 0; i < 10; i++)
        {
            new Thread(() ->
            {
                while (tickets.size() > 0)
                {
                    try
                    {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    //"Thread-2" java.lang.ArrayIndexOutOfBoundsException: Array index out of range: 0
                    //原因：Vector的 size()加锁、remove()也加了锁，但是中间这一部分没加锁，所以整个这段代码不是原子性的
                    //比如size == 1 ,这时有2个线程，线程1判断完后，还没执行下面--操作，线程1执行完毕，释放锁，线程2判断也>0，
                    //然后线程1执行--，线程2执行--报错
                    System.out.println("销售了--" + tickets.remove(0));
                }
            }).start();
        }
    }
}
