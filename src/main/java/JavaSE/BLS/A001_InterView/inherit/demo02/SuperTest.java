package JavaSE.BLS.A001_InterView.inherit.demo02;

import java.util.Date;

public class SuperTest extends Date
{
    private static final long serialVersionUID = 1L;
    
    private void test()
    {
        System.out.println(super.getClass().getName());
    }
    
    public static void main(String[] args)
    {
        new SuperTest().test();
    }
}
