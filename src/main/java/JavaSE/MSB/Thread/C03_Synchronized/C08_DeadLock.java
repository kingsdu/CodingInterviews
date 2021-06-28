package JavaSE.MSB.Thread.C03_Synchronized;


public class C08_DeadLock extends Thread
{
    protected Object tool;
    static Object fork1 = new Object();
    static Object fork2 = new Object();
    
    public C08_DeadLock(Object object)
    {
        this.tool = object;
        
        if (tool == fork1)
        {
            this.setName("哲学家A");
        }
        if (tool == fork2)
        {
            this.setName("哲学家B");
        }
    }
    
    public void run()
    {
        if (tool == fork1)
        {
            synchronized (fork1)
            {
                try
                {
                    Thread.sleep(500);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                
                synchronized (fork2)
                {
                    System.out.println("哲学家A开始吃饭了");
                }
            }
        }
        if (tool == fork2)
        {
            synchronized (fork2)
            {
                try
                {
                    Thread.sleep(500);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                
                synchronized (fork1)
                {
                    System.out.println("哲学家B开始吃饭了");
                }
            }
        }
    }
    
    
    public static void main(String args[]) throws InterruptedException
    {
        C08_DeadLock 哲学家A = new C08_DeadLock(fork1);
        C08_DeadLock 哲学家B = new C08_DeadLock(fork2);
        
        哲学家A.start();
        哲学家B.start();
        
        Thread.sleep(1000);
    }
}