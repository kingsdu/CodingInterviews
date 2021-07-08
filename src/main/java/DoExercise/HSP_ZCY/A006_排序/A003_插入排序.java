package DoExercise.HSP_ZCY.A006_排序;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 插入排序
 * <p>
 * https://www.cnblogs.com/coding-996/p/12275710.html
 *
 * 平均时间复杂度：o(n2)，稳定算法
 *
 * 10万个数字 耗时：2s
 * 排序开始时间：2021:05:20:10:34:16
 * 排序结束时间：2021:05:20:10:34:18
 */
public class A003_插入排序
{
    
    public static void main(String[] args)
    {
//        int arr[] = new int[]{9,7,3,5,22,41,6,21,31};
//        Arrays.stream(insertSort(arr)).forEach(e-> System.out.print(e+" "));
    
        SimpleDateFormat startTime = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        System.out.println("排序开始时间："+startTime.format(new Date()));
        insertSort_test();
        SimpleDateFormat endTime = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        System.out.println("排序结束时间："+endTime.format(new Date()));
    
    
    }
    
    public static int[] insertSort(int[] arr)
    {
        for (int i = 1; i < arr.length; i++)
        {
            int j = i;
            while (j > 0)
            {   //j是有序的，i中是无序的
                if (arr[j] < arr[j - 1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    j--;
                }else {
                    break;//比左边有序数组中最大的元素还要大，直接放在最右边，不用比
                }
            }
        }
        return arr;
    }
    
    
    
    public static void insertSort_test()
    {
        //测试80万个数据的排序
        int[] arrTest = new int[100000];
        for (int index = 0; index < 100000; index++) {
            arrTest[index] = (int)(Math.random() * 100000);
        }
        insertSort(arrTest);
    }
}
