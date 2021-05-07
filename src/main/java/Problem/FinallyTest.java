package Problem;


/**
 *
 * 问题：
 *
 *
 * 为什么 bar()返回的是2，bar1() 返回的是1
 *
 */
public class FinallyTest
{
    public static void main(String[] args)
    {
        System.out.println(bar()[0]); //返回2，但是如果bar()中return x[0]返回的就是1，说明return只是拷贝了值到另外一块地方。
        System.out.println(bar1());
    }
    
    private static int[] bar()
    {
        int[] x = new int[2];
        x[0] = 1;
        try
        {
            return x;
        } finally
        {
            x[0] = 2;
        }
    }
    
    private static int bar1()
    {
        int[] x = new int[2];
        x[0] = 1;
        x[1] = 3;
        try
        {
            return x[0];
        } finally
        {
            x[0] = 2;
        }
    }
}
