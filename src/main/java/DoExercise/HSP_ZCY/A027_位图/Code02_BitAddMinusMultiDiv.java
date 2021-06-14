package DoExercise.HSP_ZCY.A027_位图;

/**
 * @Author: Du
 * @Date: 2021/6/14 15:34
 * <p>
 * 测试链接：https://leetcode.com/problems/divide-two-integers
 *
 * 使用位运算实现 ➕➖✖➗
 * 全程不能用 ➕➖✖➗
 *
 *
 */
public class Code02_BitAddMinusMultiDiv
{
    /*
    a = 46 = 0010 1110
    b = 20 = 0001 0100
    
    ^ 的结果就是两个数无进位相加，也可以理解为相同取0不同取1
    1、求a和b的无进位相加
     a = 0010 1110
    ^b = 0001 0100
       = 0011 1010
    
    2、求进位信息
     a = 0010 1110
    &b = 0001 0100
         0000 0100  << 1
         0000 1000
    
    3、如果一直存在进位，就不断将上面 1和2的结果累加
    
    */
    public static int add(int a, int b)
    {
        int sum = a;
        while (b != 0)
        {
            sum = a ^ b;//无进位相加信息
            b = (a & b) << 1;//进位信息
            a = sum;
        }
        return sum;
    }
    

    //n的相反数 = ~n + 1
    public static int negNum(int n)
    {
        return add(~n, 1);
    }
    
    //a + b的相反数 = a - b
    public static int minus(int a, int b)
    {
        return add(a, negNum(b));
    }
    
    
    /*
    正负数都支持
    乘法的过程
     a = 0011 0111
    *b = 0011 1010
       = 0000 0000
        00110 1110
       000000 0000
      0011011 1000
    ....
     */
    public static int multi(int a, int b)
    {
        int res = 0;
        while (b != 0)
        {
            if ((b & 1) != 0)//末尾有1
            {
                res = add(res, a);//累加
            }
            //移位
            a <<= 1;
            b >>>= 1;//必须是无符号右移，因为负数会补1
        }
        return res;
    }
    
    public static boolean isNeg(int n)
    {
        return n < 0;
    }
    
    
    /*
    正负数都支持
    存在余数会向下取值
    除法流程如下：
    a = 0110 1100
    b = 0000 1100
    
    1 移动a到最接近b的位置，a>>3
    a = 0000 1100
    b = 0000 1100
    表明在结果中
        0000 1000 第三位上一定是1
    
    2 a = a - b<<3 : a = minus(a, b << i);
     a = 0110 1100
    -b = 0110 0000
    =a = 0000 1100
    
    3 移动a到最接近b的位置，b>>3
    a = 0000 1100
    b = 0000 1100
    表明在结果中
        0000 0100 第0位上一定是1
        
    4 a = a - b
    a = 0000 1100
    b = 0000 1100
    a == 0 结束
    
    5 所以 0110 1100 / 0000 1100 = 0000 1001（已计算器验证）
    
     */
    public static int div(int a, int b)
    {
        //负数变成正数
        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;
        int res = 0;
        //x > 0 从31位开始，但是默认是正数所以可以从30开始
        for (int i = 30; i >= 0; i = minus(i, 1))//从30 29 28....不断右移
        {   //当x突破了y
            if ((x >> i) >= y)//y左移可能会突破符号位，所以这里选择x右移
            {
                res |= (1 << i);//找到对应位置上是1
                x = minus(x, y << i);
            }
        }
        return isNeg(a) ^ isNeg(b) ? negNum(res) : res;//a 和 b 符号不相同，取负号返回，否则直接返回
    }
    
    //关于isNeg(a) ^ isNeg(b)
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
    
    /*
    系统最小值没法比转绝对值，分情况讨论
     */
    public static int divide(int a, int b)
    {
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE)
        {
            return 1;
        } else if (b == Integer.MIN_VALUE)
        {//向下取整变为0
            return 0;
        } else if (a == Integer.MIN_VALUE)
        {
            if (b == negNum(1))
            {//-1
                return Integer.MAX_VALUE;
            } else
            {   //补位
                //(a+1)/b = c
                //a-(b *c) = d
                //d/b = e
                //c+e = 结果
                int c = div(add(a, 1), b);//(a+1)
                return add(c, div(minus(a, multi(c, b)), b));
            }
        } else
        {
            return div(a, b);
        }
    }
    
}
