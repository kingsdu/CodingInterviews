package DoExercise.HSP_ZCY.A006_排序;


import DoExercise.JianzhiOffer.Offer000_Common;

/**
 * 快速排序：时间复杂度：o(n log n) 空间复杂度：o(log n) 不稳定算法
 *
 * 99万个数字 耗时 1s
 */
public class A006_快速排序
{
    
    public static void main(String[] args)
    {
        int[] array = {9, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        quickSort(array);
        for (int i : array)
        {
            System.out.print(i + " ");
        }
    
//        SimpleDateFormat startTime = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
//        System.out.println("排序开始时间：" + startTime.format(new Date()));
//        quickSort_1_test();
//        SimpleDateFormat endTime = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
//        System.out.println("排序结束时间：" + endTime.format(new Date()));
        
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
        if (left > right) return;
        int base = arr[left];
        int i = left, j = right;
        while (i < j)
        {
            //从右边开始是因为pivot在左边
            while (arr[j] >= base && i < j) j--;
            while (arr[i] <= base && i < j) i++;
            //交换位置
            if (i < j) Offer000_Common.swap(arr, i, j);
        }
        //遍历完成，交换哨兵
        Offer000_Common.swap(arr, left, j);
        recQuickSort(arr, left, j - 1);
        recQuickSort(arr, j + 1, right);
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
    
    
    /**
     *
     * 第二种快速排序的方法，不太理解
     *
     * @param a
     * @param start
     * @param end
     */
    private static void quickSort_2(int[] a, int start, int end)
    {
        if (start < end)
        {
            int p = quickSort_2_core(a, start, end);
            quickSort_2(a, start, p - 1);
            quickSort_2(a, p + 1, end);
        }
    }
    
    private static int quickSort_2_core(int[] a, int start, int end)
    {
        int x = a[end];//以x作为锚点
        int i = start;
        for (int j = start; j <= end - 1; j++)
        {
            if (a[j] >= x)
            {
                Offer000_Common.swap(a, i, j);
                i++;//交换了几次
            }
        }//把最大的放到最后
        Offer000_Common.swap(a, i, end);//把最大的放到i的位置
        return i;
    }
    
}
