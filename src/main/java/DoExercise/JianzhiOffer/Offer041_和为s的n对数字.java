package DoExercise.JianzhiOffer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 *
 *
 */
public class Offer041_和为s的n对数字
{
    
    public static void main(String[] args)
    {
        int sum = 9;
        int[][] arr = findContinuousSequence_2(sum);
    
        for (int[] ints : arr)
        {
            for (int anInt : ints)
            {
                System.out.print(anInt+" ");
            }
        }
        
    }
    
    public static ArrayList<ArrayList<Integer>> findContinuousSequence_1(int sum)
    {
        ArrayList list = new ArrayList();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int i = 1, j = 2, total = 3;
        while (i < j)
        {
            if (total == sum)
            {
                for (int k = i; k <= j; k++)
                {
                    list.add(k);
                }
                res.add(list);
                list = new ArrayList<>();
            }
            
            if (total >= sum)
            {
                total -= i;
                i++;
            } else
            {
                j++;
                total += j;
            }
        }
        return res;
    }
    
    
    /**
     * 数组实现方式
     *
     * @param target
     * @return
     */
    public static int[][] findContinuousSequence_2(int target)
    {
        int i = 1, j = 2, sum = 3;
        List<int[]> res = new ArrayList<>();//list可以传一个数组对象
        
        while (i < j)
        {
            if (sum == target)
            {
                int tmp[] = new int[j - i + 1];
                for (int k = i; k <= j; k++)
                {
                    tmp[k - i] = k;
                }
                res.add(tmp);
            }
            
            if (sum < target)
            {
                j++;
                sum += j;
            } else
            {
                sum -= i;
                i++;
            }
        }
        /**
         *
         * 1、数组空间等于0时，将会动态的创建和集合size相同空间大小的数组，性能是最好的。
         * 2、数组空间大于0但是小于size时，会重新创建大小等于集合size的数组，此时会增加GC的负担。
         * 3、数组空间等于集合的size时，在普通情况下是没问题的，但是在高并发情况下，数组创建完成后，集合的size变大，此时影响跟第二条相同。
         * 4、数组空间大于集合的size时，一方面会造成空间浪费，另一方面会在使用数组时产生空指针的异常。因为多出来的空间会存入null
         *
         */
        return res.toArray(new int[0][]);
    }
}
