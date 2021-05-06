package DataStruct.SortPackages;


/**
 * 归并排序
 */
public class MergeSort
{
    
    
    public static void main(String[] args)
    {
        MergeSort m = new MergeSort();
        int[] nums = {6, 3, 5, 4, 2, 1};
        int[] temp = new int[nums.length];
        m.merge_2(nums, 0, nums.length - 1);
        
        for (int i = 0; i < temp.length; i++)
        {
            System.out.print(temp[i] + " ");
        }
    }
    
    /**
     *
     * 归并排序
     *
     * 归并排序分为两个部分：
     * 1 分治 ：将一段数据不断分割到一个字段
     * 2 归并：分割为都只剩下一个数字时，就1V1的比较一个数字，并将排序结果存入到临时数组中。
     *
     * https://www.cnblogs.com/chengxiao/p/6194356.html
     *
     */
    /**
     * 分治
     */
    public void mergeSort_sort_1(int[] arr, int start, int end, int[] temp)
    {
        if (end < start)
        {
            return;
        }
        
        if (start < end)
        {
            int mid = start + ((end - start) >> 1);
            mergeSort_sort_1(arr, start, mid, temp);//左边归并排序，使得左子序列有序
            mergeSort_sort_1(arr, mid + 1, end, temp);
            mergeSort_merge_1(arr, start, mid, end, temp);//将两个有序子数组合并操作
        }
    }
    
    
    /**
     * 归并
     * 将两个已经有序的数组，提供逐一比较，归并至临时数组中。
     */
    public void mergeSort_merge_1(int[] arr, int start, int mid, int end, int[] temp)
    {
        int i = start;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= end)
        {
            if (arr[i] <= arr[j])
            {
                temp[t++] = arr[i++];
            } else
            {
                temp[t++] = arr[j++];
            }
        }
        
        /***
         *
         * 比较完毕后的填充
         *
         */
        while (i <= mid)
        {//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        
        while (j <= end)
        {//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        
        t = 0;
        /**
         *
         * 合并
         *
         */
        while (start <= end)
        {
            arr[start++] = temp[t++];
        }
    }
    
    
    public void merge_2(int[] nums, int left, int right)
    {
        int mid = left + ((right - left) >> 1);
        if (left < right)
        {
            merge_2(nums, left, mid);
            merge_2(nums, mid + 1, right);
            mergeSort_2(nums, left, mid, right);
        }
    }
    
    public void mergeSort_2(int[] nums, int left, int mid, int right)
    {
        int[] temparr = new int[right - left + 1];
        int index = 0;
        int temp1 = left, temp2 = mid + 1;
        
        while (temp1 <= mid && temp2 <= right)
        {
            if (nums[temp1] <= nums[temp2])
            {
                temparr[index++] = nums[temp1++];
            } else
            {
                //用来统计逆序对的个数
                temparr[index++] = nums[temp2++];
            }
        }
        //把左边剩余的数移入数组
        while (temp1 <= mid)
        {
            temparr[index++] = nums[temp1++];
        }
        //把右边剩余的数移入数组
        while (temp2 <= right)
        {
            temparr[index++] = nums[temp2++];
        }
        //把新数组中的数覆盖nums数组
        for (int k = 0; k < temparr.length; k++)
        {
            nums[k + left] = temparr[k];
        }
    }
    
}
