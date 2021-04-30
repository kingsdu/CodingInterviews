package JavaSE.BLS.Thread.ProducerConsumer.ZPractice1;

public class ConsumerSingle1 implements Runnable
{
    ResourceSingle1 r;
    
    public ConsumerSingle1(ResourceSingle1 r){
        this.r = r;
    }
    
    
    @Override
    public void run()
    {
        while (true){
            try
            {
                synchronized (r)
                {
                    if(r.flag)
                    {
                        r.wait();
                    }
                    System.out.println(r.name + "----" + r.sex);
                    r.flag = true;
                    r.notify();
                }
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
