package DoExercise.JianzhiOffer;


/**
 *
 * https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/
 *
 */
public class Offer031_1到n整数中1出现的次数
{
    
    
    public static void main(String[] args)
    {
        System.out.println(calOne(112));
    }
   
    
    /**
     * 找数学规律
     * <p>
     * cur = 0 res += high * digit
     * cur = 1 res += high * digit + low + 1
     * cur > 1 res += high * digit + digit
     *
     * @param n
     * @return
     */
    public static int countDigitOne_2(int n)
    {
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while (high != 0 || cur != 0)
        {
            if (cur == 0) res += high * digit;
            else if (cur == 1) res += high * digit + low + 1;
            else res += (high + 1) * digit;
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
    
    
    
    /**
     * 最简单的思路，超出时间限制
     * <p>
     * 计算每个数字中1的个数，后再对所有的数字循环累加
     *
     * @param n
     * @return
     */
    public static int countDigitOne_1(int n)
    {
        if (n <= 0)
        {
            return 0;
        }
        
        int sum = 0;
        for (int i = 1; i <= n; i++)
        {
            sum += calOne(i);
        }
        return sum;
    }
    
    
    /**
     * 计算每个数字中1个个数
     *
     * @param n
     * @return
     */
    public static int calOne(int n)
    {
        int count = 0;
        while (n > 0)
        {
            if (n % 10 == 1) count++;
            n /= 10;
        }
        return count;
    }
    
}
