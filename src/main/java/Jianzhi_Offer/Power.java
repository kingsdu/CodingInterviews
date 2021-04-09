package Jianzhi_Offer;

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
public class Power
{
    
    public double Power_1(double base, int exponent)
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
    
    
    /**
     *
     * 通过奇偶性，递归求值
     *
     * 当次方数为奇数时：
     * 求2^7=2^3*2=2^1^2*2
     * 当次方数为偶树时
     * 求2^8=2^4^2=2^2^2^2
     * @return
     */
    public double power_2Call(double base, int exponent)
    {
        //递归结束条件
        if (exponent == 0) return 1.0;
        
        double result = power_2Call(base, exponent / 2);
        if (exponent%2==1)
        {
            return result * result * base;
        } else
        {
            return result * result;
        }
    }
    
    
    public double power_2(double base, int exponent)
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
    
    
    public static void main(String[] args)
    {
        Power power = new Power();
        int base = 2, exponent = 3;
        double a = Math.pow(base, exponent);
        double b = power.Power_1(base, exponent);
        double c = power.power_2(base,exponent);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
    
}
