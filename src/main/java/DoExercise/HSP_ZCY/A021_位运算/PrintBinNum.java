package DoExercise.HSP_ZCY.A021_位运算;

/**
 * @Author: Du
 * @Date: 2021/6/9 12:18
 */
public class PrintBinNum
{
    
    public static void main(String[] args)
    {
    
    }
    
    
    //0取反+1还是0，溢出位会被舍弃
    private static void maxZero()
    {
        int c = 0;//00000000000000000000000000000000
        int a = ~c;//11111111111111111111111111111111
        int d = ~c + 1;//溢出位会被舍弃
    
        print(c);
        print(a);
        print(d);
        System.out.println(c);
        System.out.println(a);
        System.out.println(d);
    }
    
    //Integer.MIN_VALUE 的相反数 +1 还是本身
    private static void negativeMax()
    {
        int c = Integer.MIN_VALUE;
        int a = ~c;
        int d = ~c + 1;
        
        print(c);
        print(a);
        print(d);
        System.out.println(c);
        System.out.println(a);
        System.out.println(d);
    }
    
    
    //一个数取反 + 1 ，负数变正数，正数变负数
    private static void negative()
    {
        int c = 5;
        int d = ~c + 1;//负数 = 正数取反 + 1
    
        print(c);
        print(d);
    }
    
    private static void move()
    {
        int a = 10;
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
