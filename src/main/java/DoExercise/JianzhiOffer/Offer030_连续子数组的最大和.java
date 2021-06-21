package DoExercise.JianzhiOffer;

/**
 * 这个题目进行了拓展，一共有3个题目都是动态规划相关的。
 * <p>
 * 动态规划核心是之前做的工作不再重复做，思路就是选与不选！
 * <p>
 * https://www.bilibili.com/video/BV12W411v7rd/?spm_id_from=333.788.recommend_more_video.-1
 */
public class Offer030_连续子数组的最大和
{
    
    
    public static void main(String[] args)
    {
        /**
         *
         * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
         * <p>
         * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
         * 输出: 6
         * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
         *
         */
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int i = maxSubArray(arr);
        System.out.println(i);
    }
    
    private static int maxSubArray(int[] arr)
    {
        int res = arr[0];
        for (int i = 1; i < arr.length; i++)
        {
            arr[i] += Math.max(arr[i - 1], 0);//只有>0的数，才开始算连续数字和，遇到i-1为负数，从0开始
            res = Math.max(arr[i], res);
        }
        return res;
    }
    
    
    public static int maxSubArray1(int[] nums)
    {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
        {
            //动态规划核心思想
            if (dp[i - 1] > 0)
            {
                dp[i] = dp[i - 1] + nums[i];
            } else
            {
                dp[i] = nums[i];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++)
        {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    
    
}
