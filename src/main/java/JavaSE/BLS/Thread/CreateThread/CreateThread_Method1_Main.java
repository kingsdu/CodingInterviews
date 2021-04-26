package JavaSE.BLS.Thread.CreateThread;

public class CreateThread_Method1_Main
{
    
    public static void main(String[] args)
    {
        CreateThread_Method1 c1 = new CreateThread_Method1();
        Thread t = new Thread(c1);
        t.start();
    }
}
