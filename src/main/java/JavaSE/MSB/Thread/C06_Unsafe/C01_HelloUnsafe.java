package JavaSE.MSB.Thread.C06_Unsafe;

import sun.misc.Unsafe;

public class C01_HelloUnsafe
{
    static class M
    {
        private M()
        {
        }
        
        int i = 0;
    }
    
    public static void main(String[] args) throws InstantiationException
    {
        Unsafe unsafe = Unsafe.getUnsafe();//JDK8 是不允许使用该类的，要通过反射才能用，具体看02
        M m = (M) unsafe.allocateInstance(M.class);
        m.i = 9;
        System.out.println(m.i);
    }
}


