package JianzhiOffer;

/**
 * 这个题目进行了拓展，一共有3个题目都是动态规划相关的。
 * <p>
 * 动态规划核心是之前做的工作不再重复做，思路就是选与不选！
 * <p>
 * https://www.bilibili.com/video/BV12W411v7rd/?spm_id_from=333.788.recommend_more_video.-1
 */
public class Offer030_MaxSubArray
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
        int[] arr1 = {2, 8, 1, 5, 9};
        Offer030_MaxSubArray o = new Offer030_MaxSubArray();
        int i = o.maxSubArray_2(arr1);
        System.out.println(i);
        
        /**
         * 题目2：选出不相邻的数字序列中最大的序列。
         * */
        int[] arr2 = {1, 2, 4, 1, 7, 8, 3};
        int s = o.maxSubArrayNoSeries(arr2, false);
        System.out.println(s);
        
        /**
         *
         * 题目3：在给出的数组中，找出是否存在和为X的数字，返回true or false
         *
         * 例如：int[] arr = {3, 34, 4, 12, 5, 2};
         * int x = 9
         * 输出 ： true
         *
         * int x = 13
         * 输出 ： false
         */
        int[] arr3 = {3, 34, 4, 12, 5, 2};
        int x = 13;
        boolean b = o.recSubset_3(arr3, arr3.length - 1, x);
        System.out.println(b == true ? "true" : "false");
    }
    
    
    /**
     * 自己写的代码；思考速度慢、程序运行时间长。
     * 思路：
     * 1、逐个遍历，从1位数字开始，到数组最大长度的数字，逐步累加位数
     *
     * @param nums
     * @return
     */
    public int maxSubArray_1(int[] nums)
    {
        if (nums.length <= 0) return Integer.MIN_VALUE;
        if (nums.length == 1) return nums[0];
        int max = Integer.MIN_VALUE, k = 1;
        
        while (k <= nums.length)//此处注意 k == nums.length 这种情况
        {
            for (int i = 0; i < nums.length; i++)
            {
                int tmp = 0;
                for (int j = i; j < nums.length && j < i + k; j++)
                {
                    tmp += nums[j];
                }
                if (max < tmp) max = tmp;
            }
            k++;
        }
        return max;
    }
    
    /**
     * 动态规划算法
     * <p>
     * 以某个数作为结尾，意思就是这个数一定会加上去，那么要看的就是这个数前面的部分要不要加上去。大于零就加，小于零就舍弃。
     *
     * @param nums
     * @return
     */
    public int maxSubArray_2(int[] nums)
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
    
    
    /**
     * 新题目
     * 题目2：选出不相邻的数字序列中最大的序列。
     * 例：1 2 4 1 7 8 3
     * 则结果为 15 = 1 4 7 3
     * <p>
     * 这个题目要求是不相邻的数字，也可以用动态规划做
     *
     * @param arr
     * @param flag
     * @return
     */
    public int maxSubArrayNoSeries(int[] arr, boolean flag)
    {
        if (flag)
        {
            return recSelect_2(arr, arr.length - 1);
        } else
        {
            return noRecSelect_2(arr);
        }
        
    }
    
    
    /**
     *
     * 递归：首先要考虑递归部分主体，再考虑递归出口。
     *
     * @param arr
     * @param i
     * @return
     */
    private int recSelect_2(int[] arr, int i)
    {
        if (i == 0) return arr[0];
        else if (i == 1) return Math.max(arr[0], arr[1]);
        else
        {
            return Math.max(recSelect_2(arr, i - 2) + arr[i], recSelect_2(arr, i - 1));
        }
    }
    
    /**
     *
     * 明显的动态规划的思想的体现
     *
     * 一步一步的向上做选择
     *
     * @param arr
     * @return
     */
    private int noRecSelect_2(int[] arr)
    {
        int[] opt = new int[arr.length];
        opt[0] = arr[0];
        opt[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++)
        {
            opt[i] = Math.max(opt[i - 2] + arr[i], opt[i - 1]);
        }
        return opt[opt.length - 1];
    }
    
    
    /**
     * 题目3：在给出的数组中，找出是否存在和为X的数字，返回true or false
     * <p>
     * 例如：int[] arr = {3,34,4,12,5,2};
     * int x = 9
     * 输出 ： true
     * <p>
     * int x = 13
     * 输出 ： false
     */
    public boolean recSubset_3(int[] arr, int i, int s)
    {
        if (s == 0) return true;
        else if (i == 0) return arr[0] == s;
        else if (arr[i] > s) return recSubset_3(arr, i - 1, s);
        else
        {
            return recSubset_3(arr, i - 1, s - arr[i]) || recSubset_3(arr, i - 1, s);
        }
    }
    
    
}
