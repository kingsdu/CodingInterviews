package DoExercise.JianzhiOffer;

/**
 * @Author: Du
 * @Date: 2021/7/10 11:51
 * <p>
 * <p>
 * https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/
 */
public class Offer079_0到n一1中缺失的数字
{
    
    public static void main(String[] args)
    {
        int[] arr = {0, 1, 3, 4, 5};
        System.out.println(missingNumber(arr));
    }
    
    public static int missingNumber(int[] nums)
    {
        int i = 0, j = nums.length - 1;
        while (i <= j)
        {
            int m = (i + j) / 2;
            if (nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i;
    }
}
