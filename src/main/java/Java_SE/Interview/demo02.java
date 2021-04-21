package Java_SE.Interview;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class demo02
{
    
    enum Num {ONE, THREE, TWO}
    public static void main(String[] args)
    {
        Collection coll = new LinkedList();
        coll.add(Num.ONE);
        coll.add(Num.THREE);
        coll.add(Num.ONE);
        coll.add(Num.ONE);
        coll.add(Num.THREE);
        coll.add(Num.TWO);
        coll.add(Num.TWO);
        coll.add(Num.TWO);
        coll.add(Num.THREE);
        Set set = new HashSet(coll);
        System.out.println(set);
        
 
    }
    
    
     public static native int meo();
}
