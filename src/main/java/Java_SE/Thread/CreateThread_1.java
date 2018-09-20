package Java_SE.Thread;

/**
 * 继承Thread，覆写run方法
 */
public class CreateThread_1 extends Thread{

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
