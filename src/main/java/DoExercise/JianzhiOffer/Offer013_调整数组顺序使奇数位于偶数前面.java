package DoExercise.JianzhiOffer;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * <p>
 * 输入 [1,2,3,4]
 * 输出 [1,3,2,4]
 * <p>
 * https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 */
public class Offer013_调整数组顺序使奇数位于偶数前面
{
    
    public static void main(String[] args)
    {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        for (int i : exchange(array))
        {
            System.out.print(i + " ");
        }
    }
    
    public static int[] exchange(int[] nums)
    {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    
    public static void quickSort(int[] nums, int l, int r)
    {
        if (l >= r) return;
        int i = l, j = r;
        while (i < j)
        {
            while (i < j && (nums[i] & 1) == 1) i++;
            while (i < j && (nums[j] & 1) == 0) j--;
            Offer000_Common.swap(nums, i, j);
        }
    }
    
    
}
