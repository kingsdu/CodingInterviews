package Integer;


import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Properties;

public class IntegerTest
{
    
    @Test
    public void IntegerChar()
    {
        Integer a = 128;
        int b = 128;
        System.out.println(a == b);
    }
    
    @Test
    public void test0513()
    {
        Hashtable<String, Integer> aa = new Hashtable<>();
        HashMap<String, Integer> bb = new HashMap<>();
        Properties p = new Properties();
        aa.put(null, 11);
        bb.put(null, 22);
    }
    
    
    @Test
    public void test0517()
    {
        Thread[] ths = new Thread[3];
        
        for (int i = 0; i < 3; i++)
        {
            ths[i] = new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    for (int j = 0; j < 5; j++)
                    {
                        System.out.print(j);
                    }
                    System.out.print("*");
                }
            });
        }
        
        for (Thread th :
                ths)
        {
            th.start();
        }
    }
    
    public boolean isAdmin(String userId)
    {
        return userId.toLowerCase() == "admin";
    }
}
