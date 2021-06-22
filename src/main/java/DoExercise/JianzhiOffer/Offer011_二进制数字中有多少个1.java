package DoExercise.JianzhiOffer;

/**
 * 考点：二进制、位运算规律
 *
 * <p>
 * 题目：
 * 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 * <p>
 * 输入：10，输出：2
 * <p>
 * 1、该数32位二进制是什么意思？怎么转化？
 * 答案：其实没意思，就是表示一个二进制数，前面用0表示，一共32位
 *
 * https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 */
public class Offer011_二进制数字中有多少个1
{
    public static void main(String[] args)
    {
        System.out.println(numberOf1_1(200));
        System.out.println(numberOf1_2(-100));
        System.out.println(numberOf1_3(-100));
    }
    
    public static int numberOf1_1(int n)
    {
        int res = 0;
        while (n != 0)
        {
            res += n & 1;
            n = n >> 1;
        }
        return res;
    }
    
    
    public static int numberOf1_2(int n)
    {
        int res = 0;
        while (n != 0)
        {
            res++;
            n &= (n - 1);
        }
        return res;
    }
    
    
    public static int numberOf1_3(int n)
    {
        int res = 0;
        while (n != 0)
        {
            int r = n & ((~n) + 1);//最右侧的1
            res++;
            n ^= r;//无进位相加，消掉最右侧的1
        }
        return res;
    }
    
}
