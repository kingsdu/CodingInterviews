package JavaSE.BLS.Thread.ReentrantLock;

public class ReentrantLock01Main
{
    
    public static void main(String[] args)
    {
        ReentrantLockWork r = new ReentrantLockWork();
    
        for (int i = 0; i < 2; i++)
        {
            new Thread(){
                @Override
                public void run(){
                    r.get();
                }
            }.start();
        }
    
        
        for (int i = 0; i < 2; i++)
        {
            new Thread(){
                @Override
                public void run(){
                    r.put();
                }
            }.start();
        }
    }
}
