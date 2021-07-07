package DoExercise.JianzhiOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Du
 * @Date: 2021/7/4 14:08
 *
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
 */
public class Offer040_数组中数字出现的次数II
{
    
    public static void main(String[] args)
    {
        int[] arr = {9, 1, 7, 9, 7, 9, 7};
        System.out.println(singleNumber1(arr));
    }
    
    public static int singleNumber(int[] nums)
    {
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        for (int num : nums)
        {
            hashMap.put(num, !hashMap.containsKey(num));
        }
        
        for (Map.Entry<Integer, Boolean> entry : hashMap.entrySet())
        {
            if (entry.getValue())
            {
                return entry.getKey();
            }
        }
        return -1;
    }
    
    //统计每个数字二进制位上1的个数，累加，如果1个个数能被3整除，就代表出现了3次，剩下的就是出现1次的情况
    public static int singleNumber1(int[] nums)
    {
        int res = 0;
        for (int i = 0; i < 32; i++)
        {
            int oneCount = 0;
            for (int j = 0; j < nums.length; j++)
            {
                oneCount += (nums[j] >>> i) & 1;
            }
            if (oneCount % 3 == 1)
                res |= 1 << i;
        }
        return res;
    }
}
