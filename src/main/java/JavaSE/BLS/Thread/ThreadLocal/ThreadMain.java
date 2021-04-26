package JavaSE.BLS.Thread.ThreadLocal;


/**
 * 当前线程副本，每个线程都有自己独立的副本
 * <p>
 * 每个启动的t1 都有一个单独的sn的ThreadLocal副本
 */
public class ThreadMain
{
    
    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>()
    {
        public Integer initialValue()
        {
            return 0;
        }
    };
    
    
    public ThreadLocal<Integer> getThreadLocal()
    {
        return seqNum;
    }
    
    public int getNextNum()
    {
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }
    
    
    public static void main(String[] args)
    {
        ThreadMain sn = new ThreadMain();
        
        TestClient t1 = new TestClient(sn);
        TestClient t2 = new TestClient(sn);
        TestClient t3 = new TestClient(sn);
        
        t1.start();
        t2.start();
        t3.start();
    }
    
}
