package JavaSE.BLS.InnerClass;

/**
 * 内部类实现多继承
 */
public class A03Test
{
    /**
     * 内部类实现多继承，A03Outer通过内部类，既可以访问A03InnerA的父类，也可以访问A03InnerB的父类
     *
     * @param args
     */
    public static void main(String[] args)
    {
        A03Outer outter = new A03Outer();
        System.out.println(outter.name());
        System.out.println(outter.age());
    }
}
