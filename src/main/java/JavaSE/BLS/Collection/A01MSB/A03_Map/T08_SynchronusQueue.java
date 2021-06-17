package JavaSE.BLS.Collection.A01MSB.A03_Map;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
//容量为0
//让一个线程给另一个容器下任务
//两个线程可以直接交换数据
public class T08_SynchronusQueue
{
    public static void main(String[] args) throws InterruptedException
    {
        BlockingQueue<String> strs = new SynchronousQueue<>();
        
        new Thread(() ->
        {
            try
            {
                System.out.println(strs.take());
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }).start();
        
        //容量为0，所以阻塞
        strs.put("aaa"); //阻塞等待消费者消费
        strs.put("bbb");
        //strs.add("aaa");//不能往里面装东西，容量为0
        System.out.println(strs.size());
    }
}
