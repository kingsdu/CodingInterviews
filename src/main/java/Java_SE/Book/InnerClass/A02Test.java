package Java_SE.Book.InnerClass;

public class A02Test
{
    public static void main(String[] args)
    {
        A02Outer out = new A02Outer();  //1.
        out.fun(); //2.A02Outer 和 A02Inner是相互独立的
   }
}
