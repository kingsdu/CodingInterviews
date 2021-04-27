package JavaSE.BLS.Thread.DeadLock;

public class DeadLockMain
{
    
    public static void main(String[] args)
    {
        DeadLock d = new DeadLock(true);
        Thread thread = new Thread(d);
        thread.start();
        
        d = new DeadLock(false);
        thread = new Thread(d);
        thread.start();
    }
}
