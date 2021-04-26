package JavaSE.BLS.Thread.DeadLock;

/**
 * 死锁
 */
public class DeadLock implements Runnable{

    private boolean flag;
    public DeadLock(boolean flag){
        this.flag = flag;
    }

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
