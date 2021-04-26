package JavaSE.BLS.Thread.CreateThread;

/**
 *
 *
 * 创建线程的方法1：继承Thread，覆写run方法
 *
 *
 *
 */
public class CreateThread_Method1 extends Thread{

    private static int ticket = 100;

    @Override
    public void run() {
        while (true){
           if(ticket > 0){
               System.out.println(
                       Thread.currentThread().getName()+"--"+ticket--);
           }
        }
    }

}
