package JianzhiOffer;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestDay
{
    
    
    @Test
    public void findRepeatNumber()
    {
        int nums[] = new int[]{2, 3, 1, 0, 2, 5, 3,2};
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
        {
            map.put(nums[i], !map.containsKey(nums[i]));
        }
        
        for (Map.Entry<Integer, Boolean> entry : map.entrySet())
        {
            if (!entry.getValue())
            {
                System.out.println(entry.getKey());
            }
        }
    }
}
