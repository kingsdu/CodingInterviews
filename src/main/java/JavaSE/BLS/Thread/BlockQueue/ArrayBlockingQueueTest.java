package JavaSE.BLS.Thread.BlockQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQueueTest
{
    
    public static void main(String[] args) throws InterruptedException
    {
    
        BlockingQueue<String> bq = new ArrayBlockingQueue<>(16);
    
        //启动4个线程去执行
        for (int i = 0; i < 4; i++)
        {
            new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    while (true){
                        try
                        {
                            String log = bq.take();
                            parseLog(log);
                        } catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    
        //模拟产生16个日志对象，并且需要16s才能打印完日志
        for (int i = 0; i < 16; i++)
        {
            String log = (i+1) + "-->";
            bq.put(log);
        }
    }
    
    /**
     *
     * 每打印完一个日志就要睡1s,16个日志对象需要16s，但是分4个线程去执行，只需要4s
     *
     * @param log
     */
    public static void parseLog(String log){
        System.out.println(log + System.currentTimeMillis());
        try
        {
            Thread.sleep(1000l);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

}
