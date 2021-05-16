package DoExercise.JianzhiOffer;


import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 滑动窗口的最大值
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7        3
 * 1  3 [-1  -3  5] 3  6  7        5
 * 1  3  -1 [-3  5  3] 6  7        5
 * 1  3  -1  -3 [5  3  6] 7        6
 * 1  3  -1  -3  5 [3  6  7]       7
 */
public class Offer064_MaxSlidingWindow
{
    
    public static void main(String[] args)
    {
        int nums[] = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] ints = maxSlidingWindow2(nums, 3);
        Arrays.stream(ints).forEach(e -> System.out.print(e + " "));
    }
    
    
    public static int[] maxSlidingWindow1(int[] nums, int k)
    {
        if (nums.length == 0 || nums == null || k < 1)
        {
            return new int[0];
        }
        
        int arr[] = new int[nums.length - k + 1];
        int i = 0;
        while (k <= nums.length)
        {
            arr[i] = getMax(Arrays.copyOfRange(nums, i, k));
            i++;
            k++;
        }
        return arr;
    }
    
    
    public static int getMax(int[] nums)
    {
        Arrays.sort(nums);
        return nums[nums.length - 1];
    }
    
    
    /**
     *
     * deque的first始终存的是最大值
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow2(int[] nums, int k)
    {
        if (nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int j = 0, i = 1 - k; j < nums.length; i++, j++)
        {
            // 删除 deque 中对应的 nums[i-1]，让窗口往前移动，窗口范围始终保持在K个
            if (i > 0 && deque.peekFirst() == nums[i - 1])
                deque.removeFirst();
            // 保持 deque 递减
            while (!deque.isEmpty() && deque.peekLast() < nums[j])
                deque.removeLast();
            deque.addLast(nums[j]);
            // 记录窗口最大值
            if (i >= 0)
                res[i] = deque.peekFirst();
        }
        return res;
    }
}
