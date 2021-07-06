package DoExercise.JianzhiOffer;

/**
 * @Author: Du
 * @Date: 2021/7/6 15:30
 * <p>
 * <p>
 * 一个数组中，一个数左边比它小的数的总和，叫小和，所有小和累加起来叫做组的小和
 * <p>
 * 1, 3, 4, 2, 5
 * <p>
 * 1：没有
 * 3：1
 * 4：3 1
 * 2：1
 * 5：1 2 3 4
 * <p>
 * 组小和 = 1 + 1 + 1 + 1 + 2 + 3 + 3 + 4 = 16
 *
 * 借用归并排序的盒子
 *
 */
public class Offer035_数组中的逆序对组小和II
{
    
    // for test
    public static void main(String[] args)
    {
        int[] arr = {1, 3, 4, 2, 5};
        System.out.println(smallSum(arr));


//        int testTime = 500000;
//        int maxSize = 100;
//        int maxValue = 100;
//        boolean succeed = true;
//        for (int i = 0; i < testTime; i++)
//        {
//            int[] arr1 = generateRandomArray(maxSize, maxValue);
//            int[] arr2 = copyArray(arr1);
//            if (smallSum(arr1) != comparator(arr2))
//            {
//                succeed = false;
//                printArray(arr1);
//                printArray(arr2);
//                break;
//            }
//        }
//        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
    
    public static int smallSum(int[] arr)
    {
        if (arr == null || arr.length < 2)
        {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }
    
    // arr[L..R]既要排好序，也要求小和返回
    public static int process(int[] arr, int l, int r)
    {
        if (l == r)
        {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return process(arr, l, mid) + process(arr, mid + 1, r) + merge(arr, l, mid, r);//左侧的小和 + 右侧的小和 + 排好序后的总体小和
    }
    
    public static int merge(int[] arr, int L, int m, int r)
    {
        int[] help = new int[r - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = m + 1;
        int res = 0;
        while (p1 <= m && p2 <= r)
        {
            res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m)
        {
            help[i++] = arr[p1++];
        }
        while (p2 <= r)
        {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++)
        {
            arr[L + i] = help[i];
        }
        return res;
    }
    
    // for test
    public static int comparator(int[] arr)
    {
        if (arr == null || arr.length < 2)
        {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < arr.length; i++)
        {
            for (int j = 0; j < i; j++)
            {
                res += arr[j] < arr[i] ? arr[j] : 0;
            }
        }
        return res;
    }
    
    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue)
    {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
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
    
    
}
