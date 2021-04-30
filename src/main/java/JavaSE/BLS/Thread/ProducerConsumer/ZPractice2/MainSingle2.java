package JavaSE.BLS.Thread.ProducerConsumer.ZPractice2;

/**
 *
 * 要求3，对name和sex私有化
 * 使用Lock来管理
 *
 *
 */
public class MainSingle2
{
    
    public static void main(String[] args)
    {
        ResourceSingle2 s = new ResourceSingle2();
        ProducerSingle2 p = new ProducerSingle2(s);
        ConsumerSingle2 c = new ConsumerSingle2(s);
        
        Thread t = new Thread(p);
        Thread q = new Thread(c);
        t.start();
        q.start();
    }
}
