package DoExercise.HSP_ZCY.A027_位图;

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
        int[] arr = {3, 1};
        swap(arr, 0, 1);
        System.out.println(arr[0]);
        System.out.println(arr[1]);
    }
    public static void swap(int[] arr, int i, int j)
    {
        arr[i] = arr[i] ^ arr[j];// 3 ^ 1
        arr[j] = arr[i] ^ arr[j];// 3 ^ 1 ^ 1 = 3
        arr[i] = arr[i] ^ arr[j];// 3 ^ 1 ^ 3 = 1
    }
    
}
