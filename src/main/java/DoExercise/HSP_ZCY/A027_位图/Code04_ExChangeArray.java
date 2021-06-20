package DoExercise.HSP_ZCY.A027_位图;

import java.util.Arrays;

/**
 * @Author: Du
 * @Date: 2021/6/18 14:32
 *
 * 不用第三个变量 交换2个数字
 *
 */
public class Code04_ExChangeArray
{
    public static void main(String[] args)
    {
        int[] arr = new int[]{1,2};
        swap(arr,0,0);
        Arrays.stream(arr).forEach(value -> System.out.print(value+" "));
    }
    
    //使用这个方法要注意，相同的下标异或会变成0
    public static void swap(int[] arr, int i, int j)
    {
        if(i == j) return;
        arr[i] = arr[i] ^ arr[j];// 3 ^ 1
        arr[j] = arr[i] ^ arr[j];// 3 ^ 1 ^ 1 = 3
        arr[i] = arr[i] ^ arr[j];// 3 ^ 1 ^ 3 = 1
    }
    
}
