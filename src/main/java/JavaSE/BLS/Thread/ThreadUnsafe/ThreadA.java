package JavaSE.BLS.Thread.ThreadUnsafe;

public class ThreadA extends Thread
{
    private ThreadWork threadWork;
    
    public ThreadA(ThreadWork threadWork){
        this.threadWork = threadWork;
    }
    
    @Override
    public void run(){
        threadWork.add();
    }
    
}
