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
        Hashtable<String,Integer> aa = new Hashtable<>();
        HashMap<String,Integer> bb = new HashMap<>();
        Properties p = new Properties();
        aa.put(null,11);
        bb.put(null,22);
    }
}
