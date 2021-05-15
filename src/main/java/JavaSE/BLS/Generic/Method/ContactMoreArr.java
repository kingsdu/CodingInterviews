package JavaSE.BLS.Generic.Method;

import java.util.Arrays;

/**
 * 合并多个数组
 */
public class ContactMoreArr
{
    public static void main(String[] args)
    {
        Integer arr1[] = new Integer[]{1, 2, 3, 4, 5};
        Integer arr2[] = new Integer[]{6, 7, 8, 9, 10};
        Integer arr3[] = new Integer[]{11, 12, 13, 14, 15};
        Integer arr[] = new Integer[]{16};
        
        Integer[] more = concatAll(arr, arr1, arr2, arr3);
        Arrays.stream(more).forEach(value -> System.out.println(value));
    }
    
    
    /**
     *
     * 合并多个数组
     *
     * @param first
     * @param rest
     * @param <T>
     * @return
     */
    public static <T> T[] concatAll(T[] first, T[]... rest)
    {
        int totalLength = first.length;
        for (T[] array : rest)
        {
            totalLength += array.length;
        }
        T[] result = Arrays.copyOf(first, totalLength);
        int offset = first.length;
        for (T[] array : rest)
        {
            System.arraycopy(array, 0, result, offset, array.length);
            offset += array.length;
        }
        return result;
    }
    
    
    /**
     * 合并单个数组，方法1
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public static int[] contactSin1(int arr1[], int arr2[])
    {
        int[] ints = Arrays.copyOf(arr1, arr1.length + arr2.length);
        System.arraycopy(arr2, 0, ints, arr1.length, arr2.length);
        return ints;
    }
    
    
    /**
     * 合并单个数组，方法2
     *
     * @param a
     * @param b
     * @return
     */
    public static int[] contactSin2(int a[], int b[])
    {
        int[] c = new int[a.length + b.length];
        System.arraycopy(a, 0, c, 0, a.length);
        System.arraycopy(b, 0, c, a.length, b.length);
        return c;
    }
}
