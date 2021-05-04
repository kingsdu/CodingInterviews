package JianzhiOffer;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，
 * A为1.不能视为 14。
 * J为11，Q为12，K为13，
 * 大、小王为 0,可以看成任意数字。
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: True
 * <p>
 * 输入: [0,0,1,2,5]
 * 输出: True
 */
public class Offer045_IsStraight
{
    
    public static void main(String[] args)
    {
        int nums[] = {0, 3, 1, 6, 4};
        System.out.println(isStraight_1(nums));
    }
    
    
    /**
     * 自己的思路
     * 问题：考虑到了需要通过求数字间的差值，比较后确定是否有序，但是
     * 1、没考虑到乱序的影响，导致程序出错
     * 2、程序写的太冗余了，不够简化
     * <p>
     * 下面的方法2简单很多：
     * 1、排序后，0排除后，最大数 - 最小数 <= 4
     * 2、我的思路过多的关注0的影响了
     *
     * @param nums
     * @return
     */
    public static boolean isStraight_1(int[] nums)
    {
        if (null == nums || nums.length == 0)
        {
            return false;
        }
        Arrays.sort(nums);
        
        int zeros = 0, preValue = 0, sumDiff = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] > 13 || nums[i] < 0)
            {
                return false;
            }
            
            if (nums[i] == 0)
            {
                zeros++;
            } else
            {
                if (preValue == 0)
                {
                    preValue = nums[i];
                    continue;
                }
                sumDiff += Math.abs(preValue - nums[i]) - 1;
                preValue = nums[i];
            }
        }
        if (zeros == 4)
        {
            return true;
        } else if (zeros == 5)
        {
            return false;
        }
        
        if (sumDiff - zeros == 0) return true;
        return false;
    }
    
    
    public static boolean isStraight_2(int[] numbers)
    {
        if (numbers == null || numbers.length != 5) return false;
        Arrays.sort(numbers);
        int k = 0;
        for (int i = 0; i < numbers.length - 1; i++)
        {
            if (numbers[i] == 0)
            {
                k++;
            } else if (numbers[i] == numbers[i + 1])
            {
                return false;
            }
        }
        return numbers[4] - numbers[k] <= 4;
    }
    
    public static boolean isStraight_3(int[] numbers)
    {
        Set<Integer> set = new HashSet<>();
        int max = 0, min = 14;
        for (int x :
                numbers)
        {
            if (x == 0) continue;
            max = Math.max(max,x);
            min = Math.min(min,x);
            if(set.contains(x)) return false;
            set.add(x);
        }
        return max - min < 5;
    }
}
