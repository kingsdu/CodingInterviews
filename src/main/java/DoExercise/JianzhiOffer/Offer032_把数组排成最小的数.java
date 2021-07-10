package DoExercise.JianzhiOffer;


import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/submissions/
 * <p>
 * <p>
 * 1 如何才能实现题目要求？
 * 将数组中的数字排成最小数需要将每个数字按照字典序从小到大排序
 * 2 如何实现字典序？
 * （1）若拼接字符串 x + y > y + x ,则 x > y
 * （2）若 x + y < y + x ,则 x < y
 */
public class Offer032_把数组排成最小的数
{
    
    public static void main(String[] args)
    {
        int[] nums = {3, 30, 34, 5, 9};
        String s = minNumber(nums);
        System.out.println(s);
    }
    
    public static String minNumber(int[] nums)
    {
        if (nums.length == 0) return null;
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) str[i] = String.valueOf(nums[i]);
        quickSort(str, 0, str.length - 1);//需要-1，因为str从j开始移动
        StringBuilder res = new StringBuilder();
        for (String s : str) res.append(s);
        return res.toString();
    }
    
    private static void quickSort(String[] arr, int l, int r)
    {
        if (l >= r) return;
        int i = l, j = r;
        while (i < j)
        {
            while (i < j && (arr[j] + arr[l]).compareTo(arr[l] + arr[j]) >= 0) j--;
            while (i < j && (arr[i] + arr[l]).compareTo(arr[l] + arr[i]) <= 0) i++;
            if (i < j)
            {
                swap(arr, i, j);
            }
        }
        swap(arr, i, l);
        quickSort(arr, l, i - 1);
        quickSort(arr, i + 1, r);
    }
    
    private static void swap(String[] arr, int i, int j)
    {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    
    /**
     * 使用Java排序
     *
     * @param nums
     * @return
     */
    public static String minNumber1(int[] nums)
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
