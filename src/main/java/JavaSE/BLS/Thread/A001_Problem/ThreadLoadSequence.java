package JavaSE.BLS.Thread.A001_Problem;

public class ThreadLoadSequence
{
    
    public static void main(String[] args)
    {
        Runnable runnable = new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("foo");
            }
        };
    
        Thread t = new Thread(runnable);
        t.run();
        System.out.println("bar");
    }

}
