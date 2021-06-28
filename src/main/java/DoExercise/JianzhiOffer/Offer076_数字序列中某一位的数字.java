package DoExercise.JianzhiOffer;

/**
 * @Author: Du
 * @Date: 2021/6/22 11:11
 * <p>
 * https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/
 */
public class Offer076_数字序列中某一位的数字
{
    public static void main(String[] args)
    {
        findNthDigit(10);
    }
    
    public static int findNthDigit(int n)
    {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count)
        {
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }
}
