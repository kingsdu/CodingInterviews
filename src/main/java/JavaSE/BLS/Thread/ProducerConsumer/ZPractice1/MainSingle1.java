package JavaSE.BLS.Thread.ProducerConsumer.ZPractice1;
/**
 * 问题1：会出现张三 女的异常现象
 * 原因：
 * 在没有线程安全的情况下，当A线程在设置张三时，B线程获得CPU执行权，执行输出，name是张三，但是sex还未修改
 * 所以会出现线程安全问题。
 *
 * 后加上synchronized (r) 后
 * 问题1解决，问题2：没有逐个输出
 *
 * 后使用wait 和 notify解决
 *
 *
 */
public class MainSingle1
{
    
    public static void main(String[] args)
    {
        ResourceSingle1 s = new ResourceSingle1();
        ProducerSingle1 p = new ProducerSingle1(s);
        ConsumerSingle1 c = new ConsumerSingle1(s);
        
        Thread t = new Thread(p);
        Thread q = new Thread(c);
        t.start();
        q.start();
    }
}
