package DoExercise.HSP.A006_Sort;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 快速排序：时间复杂度：o(n log n) 空间复杂度：o(log n) 不稳定算法
 *
 * 99万个数字 耗时 1s
 */
public class A006_QuickSort
{
    
    public static void main(String[] args)
    {
//        int[] array = {9, 9, 8, 7, 6, 5, 4, 3, 2, 1};
//        A006_QuickSort q = new A006_QuickSort();
//        q.quickSort(array);
//        for (int i : array)
//        {
//            System.out.print(i + " ");
//        }
    
        SimpleDateFormat startTime = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        System.out.println("排序开始时间：" + startTime.format(new Date()));
        quickSort_1_test();
        SimpleDateFormat endTime = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        System.out.println("排序结束时间：" + endTime.format(new Date()));
        
    }
    
    /**
     * 加这一层是为了程序控制
     *
     * @param array
     */
    public static void quickSort(int[] array)
    {
        int len;
        if (array == null
                || (len = array.length) == 0
                || len == 1)
        {
            return;
        }
        recQuickSort(array, 0, len - 1);
    }
    
    public static void recQuickSort(int[] arr, int left, int right)
    {
        if (left > right)
        {
            return;
        }
        
        int base = arr[left];
        int i = left, j = right;
        while (i != j)
        {
            //从右边开始是因为pivot在左边
            while (arr[j] >= base && i < j)//快速排序，移动位置行为，表示该元素符合要求，停止下标则表示该元素不符合要求该交换位置
            {
                j--;
            }
            while (arr[i] <= base && i < j)
            {
                i++;
            }
            //交换位置
            if (i < j)
            {
                swap(arr, i, j);
            }
        }
        //遍历完成，交换哨兵
        swap(arr, left, j);
        
        recQuickSort(arr, left, j - 1);
        recQuickSort(arr, j + 1, right);
    }
    
    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    
    public static void quickSort_1_test()
    {
        //测试80万个数据的排序
        int[] arrTest = new int[99999999];
        for (int index = 0; index < 99999999; index++)
        {
            arrTest[index] = (int) (Math.random() * 99999999);
        }
        //增量gap，并逐步缩小增量
        quickSort(arrTest);
    }
}
