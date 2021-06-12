package JavaSE.BLS.Thread.A004_Volatile;

import java.io.IOException;

/**
 * @Author: Du
 * @Date: 2021/6/11 20:52
 */
public class T08_ThisEscapeUpdate
{
    
    private int num = 8;
    
    Thread t1;
    
    public T08_ThisEscapeUpdate(){
        t1 = new Thread(()->{
            System.out.println(this.num);
        });
    }
    //将start方法单独写，不要放在构造方法中
    public void start(){
        t1.start();
    }
    
    public static void main(String[] args) throws IOException
    {
        T08_ThisEscapeUpdate t = new T08_ThisEscapeUpdate();
        t.start();
        System.in.read();//阻塞，确保线程执行完毕
    }
}
