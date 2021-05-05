package JavaSE.BLS.Inherit.Variable;

public class ChildV extends FatherV
{
    private int a;
    
    @Override
    public int getA()
    {
        System.out.println("C setA");
        return a;
    }
    
    @Override
    public void setA(int a)
    {
        System.out.println("C getA");
        this.a = a;
    }
}
