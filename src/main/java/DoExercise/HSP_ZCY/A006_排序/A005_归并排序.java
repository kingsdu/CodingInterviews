package DoExercise.HSP_ZCY.A006_排序;


import java.util.Arrays;

/**
 * 归并排序：时间复杂度：o(n log n)  空间复杂度：o(n)  稳定算法
 * <p>
 * 归并排序（MERGE-SORT）是利用归并的思想实现的排序方法，该算法采用经典的分治（divide-and-conquer）策略
 * （分治法将问题分(divide)成一些小的问题然后递归求解，而治(conquer)的阶段则将分的阶段得到的各答案"修补"在一起，即分而治之)。
 * <p>
 * https://www.cnblogs.com/chengxiao/p/6194356.html
 * <p>
 * 99万个数字 耗时 1s
 */
public class A005_归并排序
{
    
    public static void main(String[] args)
    {
        int[] nums1 = {6, 3, 5, 4, 2, 1};
        mergeSort_NoRecur(nums1);
        Arrays.stream(nums1).forEach(e -> System.out.print(e + " "));
//        int[] nums = {6, 3, 5, 4, 2, 1};
//        mergeSort_sort_1(nums, 0, nums.length - 1);
//        for (int num : nums)
//        {
//            System.out.print(num + " ");
//        }
//        SimpleDateFormat startTime = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
//        System.out.println("排序开始时间：" + startTime.format(new Date()));
//        mergeSort_1_test();
//        SimpleDateFormat endTime = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
//        System.out.println("排序结束时间：" + endTime.format(new Date()));
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
        int i = left, j = mid + 1;
        
        while (i <= mid && j <= right)
        {
            if (nums[i] <= nums[j])
            {
                tepArr[index++] = nums[i++];
            } else
            {
                tepArr[index++] = nums[j++];
            }
        }
        //把左边剩余的数移入数组
        while (i <= mid)
        {
            tepArr[index++] = nums[i++];
        }
        //把右边剩余的数移入数组
        while (j <= right)
        {
            tepArr[index++] = nums[j++];
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
        mergeSort_sort_1(arrTest, 0, arrTest.length - 1);
    }
    
    
    /**
     *
     * 追赶N次 追赶了logN次数
     * 所以时间复杂度是 N * logN
     *
     * @param arr
     */
    public static void mergeSort_NoRecur(int[] arr)
    {
        if (arr.length < 2 || arr == null) return;
        int N = arr.length;
        int step = 1;
        while (step < N)
        {
            int L = 0;//左组位置
            while (L < N)
            {
                int M = L + step - 1;//中组位置
                if (M >= N) break;
                int R = Math.min(M + step, N - 1);//右组位置
                mergeSort(arr, L, M, R);
                L = R + 1;
            }
            if (step > N / 2) break;
            step <<= 1;
        }
    }
    
    
    public static void mergeSort(int[] arr, int l, int m, int r)
    {
        int[] help = new int[r - l + 1];
        int x = 0;
        int i = l, j = m + 1;
        while (i <= m && j <= r) help[x++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        while (i <= m) help[x++] = arr[i++];
        while (j <= r) help[x++] = arr[j++];
        for (int k = 0; k < help.length; k++) arr[l + k] = help[k];
    }
    
}
