package JianzhiOffer;

/**
 *
 * 题目：模拟计算机的加法运算
 *
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * <p>
 * 输入: a = 1, b = 1
 * 输出: 2
 * <p>
 * 输入: a = -1, b = -1
 * 输出: -2
 * <p>
 * 考点：计算机计算 两数之和的方式
 *
 * 1、在计算机系统中，数值一律用补码来表示和存储。补码的优势：加法、减法可以统一处理（CPU只有加法器）。
 * 2、^，异或，相同位取0，不同位取1，求进位。
 */
public class Offer048_AddNoOperator
{
    
    public static void main(String[] args)
    {
        System.out.println(add_1(-1, -1));
    }
    
    /**
     *
     * 先求进位部分，然后通过异或累加不同位数上的值
     * 当没有进位部分，即为运算结果
     *
     * @param a
     * @param b
     * @return
     */
    public static int add_1(int a, int b)
    {
        while (b != 0)
        {
            int c = (a & b) << 1;
            a ^= b;
            b = c;//有进位，继续算进位
        }
        return a;
    }
}
