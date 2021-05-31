package DoExercise.HSP_ZCY.A006_Sort;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 归并排序：时间复杂度：o(n log n)  空间复杂度：o(n)  稳定算法
 * <p>
 * 归并排序（MERGE-SORT）是利用归并的思想实现的排序方法，该算法采用经典的分治（divide-and-conquer）策略
 * （分治法将问题分(divide)成一些小的问题然后递归求解，而治(conquer)的阶段则将分的阶段得到的各答案"修补"在一起，即分而治之)。
 * <p>
 * https://www.cnblogs.com/chengxiao/p/6194356.html
 *
 * 99万个数字 耗时 1s
 */
public class A005_MergeSort
{
    
    public static void main(String[] args)
    {
//        int[] nums = {6, 3, 5, 4, 2, 1};
//        mergeSort_sort_1(nums, 0, nums.length - 1);
    
        SimpleDateFormat startTime = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        System.out.println("排序开始时间：" + startTime.format(new Date()));
        mergeSort_1_test();
        SimpleDateFormat endTime = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        System.out.println("排序结束时间：" + endTime.format(new Date()));
    }
    
    
    public static void mergeSort_sort_1(int[] nums, int left, int right)
    {
        int mid = left + ((right - left) >> 1);
        if (left < right)
        {
            mergeSort_sort_1(nums, left, mid);
            mergeSort_sort_1(nums, mid + 1, right);
            mergeSort_merge_1(nums, left, mid, right);
        }
    }
    
    public static void mergeSort_merge_1(int[] nums, int left, int mid, int right)
    {
        int[] tepArr = new int[right - left + 1];
        int index = 0;
        int temp1 = left, temp2 = mid + 1;
        
        while (temp1 <= mid && temp2 <= right)
        {
            if (nums[temp1] <= nums[temp2])
            {
                tepArr[index++] = nums[temp1++];
            } else
            {
                //用来统计逆序对的个数
                tepArr[index++] = nums[temp2++];
            }
        }
        //把左边剩余的数移入数组
        while (temp1 <= mid)
        {
            tepArr[index++] = nums[temp1++];
        }
        //把右边剩余的数移入数组
        while (temp2 <= right)
        {
            tepArr[index++] = nums[temp2++];
        }
        //把新数组中的数覆盖nums数组
        for (int k = 0; k < tepArr.length; k++)
        {
            nums[k + left] = tepArr[k];
        }
    }
    
    public static void mergeSort_1_test()
    {
        //测试80万个数据的排序
        int[] arrTest = new int[99999999];
        for (int index = 0; index < 99999999; index++)
        {
            arrTest[index] = (int) (Math.random() * 99999999);
        }
        //增量gap，并逐步缩小增量
        mergeSort_sort_1(arrTest,0,arrTest.length-1);
    }
    
}
