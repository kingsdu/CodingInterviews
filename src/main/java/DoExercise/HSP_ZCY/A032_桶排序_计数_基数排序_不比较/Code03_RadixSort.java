package DoExercise.HSP_ZCY.A032_桶排序_计数_基数排序_不比较;

import java.util.Arrays;

/**
 * 基数排序
 * 前提：正数且是十进制
 */
public class Code03_RadixSort
{
    public static void radixSort(int[] arr)
    {
        if (arr == null || arr.length < 2)
        {
            return;
        }
        radixSort(arr, 0, arr.length - 1, maxbits(arr));
    }
    
    //最大值有几位
    public static int maxbits(int[] arr)
    {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++)
        {
            max = Math.max(max, arr[i]);
        }
        int res = 0;
        while (max != 0)
        {
            res++;
            max /= 10;
        }
        return res;
    }
    
    public static void radixSort(int[] arr, int L, int R, int digit)
    {
        final int radix = 10;
        int i = 0, j = 0;
        int[] help = new int[R - L + 1];
        for (int d = 1; d <= digit; d++)
        {
            int[] count = new int[radix];
            //入桶操作
            for (i = L; i <= R; i++)
            {
                j = getDigit(arr[i], d);
                count[j]++;
            }
            //出桶操作
            for (i = 1; i < radix; i++)
            {
                count[i] = count[i] + count[i - 1];
            }
            for (i = R; i >= L; i--)
            {
                j = getDigit(arr[i], d);
                help[count[j] - 1] = arr[i];
                count[j]--;
            }
            //根据出桶顺序重新排序
            for (i = L, j = 0; i <= R; i++, j++)
            {
                arr[i] = help[j];
            }
        }
    }
    
    //确定一个数字从后向前对应的位数,d表示位数
    public static int getDigit(int x, int d)
    {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }
    
    
    // for test
    public static void comparator(int[] arr)
    {
        Arrays.sort(arr);
    }
    
    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue)
    {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = (int) ((maxValue + 1) * Math.random());
        }
        return arr;
    }
    
    // for test
    public static int[] copyArray(int[] arr)
    {
        if (arr == null)
        {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
        {
            res[i] = arr[i];
        }
        return res;
    }
    
    // for test
    public static boolean isEqual(int[] arr1, int[] arr2)
    {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null))
        {
            return false;
        }
        if (arr1 == null && arr2 == null)
        {
            return true;
        }
        if (arr1.length != arr2.length)
        {
            return false;
        }
        for (int i = 0; i < arr1.length; i++)
        {
            if (arr1[i] != arr2[i])
            {
                return false;
            }
        }
        return true;
    }
    
    // for test
    public static void printArray(int[] arr)
    {
        if (arr == null)
        {
            return;
        }
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    // for test
    public static void main(String[] args)
    {
//        int testTime = 500000;
//        int maxSize = 100;
//        int maxValue = 100000;
//        boolean succeed = true;
//        for (int i = 0; i < testTime; i++)
//        {
//            int[] arr1 = generateRandomArray(maxSize, maxValue);
//            int[] arr2 = copyArray(arr1);
//            radixSort(arr1);
//            comparator(arr2);
//            if (!isEqual(arr1, arr2))
//            {
//                succeed = false;
//                printArray(arr1);
//                printArray(arr2);
//                break;
//            }
//        }
//        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
//
//        int[] arr = generateRandomArray(maxSize, maxValue);
//        printArray(arr);
//        radixSort(arr);
//        printArray(arr);
        
    }
    
}
