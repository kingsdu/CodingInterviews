package JavaSE.BLS.A001_InterView.Thread.demo01;

public class ThreadExample extends Thread
{
    private Test mv;
    
    public ThreadExample(Test mv)
    {
        this.mv = mv;
    }
    
    public void run()
    {
        synchronized (mv)
        {
            mv.m();
        }
    }
}
