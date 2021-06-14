package DoExercise.JianzhiOffer;

public class TestDay
{
    public static void main(String[] args)
    {
 
        t04();
    
    }
    
    private static void t06()
    {
        System.out.println(Integer.toBinaryString(7 ^ 4));
    }
    
    private static void t04()
    {
        boolean a = true;
        boolean b = false;
        System.out.println(a ^ b);//true
        a = false;
        b = true;
        System.out.println(a ^ b);//true
        a = false;
        b = false;
        System.out.println(a ^ b);//false
        a = true;
        b = true;
        System.out.println(a ^ b);//false
    }
    
    private static void t05()
    {
        boolean a = true;
        boolean b = false;
        System.out.println(a | b);
        a = false;
        b = true;
        System.out.println(a & b);
        a = false;
        b = false;
        System.out.println(a & b);
        a = true;
        b = true;
        System.out.println(a & b);
    }
    
    
    
    private static void t03()
    {
        System.out.println(Integer.toBinaryString(-4));
        System.out.println(Integer.toBinaryString(~-4));
        System.out.println(Integer.toBinaryString(~-4+1));
        System.out.println(Integer.toBinaryString(4));
    }
    
    
    private static void t01()
    {
        System.out.println(170 % 64);
        System.out.println(170 & 63);
        System.out.println(1 << 42);
        System.out.println(Math.pow(2, 10));
    }
    
    
    
    private static void t02()
    {
        System.out.println(Integer.toBinaryString(-2>>1));
        System.out.println(Integer.toBinaryString(2>>1));
        
        System.out.println(Integer.MIN_VALUE / -1);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        
        System.out.println(4 / -2);
        
    }
}
