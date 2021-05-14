package DoExercise.JianzhiOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * <p>
 * 要求时间复杂度是O(n)，空间复杂度是O(1)。
 * <p>
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * <p>
 * <p>
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *
 *
 */
public class Offer040_SingleNumbers
{
    
    public static void main(String[] args)
    {
        Offer040_SingleNumbers of = new Offer040_SingleNumbers();
        int nums[] = {1, 2, 10, 4, 1, 4, 3, 3};
        int[] ints = of.singleNumber_2(nums);
        
        for (int i = 0; i < ints.length; i++)
        {
            System.out.print(ints[i]);
        }
    }
    
    
    /**
     * K神教的方法
     *
     * @param nums
     * @return
     */
    public int[] singleNumbers_1(int[] nums)
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
    
    
    /**
     * 通过异或的特性实现法
     * <p>
     * 异或的特性
     *
     * @param nums
     * @return
     */
    public int[] singleNumber_2(int nums[])
    {
        int x = 0, y = 0, n = 0, m = 1;
        /**
         * 异或运算有个重要的性质，两个相同数字异或为 0
         * 故，所有的数字，经过抵消后剩下的值n，就是2个出现过1次的数字的异或值
         */
        for (int num :
                nums)
        {
            n ^= num;
        }
        /**
         *
         * 对n，找到2个数异或值的不同点m
         *
         */
        while ((n & m) == 0)
        {
            m <<= 1;
        }
        /**
         *
         * 找到后，根据m将两个数字分配到不同的x和y中
         * 再求异或，其他出现多次的都抵消后，x,y中剩下的字符就是两个出现过一次的字符
         */
        for (int num :
                nums)
        {
            if ((num & m) != 0)
            {
                x ^= num;
            } else
            {
                y ^= num;
            }
        }
        
        return new int[]{x, y};
    }
    
}
