package JavaSE.BLS.Thread.Synchronized;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronizedTest
{
    public static void main(String[] args)
    {
        SynchronousQueue sq = new SynchronousQueue();
        
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                while (true){
                    try
                    {
                        //System.out.println(sq.take());
                        Object poll = sq.poll(3, TimeUnit.SECONDS);
                        if(poll == null){
                            break;
                        }
                        System.out.println(poll);
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    sq.put("aaa");
                    sq.put("bbb");
                    sq.put("ccc");
                    sq.put("ddd");
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
