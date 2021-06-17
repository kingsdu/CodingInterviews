package JavaSE.MSB.Thread.A03_Volatile;

import java.io.IOException;

/**
 * @Author: Du
 * @Date: 2021/6/11 18:45
 */
public class T07_ThisEscape
{
    
    private int num = 8;
    
    public T07_ThisEscape(){
        new Thread(()->{
            System.out.println(this.num);//有可能输出中间状态值0
        }).start();
    }
    
    public static void main(String[] args) throws IOException
    {
        new T07_ThisEscape();
        System.in.read();//阻塞，确保线程执行完毕
    }
}
