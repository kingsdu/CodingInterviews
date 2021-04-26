package JavaSE.BLS.Thread.CreateThread;

public class CreateThread_Method2_Main
{
    
    public static void main(String[] args)
    {
        CreateThread_Method2 c2 = new CreateThread_Method2();
    
        for (int i = 0; i < 5; i++)
        {
            new Thread(c2,"线程"+i).start();
        }
    
        Thread thread = Thread.currentThread();
        System.out.println("主线程名称:"+thread.getName());
        System.out.println("主线程优先级:"+thread.getPriority());
    }
}
