package JavaSE.BLS.Thread.ThreadUnsafe;

/**
 *
 * 多个线程都进行对数字 +1 的活动
 *
 */
public class ThreadWork
{

    public int count = 0;
    
    /**
     *
     * 加上synchronized，5个线程就逐个执行
     *
     */
    public synchronized void add(){
        
        //休息
        try
        {
            Thread.sleep(1000l);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        //干活
        count++;
        System.out.println(Thread.currentThread().getName() +"----"+ count);
    }

}
