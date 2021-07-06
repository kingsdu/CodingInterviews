package DoExercise.HSP_ZCY.A030_归并排序快速排序;


import java.util.Arrays;

//归并排序
public class Code02_MergeSort
{
    // 递归方法实现
    public static void mergeSort1(int[] arr)
    {
        if (arr == null || arr.length < 2)
        {
            return;
        }
        process(arr, 0, arr.length - 1);
    }
    
    // arr[L...R]范围上，请让这个范围上的数，有序！
    public static void process(int[] arr, int L, int R)
    {
        if (L == R)
        {//只有一个数有序
            return;
        }
        // int mid = (L + R) / 2
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }
    
    public static void merge(int[] arr, int L, int M, int R)
    {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        while (p1 <= M) help[i++] = arr[p1++];
        while (p2 <= R) help[i++] = arr[p2++];
        for (i = 0; i < help.length; i++) arr[L + i] = help[i];
    }
    
    //非递归版本1(NlogN)
    public static void mergeSort_NoRecur(int[] arr)
    {
        if (arr == null || arr.length < 2)  return;
        int N = arr.length;
        int step = 1;
        while (step < N)
        {
            int L = 0;
            while (L < N)
            {
                int M = L + step - 1;
                if (M >= N) break;
                int R = Math.min(M + step, N - 1);//右组
                merge(arr, L, M, R);
                L = R + 1;
            }
            if (step > N / 2) break;//防止溢出
            step <<= 1;
        }
    }
    
    
    // 非递归方法实现2
    public static void mergeSort3(int[] arr)
    {
        if (arr == null || arr.length < 2) return;
        int N = arr.length;
        int step = 1;
        while (step < N)
        {
            int L = 0;
            while (L < N)
            {
                if (step >= N - L) break;
                int M = L + step - 1;
                int R = M + Math.min(step, N - M - 1);
                merge(arr, L, M, R);
                L = R + 1;
            }
            if (step > N / 2) break;
            step <<= 1;
        }
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
    
    // for test
    public static void main(String[] args)
    {
        int[] nums1 = {6, 3, 5, 4, 2, 1};
        mergeSort_NoRecur(nums1);
        Arrays.stream(nums1).forEach(e -> System.out.print(e + " "));
        
//        int testTime = 500000;
//        int maxSize = 100;
//        int maxValue = 100;
//        System.out.println("测试开始");
//        for (int i = 0; i < testTime; i++)
//        {
//            int[] arr1 = generateRandomArray(maxSize, maxValue);
//            int[] arr2 = copyArray(arr1);
//            mergeSort1(arr1);
//            mergeSort_NoRecur(arr2);
//            if (!isEqual(arr1, arr2))
//            {
//                System.out.println("出错了！");
//                printArray(arr1);
//                printArray(arr2);
//                break;
//            }
//        }
//        System.out.println("测试结束");
    }
    
}
