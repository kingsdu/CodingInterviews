package JavaSE.MSB.Thread.C01_ThreadFirst;

//sleep yield join
public class T03_Sleep_Yield_Join
{
    public static void main(String[] args)
    {
//        testSleep();
        testYield();
//        testJoin();
    }
    
    static void testSleep()
    {
        new Thread(() ->
        {
            for (int i = 0; i < 100; i++)
            {
                System.out.println("A" + i);
                try
                {
                    Thread.sleep(500);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    
    //t1线程执行10次，让出执行权，t2如果抢到，执行10次再让出执行权
    static void testYield()
    {
        //t1
        new Thread(() ->
        {
            for (int i = 0; i < 100; i++)
            {
                System.out.println("A" + i);
                if (i % 10 == 0) Thread.yield();
            }
        }).start();
        //t2
        new Thread(() ->
        {
            for (int i = 0; i < 100; i++)
            {
                System.out.println("------------B" + i);
                if (i % 10 == 0) Thread.yield();
            }
        }).start();
    }
    
    
    // t2中执行了 t1.join(); t2线程会等待t1线程执行完毕才继续执行
    static void testJoin()
    {
        Thread t1 = new Thread(() ->
        {
            for (int i = 0; i < 20; i++)
            {
                System.out.println("t1--" + i);
                try
                {
                    Thread.sleep(100);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        });
        
        Thread t2 = new Thread(() ->
        {
            try
            {
                t1.join();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            for (int i = 0; i < 20; i++)
            {
                System.out.println("t2--" + i);
                try
                {
                    Thread.sleep(100);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        });
        
        t1.start();
        t2.start();
    }
}
