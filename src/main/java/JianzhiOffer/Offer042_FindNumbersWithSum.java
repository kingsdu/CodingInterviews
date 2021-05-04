package JianzhiOffer;

/**
 *
 * 自己写的第一个和大神一样的算法
 *
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 * (1)如果有多对数字的和等于s，则输出任意一对即可。
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * <p>
 * (2)如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输入：[1,2,4,7,11,15],15
 * 输出：[4,11]
 *
 *
 */
public class Offer042_FindNumbersWithSum
{
    
    
    public static void main(String[] args)
    {
        Offer042_FindNumbersWithSum of = new Offer042_FindNumbersWithSum();
        int nums[] = {1,2,3,4,5,6,7,8,9,10};
        int target = 10;
        int[] ints = of.twoSum(nums, target);
        for (int x :
                ints)
        {
            System.out.println(x);
        }
    }
    
    /**
     * 问题2的解法
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target)
    {
        if (null == nums || nums.length == 0)
        {
            return new int[0];
        }
        
        int arr[] = new int[2];
        int i = 0, j = nums.length - 1, idx = -1;
        while (i <= j)
        {
            int mid = ((j - i) >> 1) + i;
            if (nums[mid] == target)
            {
                idx = mid;
                break;
            } else
            {
                if (nums[mid] > target)
                {
                    j = mid - 1;
                } else
                {
                    i = mid + 1;
                }
            }
        }
        
        if (idx == -1)
        {
            idx = j;
        }
        i = 0;
        j = idx;
        while (i < j)
        {
            int sum = nums[i] + nums[j];
            if (target == sum)
            {
                arr[0] = nums[i];
                arr[1] = nums[j];
                break;
            } else if (sum > target)
            {
                j--;
                i = 0;
            } else
            {
                i++;
            }
        }
        return arr;
    }
    
    
    
}
