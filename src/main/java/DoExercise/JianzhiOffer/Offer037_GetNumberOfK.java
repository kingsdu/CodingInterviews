package DoExercise.JianzhiOffer;

/**
 * 统计一个数字在升序数组中出现的次数。
 * <p>
 * [1,2,3,3,3,3,4,5],3
 * 4
 */
public class Offer037_GetNumberOfK
{
    
    public static void main(String[] args)
    {
        Offer037_GetNumberOfK of = new Offer037_GetNumberOfK();
        int[] arr = {1, 2, 2, 2, 3, 4, 5, 6, 6, 7};
        int k = 2;
        int i = of.GetNumberOfK_2(arr, k);
        System.out.println(i);
    }
    
    /**
     * 统计一个数字在升序数组中出现的次数。
     *
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK_1(int[] array, int k)
    {
        int count = 0;
        if (array.length == 0 || array == null)
        {
            return count;
        }
        
        int index = binarySearch(array, 0, array.length - 1, k);
        if (index == -1)
        {
            return count;
        }
        
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
    
    
    public int binarySearch(int[] array, int left, int right, int k)
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
     * 大佬算法，高级！
     * <p>
     * 先用二分法找数字的右边界
     * <p>
     * 在二分法找左边界，注意else
     *
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK_2(int[] array, int k)
    {
        int count = 0;
        if (array.length == 0 || array == null)
        {
            return count;
        }
        
        int left = 0, right = array.length - 1;
        while (left <= right)
        {
            int mid = ((right - left) >> 1) + left;
            if (array[mid] <= k) left = mid + 1;
            else right = mid - 1;
        }
        int end = left;
        if (right > 0 && array[right] != k) return 0;
        left = 0;
        right = array.length - 1;
        while (left <= right)
        {
            int mid = ((right - left) >> 1) + left;
            if (array[mid] < k) left = mid + 1;
            else right = mid - 1;
        }
        
        int start = right;
        return end - start - 1;
    }
    
    
}
