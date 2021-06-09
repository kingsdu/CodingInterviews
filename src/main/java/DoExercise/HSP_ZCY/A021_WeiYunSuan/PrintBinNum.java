package DoExercise.HSP_ZCY.A021_WeiYunSuan;

/**
 * @Author: Du
 * @Date: 2021/6/9 12:18
 */
public class PrintBinNum
{
    
    public static void main(String[] args)
    {
        //        print(1);
        test05(10);
    }
    
    private static void test05(int N)
    {
        long ans = 0;
        long cur = 1;
        for (int i = 0; i <= N; i++)
        {
            cur = cur * i;
            ans += cur;
        }
        System.out.println(ans);
    }
    
    private static void test04()
    {
        int c = 0;
        int d = ~c + 1;//溢出位会被舍弃
    
        System.out.println(c);
        System.out.println(d);
    }
    
    private static void test03()
    {
        int c = Integer.MIN_VALUE;
        int d = ~c + 1;
        
        System.out.println(c);
        System.out.println(d);
    }
    
    private static void test02()
    {
        int c = 5;
        int d = ~c + 1;//负数 = 正数取反 + 1
    
        System.out.println(c);
        System.out.println(d);
    }
    
    private static void test01()
    {
        int a = Integer.MIN_VALUE;
        print(a);
        print(a >> 1);
        print(a >>> 1);//0来补位
    }
    
    private static void print(int num)
    {
        for (int i = 31; i >= 0; i--)
        {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }
    
}
