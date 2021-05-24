package Integer;


import org.junit.Test;

import java.util.*;

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
    
    
    String str = new String("good");
    char[] ch = {'a', 'b', 'c'};
    
    Integer a;
    Integer b = a;
    
    @Test
    public void test0518()
    {
        String s1 = new String("xyz");
        String s2 = new String("xyz");
        Boolean b1 = s1.equals(s2);
        Boolean b2 = (s1 == s2);
        System.out.print(b1 + "" + b2);
    }
    
    public void change(String str, char ch[])
    {
        str = "test ok";
        ch[0] = 'g';
    }
    
    public static int val()
    {
        int num = 5;
        try
        {
            num = num / 0;
        } catch (Exception e)
        {
            num = 10;
        } finally
        {
            num = 15;
        }
        return num;
    }
    
    @Test
    public void test0522()
    {
        List Listlist1 = new ArrayList();
        Listlist1.add(0);
        List Listlist2 = Listlist1;
        System.out.println(Listlist1.get(0) instanceof Integer);
        System.out.println(Listlist2.get(0) instanceof Integer);
        
        float d = 100;
    }
    
}
