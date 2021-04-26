package JavaSE.BLS.Thread.CreateThread;

public class InteruptedThread implements Runnable
{
    
    
    @Override
    public void run()
    {
        while (true){
            System.out.println("my thread is runing.....");
            long time = System.currentTimeMillis();
            while (System.currentTimeMillis() - time < 3000){
            
            }
            
            if(Thread.currentThread().isInterrupted()){
                break;
            }
        }
        System.out.println("my thread existing under request");
    }
    
    
    public static void main(String[] args)
    {
        Thread t = new Thread(new InteruptedThread(),"Interupted Thread");
        System.out.println("starting thread...");
        t.start();
        try
        {
            Thread.sleep(2000);
            System.out.println("Interrupted Thread");
            t.interrupt();
            System.out.println("线程是否中断"+t.isInterrupted());
            Thread.sleep(2000);
            System.out.println("Stopping application");
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
