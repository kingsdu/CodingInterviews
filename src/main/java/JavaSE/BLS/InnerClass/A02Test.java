package JavaSE.BLS.InnerClass;

public class A02Test
{
    /**
     *
     * 例子：外部类 和 内部类 是相互独立的
     *      内部类访问外部类的成员遍历
     * @param args
     */
    public static void main(String[] args)
    {
        A02Outer out = new A02Outer();  //1.
        out.fun(); //2.
   }
}
