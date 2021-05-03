package JavaSE.BLS.String;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

/**
 *
 * 自动装箱
 *
 */
public class AutoPacking
{
    
    
    public static void main(String[] args)
    {
        AutoPacking a = new AutoPacking();
        a.hashMapTest();
//        a.DoubleEquals();
    }
    
    public void IntegerEquals(){
        Integer x = 128;
        Integer y = 128;
    
        System.out.println(x == y);//false
    }
    
    public void DoubleEquals(){
        Double x = 128.0;
        Double y = 128.0;
        
        System.out.println(x == y);
    }
    
    
    public void hashtableTest(){
        Hashtable<String,Integer> t = new Hashtable<>();
        t.put("",1);
        t.put("",2);
        t.put("",1);
        t.put("",1);
    }
    
    public void hashSetTest(){
        HashSet<String> t = new HashSet<>();
        t.add("");
        t.add("");
        t.add("");
        t.add("1");
    }
    
    public void hashMapTest(){
        HashMap<String,Integer> t = new HashMap<>();
        t.put("",1);
        t.put("",2);
        t.put("",1);
        t.put("",1);
    }
    
}
