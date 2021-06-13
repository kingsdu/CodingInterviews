package JavaSE.BLS.Thread.MSB.C01;


//主线程运行中的状态
public class T04_ThreadState
{
    static class MyThread extends Thread
    {
        @Override
        public void run()
        {
            System.out.println("RUNNABLE----" + this.getState());
            for (int i = 0; i < 10; i++)
            {
                try
                {
                    Thread.sleep(500);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        }
    }
    
    public static void main(String[] args)
    {
        Thread t = new MyThread();
        System.out.println("NEW----" + t.getState());
        t.start();
        try
        {
            t.join();//主线程会等待t线程执行完毕才继续执行
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("TERMINATED----" + t.getState());
    }
}
