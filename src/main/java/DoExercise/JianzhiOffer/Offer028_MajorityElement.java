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
 */
public class Offer028_MajorityElement
{
    
    public static void main(String[] args)
    {
        int[] nums = {1, 4, 3, 6, 5, 2, 2, 2, 2, 2, 2};
        Offer028_MajorityElement of = new Offer028_MajorityElement();
        int i = of.majorityElement_2(nums);
        System.out.println(i);
    }
    
    
    /**
     * 自己想的使用map的键值对，程序通过，但是这应该不是面试的答案
     *
     * @param nums
     * @return
     */
    public int majorityElement_1(int[] nums)
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
    
    
    /**
     * 排序法
     *
     * @param nums
     * @return
     */
    public int majorityElement_2(int[] nums)
    {
        Arrays.sort(nums);
        int i = nums[nums.length >> 1];//中间这个数字一定是超过一半的数
        return IntStream.of(nums).filter(k -> k == i).count() > nums.length / 2 ? i : 0;
    }
    
    
    /**
     * 摩尔投票法
     *
     * @param nums
     * @return
     */
    public int majorityElement_3(int[] nums)
    {
        int win = 0, count = 0, vote = 0;
        
        for (int num :
                nums)
        {
            if (vote == 0)
            {
                win = num;
            } else
            {
                //vote = vote + (num == win ? 1 : -1);
                vote += num == win ? 1 : -1;
            }
        }
        //是否是存在大于一半的数
        for (int num :
                nums)
        {
            if (num == win)
            {
                count++;
            }
        }
        return count > nums.length >> 1 ? win : 0;
    }
    
}
