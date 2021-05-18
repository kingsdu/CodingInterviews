package DoExercise.Zuochengyun;

/**
 * 输入一个int类型的值N，构造一个长度为N的数组arr，并返回
 * 要求：
 * 对于任意的 i<k<j，都满足 arr[i]+arr[j]!=arr[k]*2
 *
 * 思路
 * 1、奇变换（i） + 偶变换(j) != 2 * (k);因为：奇数 + 偶数 一定等于奇数。
 * 2、i个奇数 和 j 个偶数拼起来依旧是 达标的
 */
public class Problem001_ArrConstruct
{
    
    public static void main(String[] args)
    {
        System.out.println(isValid(markNO(9)));
    }
    
    public static int[] markNO(int size)
    {
        if (size == 1)
        {
            return new int[]{1};
        }
        
        int half = (size + 1) / 2;//向上取整能够造出，奇数比偶数多一个
        int base[] = markNO(half);
        int res[] = new int[size];
        int index = 0;
        //每次将数组中第1个数做奇数处理，且奇数比偶数多一个
        for (; index < half; index++)
        {
            res[index] = base[index] * 2 + 1;
        }
        //每次将数组中第1个数做偶数处理
        for (int i = 0; index < size; index++, i++)
        {
            res[index] = base[i] * 2;
        }
        return res;
    }
    
    
    /**
     *
     * 验证方法
     *
     * @param arr
     * @return
     */
    public static boolean isValid(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                for (int k = j + 1; k < n; k++)
                {
                    if(arr[i] + arr[k] == arr[j] * 2){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    
    
}
