package JavaSE.MSB.Thread.C10_ThreadLocal;

import java.util.concurrent.atomic.AtomicIntegerArray;

//10个线程同时各加10000次，线程10如果都是10000则表示线程安全
public class C07_AtomicInterArray
{
    static AtomicIntegerArray array = new AtomicIntegerArray(10);
    
    public static class AddThread implements Runnable
    {
        @Override
        public void run()
        {
            for (int i = 0; i < 10000; i++)
            {
                array.getAndIncrement(i % array.length());
            }
        }
    }
    
    public static void main(String args[]) throws InterruptedException
    {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++)
        {
            threads[i] = new Thread(new AddThread());
        }
        
        for (int i = 0; i < 10; i++)
        {
            threads[i].start();
        }
        for (int i = 0; i < 10; i++)
        {
            threads[i].join();
            System.out.println(array);
        }
    }
}
