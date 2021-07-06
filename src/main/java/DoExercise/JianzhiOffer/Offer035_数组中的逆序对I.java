package DoExercise.JianzhiOffer;


/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 */
public class Offer035_数组中的逆序对I
{
    
    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 0};
        int i = reversePairs_1(arr);
        System.out.println(i);
    }
    
    static int count;
    
    public static int reversePairs_1(int[] nums)
    {
        count = 0;
        merge_3(nums, 0, nums.length - 1);
        return count;
    }
    
    public static void merge_3(int[] nums, int left, int right)
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
     * 左侧子数组当前元素 > 右侧子数组当前元素 时
     * 左侧子数组当前元素至末尾元素 和 右侧子数组的当前元素 构成了若干个 逆序对
     *
     * @param arr
     * @param left
     * @param mid
     * @param right
     */
    public static void mergeSort_3(int[] arr, int left, int mid, int right)
    {
        int[] temArr = new int[right - left + 1];
        int index = 0;
        int i = left, j = mid + 1;
        while (i <= mid && j <= right)
        {
            if (arr[i] <= arr[j])
            {
                temArr[index++] = arr[i++];
            } else
            {
                temArr[index++] = arr[j++];
                count += mid - i + 1;
            }
        }
        while (i <= mid) temArr[index++] = arr[i++];
        while (j <= right) temArr[index++] = arr[j++];
        for (int k = 0; k < temArr.length; k++)
        {
            arr[k + left] = temArr[k];
        }
    }
}
