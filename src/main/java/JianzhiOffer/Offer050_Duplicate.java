package JianzhiOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任一一个重复的数字。
 * 例如，如果输入长度为7的数组[2,3,1,0,2,5,3]，那么对应的输出是2或者3。存在不合法的输入的话输出-1
 * <p>
 * [2,3,1,0,2,5,3]
 * 2或3
 */
public class Offer050_Duplicate
{
    
    public static void main(String[] args)
    {
        int num[] = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findNumber1(num));
    }
    
    public static int findNumber1(int[] numbers)
    {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int x :
                numbers)
        {
            map.put(x, map.containsKey(x));
        }
        
        for (Map.Entry<Integer, Boolean> entry :
                map.entrySet())
        {
            if (entry.getValue() == true)
            {
                return entry.getKey();
            }
        }
        return -1;
    }
    
    
    public static int findNumber2(int[] numbers)
    {
        int[] res = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++)
        {
            res[numbers[i]]++;
            if (res[numbers[i]] == 2)
            {
                return numbers[i];
            }
        }
        return -1;
    }
    
}
