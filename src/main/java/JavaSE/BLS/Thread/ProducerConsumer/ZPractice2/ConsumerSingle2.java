package JavaSE.BLS.Thread.ProducerConsumer.ZPractice2;

public class ConsumerSingle2 implements Runnable
{
    ResourceSingle2 r;
    
    public ConsumerSingle2(ResourceSingle2 r){
        this.r = r;
    }
    
    
    @Override
    public void run()
    {
        while (true){
            r.out();
        }
    }
}
