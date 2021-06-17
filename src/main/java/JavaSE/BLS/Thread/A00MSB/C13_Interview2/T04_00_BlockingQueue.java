package JavaSE.BLS.Thread.A00MSB.C13_Interview2;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class T04_00_BlockingQueue
{
    static BlockingQueue<String> q1 = new ArrayBlockingQueue(1);
    static BlockingQueue<String> q2 = new ArrayBlockingQueue(1);
    
    public static void main(String[] args) throws Exception
    {
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();
        
        new Thread(() ->
        {
            for (char c : aI)
            {
                System.out.print(c);//2 T1输出完成后，put值给q1
                try
                {
                    q1.put("ok");
                    q2.take();//4 q2开始阻塞
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }, "t1").start();
        
        new Thread(() ->
        {
            for (char c : aC)
            {
                try
                {
                    q1.take();//1一开始，q1阻塞等值（put） 3 q1拿到值后放行，执行输出操作
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                System.out.print(c);//输出
                try
                {
                    q2.put("ok");//5
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            
        }, "t2").start();
    }
}


