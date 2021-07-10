package DoExercise.JianzhiOffer;

import java.util.Arrays;

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 * (1)如果有多对数字的和等于s，则输出任意一对即可。
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * <p>
 * (2)如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输入：[1,2,4,7,11,15],15
 * 输出：[4,11]
 * <p>
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 */
public class Offer042_和为s的1对数字
{
    
    
    public static void main(String[] args)
    {
        int nums[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 10;
        int[] ints = twoSum(nums, target);
        Arrays.stream(ints).forEach(e -> System.out.print(e + " "));
    }
    
    /**
     * 问题2的解法
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target)
    {
        int i = 0, j = nums.length - 1;
        while (i < j)
        {
            if (nums[i] + nums[j] == target)
            {
                return new int[]{nums[i], nums[j]};
            } else if (nums[i] + nums[j] < target)
            {
                i++;
            } else
            {
                j--;
            }
        }
        return new int[0];
    }
    
    
}
