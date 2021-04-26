package JavaSE.BLS.Thread.ReentrantReadLock;

public class A01_ReentrantReadLockMain
{
    /**
     *
     * 读的时候是并发的，写的时候是阻塞的
     *
     * @param args
     */
    public static void main(String[] args)
    {
        A01_ReentrantReadLockWork r = new A01_ReentrantReadLockWork();
        
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
