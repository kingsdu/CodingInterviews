package DoExercise.HSP.Find;

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
        int i = bi.binarySearch_1(num, 0, num.length - 1, 13);
        System.out.println(i);
        //找到了返回下标值，没找到返回插入下标：-（1+low）
        int i1 = Arrays.binarySearch(num, 13);
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
        while (i <= j)
        {
            int mid = (i + j) / 2;
            if (num[mid] == target)
            {
                return mid;
            } else
            {
                if (num[mid] < target)
                {
                    i = mid + 1;
                } else if (num[mid] > target)
                {
                    j = mid - 1;
                }
            }
        }
        return -1;
    }
    
    
}
