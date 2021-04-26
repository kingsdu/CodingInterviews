package JavaSE.BLS.Thread.CreateThread;

/**
 * 创建线程的方法2：实现Runnable接口，实现run方法
 */
public class CreateThread_Method2 implements Runnable{

    private static int ticket = 100;

    public void run() {
        try
        {
            Thread.sleep(1000l);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        Thread cur = Thread.currentThread();
        String name = cur.getName();
        System.out.println("线程名称:"+name);
        System.out.println("线程优先级:"+cur.getPriority());
        
    }
}
