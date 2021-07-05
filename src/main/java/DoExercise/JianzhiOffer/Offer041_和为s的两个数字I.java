package DoExercise.JianzhiOffer;

import java.util.Arrays;

/**
 * @Author: Du
 * @Date: 2021/7/5 10:11
 * <p>
 * https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 */
public class Offer041_和为s的两个数字I
{
    
    public static void main(String[] args)
    {
        int[] arr = {10, 26, 30, 31, 47, 60};
        Arrays.stream(twoSum(arr, 40)).forEach(e -> System.out.print(e + " "));
    }
    
    
    public static int[] twoSum(int[] nums, int target)
    {
        int i = 0, j = nums.length - 1;
        while (i < j)
        {
            if (nums[i] + nums[j] < target) i++;
            else if (nums[i] + nums[j] > target) j--;
            else return new int[]{nums[i], nums[j]};
        }
        return new int[0];
    }
    
}
