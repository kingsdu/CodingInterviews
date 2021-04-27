package JavaSE.BLS.Thread.DeadLock;

/**
 * 死锁
 */
public class DeadLock implements Runnable{

    private boolean flag;
    public DeadLock(boolean flag){
        this.flag = flag;
    }
    
    /**
     *
     * 线程1为true进入先拿到 locka，
     * 线程2为false时，拿到lockb，
     * 这时线程2为false时想拿到locka，但是locka在线程1中，
     * 线程1想拿lockb，但是在线程2手中
     *
     */
    @Override
    public void run() {
        if(flag){
           while (true){
               synchronized (ObjectLock.locka){
                   System.out.println("if locka");
                   synchronized (ObjectLock.lockb){
                       System.out.println("if lockb");
                   }
               }
           }
        }else{
            while (true){
                synchronized (ObjectLock.lockb){
                    System.out.println("if lockb");
                    synchronized (ObjectLock.locka){
                        System.out.println("if locka");
                    }
                }
            }
        }
    }
}
