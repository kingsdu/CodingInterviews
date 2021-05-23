package JavaSE.BLS.InnerClass.InnerClassCall;

import JavaSE.BLS.InnerClass.InnerClassCall.Enclosingone.InsideOne;

public class InnerTest
{
    public static void main(String[] args)
    {
        Enclosingone eo = new Enclosingone();
        Enclosingone.InsideOne ei = eo.new InsideOne();
        InsideOne ei1 = eo.new InsideOne();
//        eo.InsideOne ei1 = eo.new InsideOne();//这种调用方式不对
    }
}
