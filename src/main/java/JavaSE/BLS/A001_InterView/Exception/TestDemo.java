package JavaSE.BLS.A001_InterView.Exception;

public class TestDemo
{
    public static String output = "";
    
    public static void foo(int i)
    {
        try
        {
            if (i == 1)
            {
                throw new Exception();
            }
        } catch (Exception e)
        {
            output += "2";
            return;
        } finally
        {
            output += "3";
        }
        output += "4";
    }
    
    public static void main(String[] args)
    {
        foo(0);
        foo(1);
        System.out.println(output);
        double d = 0x12345678;
        long a = 012;
        int c = 012;
        byte q = 127;
    }
}
