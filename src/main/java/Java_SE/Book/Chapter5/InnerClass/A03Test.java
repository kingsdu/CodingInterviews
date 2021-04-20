package Java_SE.Book.Chapter5.InnerClass;
/**
 *
 * 内部类实现多继承
 *
 */
public class A03Test
{
    public static void main(String[] args)
    {//内部类实现多继承，A03Outer通过内部类，既可以访问A03InnerA的父类，也可以访问A03InnerB的父类
        A03Outer outter = new A03Outer();
        System.out.println(outter.name());
        System.out.println(outter.age());
    }
}
