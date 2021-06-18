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
 */
public class Offer011_数字中有多少个1
{
    public static void main(String[] args)
    {
        System.out.println(numberOf1_1(200));
        System.out.println(numberOf1_2(-100));
        System.out.println(numberOf1_3(-100));
    }
    
    /**
     * 若 n&1=0 ，则 n 二进制 最右一位 为 0 ；
     * 若 n&1=1 ，则 n 二进制 最右一位 为 1 。
     * <p>
     * 使用这个算法，逻辑简单，但是效率不是最优的，因为算法对所有的二进制数末尾是0也要循环一次；
     * 可以看下面的算法2，不考虑后面的0
     *
     * @param n
     * @return
     */
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
    
    
    /**
     * 大神巧妙的思路：
     * 如果一个整数不为0，那么该整数的二进制位上至少有1个1。
     * 如果我们将这个整数-1，则原来处在最右边的1就会变为0，而原来1后面的0都会变成1(如果1后边还有0的话)。其余位数将不受影响。
     * 例如：1100-1=1011-1=1010-1=1001-1=1000
     * 这时如果我们如果在将原来的整数1100和减一后的整数1011做&运算，则从原来整数最右边一个1开始的所有位都会变成0。
     * 即 1100 & 1011 = 1000
     * 也就是说：把一个整数-1，在和这个整数本身做&操作，会将该整数右边的1变为0。这个整数有多少个1，就能进行多少次这样的操作。
     * <p>
     * 使用这个算法，对应的二进制数末尾要是有若干个0直接不考虑；
     *
     * @param n
     * @return
     */
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
            n ^= r;//消掉最右侧的1
        }
        return res;
    }
    
}
