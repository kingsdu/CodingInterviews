package JavaSE.BLS.Thread.ProducerConsumer.Syn;

/**
 * 生产者和消费者的例子来说明多线程通讯存在的问题
 */
public class ResourcesGS
{
    private String name;
    private int count = 1;
    private boolean flag = false;
    
    public synchronized void set(String name)
    {// t1,t2
        //此处必须用while不能用if，被唤醒的线程必须重新判断标记，再决定是否生产
        while (flag)
        {
            try
            {
                //必须用this指向当前对象，因为多线程开启会有很多wait，需要用this标识
                this.wait();//wait()释放CPU执行权，也释放同步锁，使得其他线程可以使用同步控制块或者方法。
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        
        this.name = name + "---" + count++;
        System.out.println(Thread.currentThread().getName() + "..生产者.." + this.name);
        flag = true;
        this.notifyAll();
    }
    
    public synchronized void out()
    {//t3,t4
        while (!flag)
        {
            try
            {
                this.wait();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "........消费者......." + this.name);
        flag = false;
        this.notifyAll();//因为已经有标记的原因，所以可以唤醒剩下所有的线程
    }
}
