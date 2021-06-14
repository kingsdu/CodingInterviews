package JavaSE.BLS.Thread.A00MSB.A03_Volatile;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: Du
 * @Date: 2021/6/11 18:04
 *
 * 不是所有的语句都是完全按照顺序执行的
 * 某些语句的执行是乱序的
 * 乱序是现象是缺失存在的
 */
public class T05_DisOrder
{
    private static int x = 0, y = 0;
    private static int a = 0, b = 0;
    
    public static void main(String[] args) throws InterruptedException
    {
        for (long i = 0; i < Long.MAX_VALUE; i++)
        {
            x = 0;
            y = 0;
            a = 0;
            b = 0;
            
            CountDownLatch latch = new CountDownLatch(2);
            
            Thread T1 = new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    a = 1;
                    x = b;
                    
                    latch.countDown();
                }
            });
            
            
            Thread T2 = new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    b = 1;
                    y = a;
                    
                    latch.countDown();
                }
            });
            
            T1.start();
            T2.start();
            latch.await();
            String result = "第" + i + "次" + x + "," + y;
            
            if(x == 0 && y == 0){
                System.err.println(result);
                break;
            }
        }
        
    }
    
}
