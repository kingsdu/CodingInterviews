package JavaSE.BLS.Inherit.Variable;

public class FatherV
{
    private int a;
    
    public int getA()
    {
        System.out.println("F getA");
        return a;
    }
    
    public void setA(int a)
    {
        System.out.println("F setA");
        this.a = a;
    }
}
