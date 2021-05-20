package DoExercise.HSP.A006_Sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 排序算法的稳定性：保证一个数列中两个相等数本身的顺序，在排序前后不变。（如果a原本在b前面，而a=b，排序之后a仍然在b的前面；）
 * <p>
 * 冒泡排序
 * <p>
 * 平均时间复杂度：o(n2)，稳定算法
 * <p>
 *
 * 10万个数字 耗时：19s
 * 排序开始时间：2021:05:20:10:35:31
 * 排序结束时间：2021:05:20:10:35:50
 */
public class A001_BubbleSort
{
    
    public static void main(String[] args)
    {
//        int[] arr = {6, 3, 5, 1, 2, 4, 8};
//        A001_BubbleSort bu = new A001_BubbleSort();
//        bu.bubbleSort_1(arr);
//        for (int x :
//                arr)
//        {
//            System.out.print(x + " ");
//        }
        
        
        SimpleDateFormat startTime = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        System.out.println("排序开始时间：" + startTime.format(new Date()));
        bubbleSort_1_test();
        SimpleDateFormat endTime = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        System.out.println("排序结束时间：" + endTime.format(new Date()));
    }
    
    
    /**
     * 冒泡排序和选择排序不同
     * 冒泡是一轮确定一个数
     *
     * @param arr
     */
    public static void bubbleSort_1(int[] arr)
    {
        for (int i = 0; i < arr.length - 1; i++)
        {
            //-i是冒泡排序的特点，冒泡排序j每次循环每一轮都能确定一个数字的位置，所以后面的每次循环都可以-i
            for (int j = 0; j < arr.length - 1 - i; j++)
            {
                if (arr[j] > arr[j + 1])
                {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }
    
    
    public static void bubbleSort_1_test()
    {
        //测试10万个数据的排序
        int[] arrTest = new int[100000];
        for (int index = 0; index < 100000; index++)
        {
            arrTest[index] = (int) (Math.random() * 100000);
        }
        bubbleSort_1(arrTest);
    }
}
