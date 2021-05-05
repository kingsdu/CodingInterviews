package JavaSE.BLS.Inherit.Variable;

public class VMain
{
    public static void main(String[] args)
    {
        ChildV c = new ChildV();
        FatherV f = c;
        f.setA(1);
        System.out.println(f.getA());
    }
}
