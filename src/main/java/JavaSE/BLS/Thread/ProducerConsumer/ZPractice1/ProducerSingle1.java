package JavaSE.BLS.Thread.ProducerConsumer.ZPractice1;


public class ProducerSingle1 implements Runnable
{
    ResourceSingle1 r;
    
    public ProducerSingle1(ResourceSingle1 r)
    {
        this.r = r;
    }
    
    @Override
    public void run()
    {
        int x = 0;
        
        while (true)
        {
            try
            {
                synchronized (r){
                    if(!r.flag){
                        r.wait();
                    }
                    if (x == 0)
                    {
                        r.name = "张三";
                        r.sex = "男";
                    } else
                    {
                        r.name = "小丽";
                        r.sex = "女";
                    }
                    x = (x + 1) % 2;
                    r.flag = false;
                    r.notify();
                }
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
