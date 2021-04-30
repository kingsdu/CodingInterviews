package JavaSE.BLS.Thread.ProducerConsumer.ZPractice2;


public class ProducerSingle2 implements Runnable
{
    ResourceSingle2 r;
    
    public ProducerSingle2(ResourceSingle2 r)
    {
        this.r = r;
    }
    
    @Override
    public void run()
    {
        int x = 0;
        
        while (true)
        {
            if (x == 0)
            {
                r.set("张三","男");
            } else
            {
                r.set("小丽","女");
            }
            x = (x + 1) % 2;
        }
    }
}
