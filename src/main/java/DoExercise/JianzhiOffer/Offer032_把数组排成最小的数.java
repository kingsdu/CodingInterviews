package DoExercise.JianzhiOffer;


import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/submissions/
 */
public class Offer032_把数组排成最小的数
{
    
    public static void main(String[] args)
    {
        int[] nums = {3, 30, 34, 5, 9};
        String s = minNumber_2(nums);
        System.out.println(s);
    }
    
    /**
     * 方法2
     * <p>
     * 若拼接字符串 x + y > y + xx+y>y+x ，则 xx “大于” yy ；
     * 反之，若 x + y < y + xx+y<y+x ，则 xx “小于” yy ；
     */
    
    public static String minNumber_2(int[] nums)
    {
        if (nums.length == 0)
        {
            return null;
        }
        
        String[] str = new String[nums.length];
        
        for (int i = 0; i < nums.length; i++)
        {
            str[i] = String.valueOf(nums[i]);
        }
        
        quickSort(str, 0, str.length - 1);//需要-1，因为str从j开始移动
        
        StringBuilder res = new StringBuilder();
        for (String s : str)
            res.append(s);
        return res.toString();
    }
    
    private static void quickSort(String[] arr, int left, int right)
    {
        if (left >= right)
        {
            return;
        } else
        {
            int index = partition(arr, left, right);
            quickSort(arr, left, index - 1);
            quickSort(arr, index + 1, right);
        }
        
    }
    
    
    private static int partition(String[] arr, int left, int right)
    {
        int i = left, j = right;
        String base = arr[i];
        
        while (true)
        {
            while ((arr[j] + base).compareTo(base + arr[j]) >= 0 && i < j)
            {
                j--;
            }
            while ((arr[i] + base).compareTo(base + arr[i]) <= 0 && i < j)
            {
                i++;
            }
            
            if (i >= j)
            {
                break;
            }
            
            String tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        
        arr[left] = arr[i];
        arr[i] = base;
        return i;
    }
    
    
    /**
     * 使用Java排序
     *
     * @param nums
     * @return
     */
    public static String minNumber_3(int[] nums)
    {
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            str[i] = String.valueOf(nums[i]);
        Arrays.sort(str, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for (String s : str)
            res.append(s);
        return res.toString();
    }
    
}
