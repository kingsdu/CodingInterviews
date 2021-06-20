package DoExercise.JianzhiOffer;

/**
 * 重点
 * 1、负数：一个数的负次方即为这个数的正次方的倒数。
 * 2、快速次幂，要二分，O(long2n)
 * 3、细节：-Integer 比 Integer 多一位
 * https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 *
 */
public class Offer012_数值的整数次方
{
    public static void main(String[] args)
    {
        int base = 2, exponent = -4;
        double a = Math.pow(base, exponent);
        double b = myPow(base, exponent);
        System.out.println(a);
        System.out.println(b);
    }
    
    public static double myPow(double x, int n)
    {
        if (x == 0) return 0;
        long b = n;
        double res = 1.0;
        if (b < 0)
        {
            x = 1 / x;
            b = -b;
        }
        while (b > 0)
        {
            if ((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
