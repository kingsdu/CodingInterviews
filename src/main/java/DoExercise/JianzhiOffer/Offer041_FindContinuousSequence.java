package DoExercise.JianzhiOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * <p>
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]
 */
public class Offer041_FindContinuousSequence
{
    
    
    public static void main(String[] args)
    {
        Offer041_FindContinuousSequence of = new Offer041_FindContinuousSequence();
        /*
        int sum = 9;
        ArrayList<ArrayList<Integer>> arrayLists = of.findContinuousSequence_1(sum);
        for (ArrayList<Integer> number :
                arrayLists)
        {
            for (int x :
                    number)
            {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        */
        
        int sum = 9;
        int[][] continuousSequence_2 = of.findContinuousSequence_2(sum);
        System.out.println(continuousSequence_2.length);
    }
    
    
    /**
     * 使用窗口算法。
     * 我理解了这个算法：（1）当窗口不满足要求时，下标向右扩大边界；（2）当窗口满足这个条件时，下标向左缩小边界。
     * 但是程序还是没写出来。
     * 问题
     * 1、没有考虑初始状态，int i = 1, j = 2, total = 3;因为题目以及确定了数字的范围最少2个数字，前2个数字一定是 1和2
     *
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> findContinuousSequence_1(int sum)
    {
        ArrayList list = new ArrayList();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int i = 1, j = 2, total = 3;
        while (i < j)
        {   //当数字相等时，根据下标，记录下标内的数字
            if (total == sum)
            {
                for (int k = i; k <= j; k++)
                {
                    list.add(k);
                }
                res.add(list);
                list = new ArrayList<>();
            }
            //如果窗口内的数字 >= 目标数，代表窗口需要左移动（缩小），移出窗口的数字需要剪掉
            if (total >= sum)
            {
                total -= i;
                i++;
            } else //窗口内数字小于目标树，代表窗口需要右移动（扩大），移入窗口的数字需要加上
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
    public int[][] findContinuousSequence_2(int target)
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
                ++j;
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
