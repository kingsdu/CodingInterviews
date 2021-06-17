package JavaSE.BLS.Collection.A01MSB.A03_Map;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class T06_ArrayBlockingQueue
{
    
    static BlockingQueue<String> strs = new ArrayBlockingQueue<>(10);
    
    static Random r = new Random();
    
    public static void main(String[] args) throws InterruptedException
    {
        for (int i = 0; i < 10; i++)
        {
            strs.put("a" + i);
        }
        //一共有10个数组，满了就好了
        
        strs.put("aaa"); //满了就会等待，程序阻塞
        //strs.add("aaa");//add会报异常
        //strs.offer("aaa");//offer不会报异常
        //strs.offer("aaa", 1, TimeUnit.SECONDS);
        
        System.out.println(strs);
    }
}
