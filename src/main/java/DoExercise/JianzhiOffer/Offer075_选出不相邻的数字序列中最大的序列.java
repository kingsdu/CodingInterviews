package DoExercise.JianzhiOffer;

/**
 * @Author: Du
 * @Date: 2021/6/21 10:38
 * <p>
 * <p>
 * 题目2：选出不相邻的数字序列中最大的序列。
 * 例：1 2 4 1 7 8 3
 * 则结果为 15 = 1 4 7 3
 * <p>
 * 这个题目要求是不相邻的数字，也可以用动态规划做
 */
public class Offer075_选出不相邻的数字序列中最大的序列
{
    
    
    public static int maxSubArrayNoSeries(int[] arr, boolean flag)
    {
        if (flag)
        {
            return recSelect_2(arr, arr.length - 1);
        } else
        {
            return noRecSelect(arr);
        }
        
    }
    
    
    /**
     * 递归：首先要考虑递归部分主体，再考虑递归出口。
     *
     * @param arr
     * @param i
     * @return
     */
    private static int recSelect_2(int[] arr, int i)
    {
        if (i == 0) return arr[0];
        else if (i == 1) return Math.max(arr[0], arr[1]);
        else
        {
            return Math.max(recSelect_2(arr, i - 2) + arr[i], recSelect_2(arr, i - 1));
        }
    }
    
    
    //求一堆数字中累加和最大的情况
    //
    private static int noRecSelect(int[] arr)
    {
        int[] opt = new int[arr.length];
        opt[0] = arr[0];
        opt[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++)
        {
            opt[i] = Math.max(opt[i - 2] + arr[i], opt[i - 1]);
        }
        return opt[opt.length - 1];
    }
    
}
