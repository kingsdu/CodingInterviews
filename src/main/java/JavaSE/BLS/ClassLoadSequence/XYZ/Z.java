package JavaSE.BLS.ClassLoadSequence.XYZ;

public class Z extends X
{
    Y y = new Y();
    
    public Z()
    {
        System.out.print("Z");
    }
    
    public static void main(String[] args)
    {
        new Z();
    }
}
