package DoExercise.JianzhiOffer;

import java.util.concurrent.atomic.AtomicInteger;

public class TestDay
{
    public static void main(String[] args)
    {
        t01();
    }
    
    private static void t01()
    {
    
        AtomicInteger a = new AtomicInteger(0);
        for (int i = 1; i < 100; i++)
        {
            a.addAndGet(i);
        }
        System.out.println(a.get());
    }
    
    
}
