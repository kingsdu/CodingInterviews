package DoExercise.HSP_ZCY.A032_桶排序_计数_基数排序_不比较;

import java.util.Arrays;

/**
 * 计数排序也是一种桶排序
 * 所有的桶排序都需要对输入的数据类型进行限制
 * <p>
 * 比如计数排序需要限制输入数组的长度在2000内
 */
public class Code02_CountSort
{
    public static void countSort(int[] arr)
    {
        //找出数组中最大的数字，并new出这么大的数组
        if (arr == null || arr.length < 2) return;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) max = Math.max(max, arr[i]);
        int[] bucket = new int[max + 1];
        //计数排序
        for (int i = 0; i < arr.length; i++)
        {
            bucket[arr[i]]++;
        }
        int i = 0;
        for (int j = 0; j < bucket.length; j++)
        {
            while (bucket[j]-- > 0)
            {
                arr[i++] = j;
            }
        }
    }
    
    public static void comparator(int[] arr)
    {
        Arrays.sort(arr);
    }
    
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
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 150;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++)
        {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            countSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2))
            {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        countSort(arr);
        printArray(arr);
    }
    
}
