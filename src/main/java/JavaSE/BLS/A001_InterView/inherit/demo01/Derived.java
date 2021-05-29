package JavaSE.BLS.A001_InterView.inherit.demo01;

public class Derived extends Base
{
    public void methodOne()
    {
        super.methodOne();
        System.out.print("C");
    }
    
    public void methodTwo()
    {
        super.methodTwo();
        System.out.print("D");
    }
    
    public static void main(String[] args)
    {
        Base b = new Derived();
        b.methodOne();
    }
}
