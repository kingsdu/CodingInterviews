package JianzhiOffer;


import java.util.Arrays;

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * <p>
 * 输入: [10,2]
 * 输出: "102"
 * <p>
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 */
public class Offer32_MinNumber
{
    
    public static void main(String[] args)
    {
        int[] nums = {3, 30, 34, 5, 9};
        Offer32_MinNumber of = new Offer32_MinNumber();
        String s = of.minNumber_2(nums);
        System.out.println(s);
    }
    
    /**
     * 自己想的思路（题目理解错了）
     * 1、所有数字排序
     * 2、第一个数字如果是0，则和后面第一个非0的数字交换位置
     * 3、第一个数字如果不是0，直接返回结果。
     *
     * @param nums
     * @return
     */
    public String minNumber_1(int[] nums)
    {
        if (nums.length == 0)
        {
            return null;
        }
        
        String s = transArr2Str(nums);
        int[] arr = transArr2Num(s);
        Arrays.sort(arr);
        
        if (arr[0] != 0)
        {
            return transArr2Str(arr);
        }
        
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] == 0)
            {
                continue;
            } else
            {
                int tmp = arr[i];
                arr[i] = 0;
                arr[0] = tmp;
                break;
            }
        }
        return transArr2Str(arr);
    }
    
    public int[] transArr2Num(String s)
    {
        int[] res = new int[s.length()];
        for (int i = 0; i < s.length(); i++)
        {
            res[i] = Integer.parseInt(s.substring(i, i + 1));
        }
        return res;
    }
    
    
    public String transArr2Str(int[] num)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length; i++)
        {
            sb.append(num[i]);
        }
        return sb.toString();
    }
    
    
    /**
     * 方法2
     * <p>
     * 若拼接字符串 x + y > y + xx+y>y+x ，则 xx “大于” yy ；
     * 反之，若 x + y < y + xx+y<y+x ，则 xx “小于” yy ；
     */
    
    public String minNumber_2(int[] nums)
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
    
    private void quickSort(String[] arr, int left, int right)
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
    
    
    private int partition(String[] arr, int left, int right)
    {
        int i = left, j = right;
        String base = arr[i];
        
        while (true)
        {
            while ((arr[j] + base).compareTo(base + arr[j]) >= 0 && i < j){j--;}
            while ((arr[i] + base).compareTo(base + arr[i]) <= 0 && i < j){i++;}
            
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
    
}
