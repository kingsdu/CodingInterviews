package JianzhiOffer;


/**
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * <p>
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 * <p>
 * 输入：n = 12
 * 输出：5
 * <p>
 * 输入：n = 13
 * 输出：6
 *
 *
 * 思路：该题是找数学上的规律
 * 我自己用到的方法是，找出每个位子上1的个数，然后遍历累加。
 *
 */
public class Offer031_CountDigitOne
{
    
    
    public static void main(String[] args)
    {
        Offer031_CountDigitOne of = new Offer031_CountDigitOne();
        int i = of.countDigitOne_1(13);
        System.out.println(i);
    }
    
    /**
     *
     * 最简单的思路，这是我应该想到的办法。
     *
     * 计算每个数字中1的个数，后再对所有的数字循环累加
     *
     * @param n
     * @return
     */
    public int countDigitOne_1(int n)
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
    public int calOne(int n)
    {
        int count = 0;
        while (n > 0)
        {
            if (n % 10 == 1) count++;
            n /= 10;
        }
        return count;
    }
    
    
    /**
     *
     * 找数学规律
     *
     * cur = 0 res += high * digit
     * cur = 1 res += high * digit + low + 1
     * cur > 1 res += high * digit + digit
     *
     *
     * @param n
     * @return
     */
    public int countDigitOne_2(int n) {
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while(high != 0 || cur != 0) {
            if(cur == 0) res += high * digit;
            else if(cur == 1) res += high * digit + low + 1;
            else res += (high + 1) * digit;
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
    
}
