package JavaSE.BLS.ClassLoadSequence.NotInit;

public class Constant
{
    static {
        System.out.println("Constant init");
    }
    
    public static final String HELLO = "HELLO";
}
