package DoExercise.HSP.A006_Sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 选择排序：平均时间复杂度：o(n2)，不稳定算法
 *
 * 10万个数字 耗时：8s
 * 排序开始时间：2021:05:20:10:32:16
 * 排序结束时间：2021:05:20:10:32:34
 *
 */
public class A002_SelectSort
{
    
    public static void main(String[] args)
    {
//        int[] arr = {6, 3, 5, 1, 2, 4, 8};
//        SelectSort_1(arr);
    
        SimpleDateFormat startTime = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        System.out.println("排序开始时间："+startTime.format(new Date()));
        selecstSort_test();
        SimpleDateFormat endTime = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        System.out.println("排序结束时间："+endTime.format(new Date()));
    }
    
    
    /**
     *
     * 选择排序从第一个数开始，依次和后面的数字进行逐个比较；每一轮第一个数字的位置确定
     * 冒泡排序，相邻的两个数相互比较，互换位置；每一轮最后一个数字的位置确定
     *
     * @param arr
     */
    public static void SelectSort_1(int[] arr)
    {
        for (int i = 0; i < arr.length - 1; i++)
        {
            for (int j = i + 1; j < arr.length; j++)//每一轮，第一个数字的位置确定
            {
                if (arr[i] > arr[j])
                {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
    
    public static void selecstSort_test()
    {
        //测试10万个数据的排序
        int[] arrTest = new int[100000];
        for (int index = 0; index < 100000; index++) {
            arrTest[index] = (int)(Math.random() * 100000);
        }
        SelectSort_1(arrTest);
    }
}
