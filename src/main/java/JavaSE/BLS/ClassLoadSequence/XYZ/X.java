package JavaSE.BLS.ClassLoadSequence.XYZ;

public class X
{
    Y y = new Y();//类方法，在类加载时调用
    
    public X()
    {
        System.out.print("X");
    }
}
