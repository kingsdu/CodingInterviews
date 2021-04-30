package JavaSE.BLS.Thread.ProducerConsumer.Lock;

public class Lock_Main
{
    public static void main(String[] args)
    {
        ResourcesGS_Lock r = new ResourcesGS_Lock();
        Producer_Lock p = new Producer_Lock(r);
        Consumer_Lock c = new Consumer_Lock(r);
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);
        Thread t3 = new Thread(p);
        Thread t4 = new Thread(p);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
    
}
