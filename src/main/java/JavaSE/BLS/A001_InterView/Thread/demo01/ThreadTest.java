package JavaSE.BLS.A001_InterView.Thread.demo01;

public class ThreadTest
{
    public static void main(String args[])
    {
        Test mv = new Test();
        Thread t1 = new ThreadExample(mv);
        Thread t2 = new ThreadExample(mv);
        Thread t3 = new ThreadExample(mv);
        t1.start();
        t2.start();
        t3.start();
    }
}
