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
 * 4、数据范围有限时直接计数排序
 * <p>
 * <p>
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 */
public class Offer029_最小的k个数
{
    
    public static void main(String[] args)
    {
        int[] nums = {3, 3, 2, 1};
        int[] leastNumbers_2 = getLeastNumbers_3(nums, 2);
        
        for (int x :
                leastNumbers_2)
        {
            System.out.print(x + " ");
        }
    }
    
    
    public static int[] getLeastNumbers_1(int[] input, int k)
    {
        if (k == 0 || input.length == 0)
        {
            return new int[0];
        }
        quickSort(input, 0, input.length - 1);
        return Arrays.copyOf(input, k);
    }
    
    
    private static void quickSort(int[] arr, int l, int r)
    {
        if (l >= r) return;
        int i = l, j = r;
        while (i < j)
        {
            while (i < j && arr[j] >= arr[l]) j--;
            while (i < j && arr[i] <= arr[l]) i++;
            if (i < j) Offer000_Common.swap(arr, i, j);
        }
        Offer000_Common.swap(arr, i, l);
        quickSort(arr, l, i - 1);
        quickSort(arr, i + 1, r);
    }
    
    
    //需要改成大根堆
    public static int[] getLeastNumbers_2(int[] arr, int k)
    {
        if (k == 0 || arr.length == 0)
        {
            return new int[0];
        }
        
        Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int num : arr)
        {
            if (pq.size() < k)
            {
                pq.add(num);
            } else if (num < pq.peek())
            {
                pq.poll();
                pq.add(num);
            }
        }
        
        int[] res = new int[pq.size()];
        int idx = 0;
        for (int num : pq)
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
    public static int[] getLeastNumbers_3(int[] input, int k)
    {
        if (k == 0 || input.length == 0)
        {
            return new int[0];
        }
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int cnt = 0;
        for (int num : input)
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
    
    
    //方法使用的内存较大
    public static int[] getLeastNumbers_4(int[] input, int k)
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
