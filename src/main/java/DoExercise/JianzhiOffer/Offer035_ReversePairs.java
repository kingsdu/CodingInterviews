package DoExercise.JianzhiOffer;


/**
 * 困难：归并排序
 * <p>
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * <p>
 * 输入: [7,5,6,4]
 * 输出: 5
 * <p>
 * 输入：[1,2,3,4,5,6,7,0]
 * 输出：7
 *
 *
 * 思想
 * 左侧子数组当前元素 > 右侧子数组当前元素 时
 * 左侧子数组当前元素至末尾元素 和 右侧子数组的当前元素 构成了若干个 逆序对
 *
 */
public class Offer035_ReversePairs
{
    
    public static void main(String[] args)
    {
        Offer035_ReversePairs of = new Offer035_ReversePairs();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 0};
        int i = of.reversePairs_3(arr);
        System.out.println(i);
    }
    
    
    /**
     * 您的程序未能在规定时间内运行结束，请检查是否循环有错或算法复杂度过大。
     * <p>
     * 程序运行时间过长
     *
     * @param array
     * @return
     */
    public int ReversePairs_1(int[] array)
    {
        if (array == null || array.length == 0) return 0;
        int count = 0;
        for (int i = 0; i < array.length; i++)
        {
            int max = array[i];
            for (int j = i + 1; j < array.length; j++)
            {
                if (max > array[j])
                {
                    count++;
                }
            }
        }
        return count;
    }
    
    
    int[] nums, tmp;
    
    public int ReversePairs_2(int[] nums)
    {
        if (nums == null || nums.length == 0) return 0;
        this.nums = nums;
        tmp = new int[nums.length];
        return mergeSort_2(0, nums.length - 1);
    }
    
    private int mergeSort_2(int l, int r)
    {
        // 终止条件
        if (l >= r) return 0;
        // 递归划分
        int m = (l + r) / 2;
        int res = mergeSort_2(l, m) + mergeSort_2(m + 1, r);
        // 合并阶段
        int i = l, j = m + 1;
        for (int k = l; k <= r; k++)
            tmp[k] = nums[k];
        for (int k = l; k <= r; k++)
        {
            if (i == m + 1)
                nums[k] = tmp[j++];
            else if (j == r + 1 || tmp[i] <= tmp[j])
                nums[k] = tmp[i++];
            else
            {
                nums[k] = tmp[j++];
                res += m - i + 1; // 统计逆序对
            }
        }
        return res;
    }
    
    int count;
    
    public int reversePairs_3(int[] nums)
    {
        this.count = 0;
        merge_3(nums, 0, nums.length - 1);
        return count;
    }
    
    public void merge_3(int[] nums, int left, int right)
    {
        int mid = left + ((right - left) >> 1);
        if (left < right)
        {
            merge_3(nums, left, mid);
            merge_3(nums, mid + 1, right);
            mergeSort_3(nums, left, mid, right);
        }
    }
    
    /**
     *
     * 左侧子数组当前元素 > 右侧子数组当前元素 时
     * 左侧子数组当前元素至末尾元素 和 右侧子数组的当前元素 构成了若干个 逆序对
     *
     *
     * @param nums
     * @param left
     * @param mid
     * @param right
     */
    public void mergeSort_3(int[] nums, int left, int mid, int right)
    {
        int[] temArr = new int[right - left + 1];
        int index = 0;
        int temp1 = left, temp2 = mid + 1;
        //分解，逐个比较
        while (temp1 <= mid && temp2 <= right)
        {
            if (nums[temp1] <= nums[temp2])
            {
                temArr[index++] = nums[temp1++];
            } else
            {
                //用来统计逆序对的个数
                count += (mid - temp1 + 1);
                temArr[index++] = nums[temp2++];
            }
        }
        //把左边剩余的数移入数组
        while (temp1 <= mid)
        {
            temArr[index++] = nums[temp1++];
        }
        //把右边剩余的数移入数组
        while (temp2 <= right)
        {
            temArr[index++] = nums[temp2++];
        }
        //把新数组中的数覆盖nums数组
        for (int k = 0; k < temArr.length; k++)
        {
            nums[k + left] = temArr[k];
        }
    }
}
