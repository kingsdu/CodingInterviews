package DoExercise.JianzhiOffer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 *
 */
public class Offer040_数组中数字出现的次数I
{
    
    public static void main(String[] args)
    {
        int nums[] = {1, 2, 10, 4, 1, 4, 3, 3};
        Arrays.stream(singleNumber_2(nums)).forEach(e -> System.out.print(e + " "));
    }
    
    /**
     * 通过异或的特性实现法
     * <p>
     * 异或的特性
     *
     * @param nums
     * @return
     */
    public static int[] singleNumber_2(int nums[])
    {
        int x = 0, y, n = 0, m;
        for (int num : nums) n ^= num;
        m = n & (~n + 1);
        for (int num : nums)
        {
            if ((num & m) != 0) x ^= num;
        }
        y = n ^ x;
        return new int[]{x, y};
    }
    
    /**
     * K神教的方法
     *
     * @param nums
     * @return
     */
    public static int[] singleNumbers_1(int[] nums)
    {
        if (nums == null || 0 == nums.length)
        {
            return null;
        }
        
        int res[] = new int[2];
        int idx = 0;
        HashMap<Integer, Boolean> dic = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
        {
            dic.put(nums[i], !dic.containsKey(nums[i]));
        }
        
        for (Map.Entry<Integer, Boolean> entry :
                dic.entrySet())
        {
            if (entry.getValue())
            {
                res[idx] = entry.getKey();
                idx++;
            }
        }
        
        return res;
    }
    
    
}
