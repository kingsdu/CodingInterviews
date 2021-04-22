package JavaSE.BLS.Array;

import java.util.Arrays;

/**
 * 二分查找
 */
public class BinarySearch
{
    
    
    public static void main(String[] args)
    {
        int[] num = {2, 6, 13, 24, 35, 46, 57, 68, 79};
        BinarySearch bi = new BinarySearch();
        int i = bi.binarySearch_2(num, 81);
        System.out.println(i);
        //找到了返回下标值，没找到返回插入下标：-（1+low）
        int i1 = Arrays.binarySearch(num, 81);
        System.out.println(i1);
    }
    
    /**
     * 递归实现
     * 二分查找算法默认一般返回数组下标索引
     * 没找到返回-1
     *
     * @return
     */
    public int binarySearch_1(int[] num, int i, int j, int target)
    {
        
        int mid = (i + j) >> 1;
        
        if (target < num[mid])
        {
            return binarySearch_1(num, i, mid, target);
        } else if (target > num[mid])
        {
            return binarySearch_1(num, mid + 1, j, target);
        } else
        {
            return mid;
        }
    }
    
    
    /**
     *
     * 二分查找实现找到插入元素位置
     *
     * @param arr
     * @param target
     * @return
     */
    public int binarySearch_2(int[] arr, int target)
    {
        int mid, left,right;
        left = 0;
        right = arr.length - 1;
        while (left <= right)
        {
            mid = (right + left) >>> 1;
            if (arr[mid] < target)
            {
                left = mid + 1;
            } else if (arr[mid] > target)
            {
                right = mid - 1;
            } else
            {
                return mid;
            }
        }
        return left;
    }
    
    
}
