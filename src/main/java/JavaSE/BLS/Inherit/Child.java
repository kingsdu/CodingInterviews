package JavaSE.BLS.Inherit;

public class Child extends Parent
{

    public int a = 2;
    public static int b = 2;

    public Child(){
        System.out.println("child is created");
    }

    {
        System.out.println("child no static");
    }

    static{
        System.out.println("child static");
    }

    protected void method(){
        System.out.println("child method");
    }
}
