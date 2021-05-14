package DoExercise.JianzhiOffer;


import java.util.*;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。
 * 例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * <p>
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 * <p>
 * <p>
 * 求TopK的方法：
 * 1、用快速排序高效求解
 * 2、用大根堆和小根堆排序
 * 3、二叉搜索树解决 TopK 问题
 * 4、数据范围有限时直接计数排序：
 */
public class Offer029_GetLeastNumbers
{
    
    public static void main(String[] args)
    {
        int[] nums = {4, 5, 1, 6, 2, 7, 3, 8};
        Offer029_GetLeastNumbers of = new Offer029_GetLeastNumbers();
        int[] leastNumbers_2 = of.getLeastNumbers_2(nums, 4);
        
        for (int x :
                leastNumbers_2)
        {
            System.out.print(x + " ");
        }
    }
    
    /**
     * 自己写的，这种方法肯定不是面试的有效方法
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers_1(int[] arr, int k)
    {
        if (k > arr.length || k < 0)
        {
            return null;
        }
        
        int[] res = new int[k];
        Arrays.sort(arr);
        
        for (int i = 0; i < k; i++)
        {
            res[i] = arr[i];
        }
        return res;
    }
    
    
    /**
     * 快速排序实现（快速排序的活学活用）
     * 直接通过快排切分排好第 K 小的数（下标为 K-1），那么它左边的数就是比它小的另外 K-1 个数～
     *
     * @param input
     * @param k
     * @return
     */
    public int[] getLeastNumbers_2(int[] input, int k)
    {
        if (k == 0 || input.length == 0)
        {
            return new int[0];
        }
        // 最后一个参数表示我们要找的是下标为k-1的数
        return quickSearch(input, 0, input.length - 1, k - 1);
    }
    
    
    private int[] quickSearch(int[] nums, int lo, int hi, int k)
    {
        // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数；
        int j = partition(nums, lo, hi);
        if (j == k)
        {
            return Arrays.copyOf(nums, j + 1);
        }
        // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
        return j > k ? quickSearch(nums, lo, j - 1, k) : quickSearch(nums, j + 1, hi, k);
    }
    //int[] nums = {4, 5, 1, 6, 2, 7, 3, 8};
    // 快排切分，返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边。
    private int partition(int[] nums, int lo, int hi)
    {
        int v = nums[lo];
        int i = lo, j = hi + 1;
        while (true)
        {
            while (++i <= hi && nums[i] < v) ;
            while (--j >= lo && nums[j] > v) ;
            if (i >= j)
            {
                break;
            }
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
        nums[lo] = nums[j];
        nums[j] = v;
        return j;
    }
    
    /**
     * 堆排序（大根堆：前K个小）
     *
     * @param input
     * @param k
     * @return
     */
    public int[] getLeastNumbers_3(int[] input, int k)
    {
        if (k == 0 || input.length == 0)
        {
            return new int[0];
        }
        
        Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);//lambda表达式，默认是小根堆重写成大根堆
        for (int num :
                input)
        {
            if (pq.size() < k)
            {
                pq.offer(num);
            } else if (num < pq.peek())
            {
                pq.poll();
                pq.offer(num);
            }
        }
        
        int[] res = new int[pq.size()];
        int idx = 0;
        for (int num :
                pq)
        {
            res[idx++] = num;
        }
        return res;
    }
    
    
    /**
     * 二叉搜索树
     * 1、在TreeMap中维护K个元素，每个元素出现的次数为1；2
     * 2、判断剩下元素和TreeMap中维护K个元素最大元素的关系，如果 > 跳过；如果 < 则将该数字存入TreeMap中，并将出现次数+1；
     * 3、从前向后遍历map，取出前K个数
     */
    public int[] getLeastNumbers_4(int[] input, int k)
    {
        if (k == 0 || input.length == 0)
        {
            return new int[0];
        }
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int cnt = 0;
        for (int num :
                input)
        {
            if (cnt < k)
            {
                map.put(num, map.getOrDefault(num, 0) + 1);
                cnt++;
                continue;
            }
            //map中已经存在k个数了，取出最大的一个
            Map.Entry<Integer, Integer> entry = map.lastEntry();
            if (entry.getKey() > num)
            {
                map.put(num, map.getOrDefault(num, 0) + 1);
                if (entry.getValue() == 1)
                {
                    map.pollLastEntry();
                } else
                {
                    map.put(entry.getKey(), entry.getValue() - 1);
                }
            }
        }
        
        //返回前k个元素
        int[] res = new int[k];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry :
                map.entrySet())
        {
            int freq = entry.getValue();
            while (freq-- > 0)
            {
                res[idx++] = entry.getKey();
            }
        }
        return res;
    }
    
    
    /**
     * 直接计数排序
     * 1、新建一个数组，遍历数组，对每个数字其对应位置上的数的下标+1（counter[num]++;）
     * 2、从前向后遍历数组，取出前K个数
     *
     * @param input
     * @param k
     * @return
     */
    public int[] getLeastNumbers_5(int[] input, int k)
    {
        if (k < 0 || input.length == 0)
        {
            return new int[0];
        }
        
        int[] counter = new int[10001];
        for (int num :
                input)
        {
            counter[num]++;
        }
        
        int[] res = new int[k];
        int idx = 0;
        for (int i = 0; i < counter.length; i++)
        {
            while (counter[i]-- > 0 && idx < k)
            {
                res[idx++] = i;
            }
            if (idx == k) break;
        }
        
        return res;
    }
}
