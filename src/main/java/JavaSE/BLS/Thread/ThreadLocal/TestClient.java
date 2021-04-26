package JavaSE.BLS.Thread.ThreadLocal;

public class TestClient extends Thread
{
    
    private ThreadMain sn;
    
    public TestClient(ThreadMain sn){
        this.sn = sn;
    }
    
    @Override
    public void run(){
        for (int i = 0; i < 3; i++)
        {
            System.out.println("Thread name"+Thread.currentThread().getName() + "---sn:"+sn.getNextNum());
        }
        sn.getThreadLocal().remove();
    }
    
}
