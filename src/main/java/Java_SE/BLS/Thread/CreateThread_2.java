package Java_SE.BLS.Thread;

/**
 * 实现Runnable接口，实现run方法
 */
public class CreateThread_2 implements Runnable{

    private static int ticket = 100;

    public void run() {
        while (true){
            if(ticket > 0){
                System.out.println(
                        Thread.currentThread().getName()+"--"+ticket--);
            }
        }
    }
}
