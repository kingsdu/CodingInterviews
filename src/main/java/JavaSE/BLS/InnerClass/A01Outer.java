package JavaSE.BLS.InnerClass;

public class A01Outer
{
    private static String str = "外部类中的字符串";
    
    class Inner
    {
        private String inStr = "inner";
        public void print()
        {
            System.out.println(str);
        }
    }
    
    public void fun()
    {
        Inner in = new Inner();
        in.print();
    }
}
