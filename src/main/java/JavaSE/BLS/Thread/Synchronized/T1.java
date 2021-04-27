package JavaSE.BLS.Thread.Synchronized;

import org.openjdk.jol.info.ClassLayout;

public class T1
{
    
    private static Object o;
    
    public static void main(String[] args)
    {
        try
        {
            Thread.sleep(1000l);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        
        o = new Object();
        
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        
        synchronized (o){
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
        
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }
}
