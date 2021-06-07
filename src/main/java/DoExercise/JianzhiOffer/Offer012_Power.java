package DoExercise.JianzhiOffer;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 * <p>
 * 输入：2,3
 * 输出：8.00000
 * <p>
 * 思路
 * 1、负数：一个数的负次方即为这个数的正次方的倒数。
 */
public class Offer012_Power
{
    public static void main(String[] args)
    {
        int base = 2, exponent = 4;
        double a = Math.pow(base, exponent);
        double b = Power_1(base, exponent);
        double c = power_2(base, exponent);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
    
    /**
     * K神的有效题解
     *
     * @param base
     * @param exponent
     * @return
     */
    public static double power(double base, int exponent)
    {
        if (base == 0) return 0;
        long b = exponent;//细节:当n=(-2)^31的时候，转成了正数(2)^31,超限了，所以此处要使用long
        double res = 1.0;
        if (b < 0)
        {
            exponent = 1 / exponent;
            exponent = Math.abs(exponent);
        }
        while (b > 0)
        {
            if ((b & 1) == 1)// b % 2 == 1
            {
                res *= exponent;
            }
            exponent *= exponent;
            b = b >> 1;//最后一位是1
        }
        return res;
    }
    
    public double myPow(double x, int n)
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
    
    
    public static double power_2(double base, int exponent)
    {
        //处理负数
        if (base < 0)
        {
            base = 1 / base;
            //n = -n可能会溢出，因为int表示范围[−2147483648,2147483647] ，因此当 n = -2147483648会报错，解决方法是把n存入long型变量，用long型变量计算
            exponent = Math.abs(exponent);
        }
        return power_2Call(base, exponent);
    }
    
    /**
     * 通过奇偶性，递归求值
     * <p>
     * 当次方数为奇数时：
     * 求
     * 2^7 = 2^3^2*2
     * 2^3 = 2^1^2*2
     * 2^1 = 2^0^2*2
     * 2^0 = 1.0
     * 递归返回
     * <p>
     * 当次方数为偶树时
     * <p>
     * 遇上类似，不需要多乘一个2
     *
     * @return
     */
    public static double power_2Call(double base, int exponent)
    {
        //递归结束条件
        if (exponent == 0) return 1.0;
        
        double result = power_2Call(base, exponent / 2);
        if (exponent % 2 == 1)
        {
            return result * result * base;//无论什么exponent最后都会进个方法
        } else
        {
            return result * result;
        }
    }
    
    /**
     * 这个方法不会是面试的答案
     * letcode 超出时间限制
     *
     * @param base
     * @param exponent
     * @return
     */
    public static double Power_1(double base, int exponent)
    {
        double result = 1.0;
        
        if (base == 0) return 0.0;
        if (exponent == 0) return 1;
        
        if (exponent < 0)
        {
            base = 1 / base;
        }
        
        for (int i = 0; i < Math.abs(exponent); i++)
        {
            result *= base;
        }
        return result;
    }
    
    
}
