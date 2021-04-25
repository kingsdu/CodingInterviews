package JavaSE.BLS.InnerClass.PartInnerClass;

public class A02_Outer
{
    int num = 3;

    public class Inner extends A02_AbsDemo
    {
        public void show()
        {
            System.out.println("outer num=" + num);
        }
    }
    
    //此处的 A02_AbsDemo 是 多态，外界不用知道内部类的细节
    public A02_AbsDemo getInner(){
        return new Inner();
    }
}
