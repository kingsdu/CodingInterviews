package DoExercise.HSP_ZCY.A006_排序;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 希尔排序：是第一个突破o(n2)时间复杂度的算法 = o(n log2 n)，根据下面的测试结果，确实比插入排序快很多
 * 不稳定算法
 *
 *
 *
 * <p>
 * 希尔排序在数组中采用跳跃式分组的策略，通过某个增量将数组元素划分为若干组，
 * 然后分组进行插入排序，随后逐步缩小增量，继续按组进行插入排序操作，直至增量为1。
 * <p>
 * 希尔排序通过这种策略使得整个数组在初始阶段达到从宏观上看基本有序，小的基本在前，大的基本在后。
 * 然后缩小增量，到增量为1时，其实多数情况下只需微调即可，不会涉及过多的数据移动。
 * <p>
 * <p>
 * https://www.cnblogs.com/chengxiao/p/6104371.html
 *
 *
 * 99万个数字 耗时 1s
 * 排序开始时间：2021:05:20:10:36:48
 * 排序结束时间：2021:05:20:10:36:49
 */
public class A004_希尔排序
{
    public static void main(String[] args)
    {

//        int[] arr = {1, 4, 2, 7, 9, 8, 3, 6};
//        shell_sort_1(arr);
//        System.out.println(Arrays.toString(arr));
//        int[] arr1 = {1, 4, 2, 7, 9, 8, 3, 6};
//        shell_sort_2(arr1);
//        System.out.println(Arrays.toString(arr1));
        
        SimpleDateFormat startTime = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        System.out.println("排序开始时间：" + startTime.format(new Date()));
        shell_sort_1_test();
        SimpleDateFormat endTime = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        System.out.println("排序结束时间：" + endTime.format(new Date()));
    }
    
    /**
     * 希尔排序 针对有序序列在插入时采用交换法
     *
     * @param arr
     */
    public static void shell_sort_1(int[] arr)
    {
        //增量gap，并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2)
        {
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = gap; i < arr.length; i++)
            {
                int j = i;
                while (j - gap >= 0 && arr[j] < arr[j - gap])
                {
                    //插入排序采用交换法
                    swap(arr, j, j - gap);
                    j -= gap;
                }
            }
        }
    }
    
    public static void shell_sort_1_test()
    {
        //测试80万个数据的排序
        int[] arrTest = new int[99999999];
        for (int index = 0; index < 99999999; index++)
        {
            arrTest[index] = (int) (Math.random() * 99999999);
        }
        //增量gap，并逐步缩小增量
        shell_sort_1(arrTest);
    }
    
    /**
     * 希尔排序 针对有序序列在插入时采用移动法。
     *
     * @param arr
     */
    public static void shell_sort_2(int[] arr)
    {
        //增量gap，并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2)
        {
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = gap; i < arr.length; i++)
            {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap])
                {
                    while (j - gap >= 0 && temp < arr[j - gap])
                    {
                        //移动法
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }
    
    
    /**
     * 交换数组元素
     *
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int[] arr, int a, int b)
    {
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }
}
