package DoExercise.JianzhiOffer;

/**
 * 统计一个数字在升序数组中出现的次数。
 * <p>
 * [1,2,3,3,3,3,4,5],3
 * 4
 * <p>
 * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 */
public class Offer037_在排序数组中查找数字I
{
    
    public static void main(String[] args)
    {
        int[] arr = {0, 2, 2, 2, 3, 3, 3, 5, 6, 6, 7};
        int k = 3;
        int i = search(arr, k);
        System.out.println(i);
    }
    
    
    public static int search(int[] nums, int target)
    {
        return helper(nums, target) - helper(nums, target - 1);
    }
    
    public static int helper(int[] nums, int tar)
    {
        int i = 0, j = nums.length - 1;
        while (i <= j)
        {
            int m = i + ((j - i) / 2);
            if (nums[m] <= tar) i = m + 1;
            else j = m - 1;
        }
        return i;
    }
    
    
    public static int search1(int[] nums, int target)
    {
        int l = 0, r = nums.length - 1;
        while (l <= r)
        {
            int m = l + ((r - l) >> 1);
            if (nums[m] < target)
            {
                l = m + 1;
            } else if (nums[m] > target)
            {
                r = m - 1;
            } else
            {
                if (nums[l] == nums[r])
                {
                    return r - l + 1;
                }
                if (nums[l] < target)
                {
                    l++;
                }
                if (nums[r] > target)
                {
                    r--;
                }
            }
        }
        return 0;
    }
    
    
    /**
     * 统计一个数字在升序数组中出现的次数。
     *
     * @param array
     * @param k
     * @return
     */
    public static int GetNumberOfK_1(int[] array, int k)
    {
        int count = 0;
        if (array.length == 0 || array == null)
        {
            return count;
        }
        
        int index = binarySearch(array, 0, array.length - 1, k);
        if (index == -1) return count;
        int temp = index;
        int target = array[temp];
        while (temp < array.length && array[temp] == target)
        {
            temp++;
        }
        temp--;
        while (temp >= 0 && array[temp] == target)
        {
            count++;
            temp--;
        }
        return count;
    }
    
    
    public static int binarySearch(int[] array, int left, int right, int k)
    {
        while (left <= right)
        {
            int mid = ((right - left) >> 1) + left;
            if (array[mid] == k)
            {
                return mid;
            } else
            {
                if (array[mid] < k)
                {
                    left = mid + 1;
                } else if (array[mid] > k)
                {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
    
    /**
     * @param array
     * @param k
     * @return
     */
    public static int GetNumberOfK_2(int[] array, int k)
    {
        int l = 0, r = array.length - 1;
        while (l <= r)
        {
            int m = l + ((r - l) >> 1);
            if (k >= array[m]) l = m + 1;
            else r = m - 1;
        }
        
        int end = l;
        if (r >= 0 && array[r] != k) return 0;
        l = 0;
        r = array.length - 1;
        while (l <= r)
        {
            int m = l + ((r - l) >> 1);
            if (k > array[m]) l = m + 1;
            else r = m - 1;
        }
        int start = r;
        return end - start - 1;
    }
    
    
}
