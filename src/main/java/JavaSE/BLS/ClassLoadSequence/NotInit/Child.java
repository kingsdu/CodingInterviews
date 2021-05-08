package JavaSE.BLS.ClassLoadSequence.NotInit;

public class Child extends Father
{
    static {
        System.out.println("Child init!");
    }
}
