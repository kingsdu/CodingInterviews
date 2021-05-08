package JavaSE.BLS.ClassLoadSequence.NotInit;

public class Father
{
    static {
        System.out.println("Father init!");
    }
    
    public static int val = 100;
}
