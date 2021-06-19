package JavaSE.MSB.Thread.C07_Reentrantlock;

import java.util.concurrent.Exchanger;
// 可以用于两个线程之间的通讯
//游戏中交换转换 t1交换给t2  t2交换给t1 程序才完成
public class T12_Exchanger
{
    static Exchanger<String> exchanger = new Exchanger<>();//交换器
    
    public static void main(String[] args)
    {
        new Thread(() ->
        {
            String s = "T1";
            try
            {
                s = exchanger.exchange(s);//T1  t2  阻塞方法
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + s);
            
        }, "t1").start();
        
        
        new Thread(() ->
        {
            String s = "T2";
            try
            {
                s = exchanger.exchange(s);//T2 t1
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + s);
            
        }, "t2").start();
        
        
    }
}
