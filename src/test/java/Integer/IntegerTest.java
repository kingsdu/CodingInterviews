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
        int a = 100, b = 50, c = a-- - b, d = a-- - b;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
    
    @Test
    public void test0525()
    {
        int x = -5;
        int y = -12;
        System.out.println(y % x);
    }
    
    @Test
    public void test0526_1()
    {
        int i = 5;
        int j = 10;
        System.out.println(~j);
        System.out.println(i + ~j);
    }
    
    @Test
    public void test0526_2()
    {
        Integer s = new Integer(9);
        Integer t = new Integer(9);
        Long u = new Long(9);

//        System.out.println(s == u );//编译报错
        
        System.out.println(s.equals(t));
        System.out.println(s.equals(9));
        System.out.println(s.equals(new Integer(9)));
    }
    
    @Test
    public void test0526_3()
    {
        String lx = "LeXin";
        String nb = lx;
        lx = "Fenqile";
        System.out.println(nb);
    }
    
    @Test
    public void test0526_4()
    {
        String str = "hello world";
        str += 'a';
        str += 100;
        
    }
    
    @Test
    public void test0528_1()
    {
        int x = 1, y = 2, z = 3;
        y += z-- / ++x;
        System.out.println(y);
        String aa = new String("vv");
        StringBuffer sb = new StringBuffer();
        sb.append(aa);
    }
    
    @Test
    public void test0530_1()
    {
    
    }
}
