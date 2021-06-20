package DoExercise.JianzhiOffer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 * <p>
 * https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 */
public class Offer028_数组中出现次数超过一半的数字
{
    
    public static void main(String[] args)
    {
        int[] nums = {1, 4, 3, 6, 5, 2, 2, 2, 2, 2, 2};
        int i = majorityElement_1(nums);
        System.out.println(i);
    }
    
    public static int majorityElement_1(int[] nums)
    {
        int x = 0, votes = 0, count = 0;
        for (int num : nums)
        {
            if (votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        
//        return x;
        //上面已经计算出结果，下面可以加验证
        for (int num : nums)
        {
            if (num == x) count++;
        }
        return count > nums.length / 2 ? x : 0;
    }
    
    
    //O(n2)的时间复杂度
    public static int majorityElement_3(int[] nums)
    {
        Map<Integer, Integer> resMap = new HashMap<>();
        int mid = nums.length >> 1;
        for (int i = 0; i < nums.length; i++)
        {
            if (resMap.containsKey(nums[i]))
            {
                resMap.put(nums[i], resMap.get(nums[i]) + 1);
            } else
            {
                resMap.put(nums[i], 1);
            }
        }
        
        for (Map.Entry<Integer, Integer> entry :
                resMap.entrySet())
        {
            if (entry.getValue() > mid)
            {
                return entry.getKey();
            }
        }
        return 0;
    }
    
    //O(n2)的时间复杂度
    public static int majorityElement_2(int[] nums)
    {
        Arrays.sort(nums);
        int i = nums[nums.length >> 1];//中间这个数字一定是超过一半的数
        return IntStream.of(nums).filter(k -> k == i).count() > nums.length / 2 ? i : 0;
    }
}
