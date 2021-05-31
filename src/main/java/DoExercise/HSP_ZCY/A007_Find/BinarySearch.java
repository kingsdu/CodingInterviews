package DoExercise.HSP_ZCY.A007_Find;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 二分查找
 * <p>
 * <p>
 * 测试9999万个数据的排序:2s
 */
public class BinarySearch
{
    public static void main(String[] args)
    {
//        int num[] = new int[]{1, 8, 10, 89, 1000, 1234};
//        BinarySearch bi = new BinarySearch();
//        int i = bi.binarySearch_1(num, 0, num.length - 1, 89);
//        System.out.println(i);
        //使用Java自带的查找类，该类中如果找到了返回下标值，没找到返回插入下标：-（1+low）
//        int i1 = Arrays.binarySearch(num, 13);
//        System.out.println(i1);
        
        SimpleDateFormat startTime = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        System.out.println("排序开始时间：" + startTime.format(new Date()));
        binarySearch_test();
        SimpleDateFormat endTime = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        System.out.println("排序结束时间：" + endTime.format(new Date()));
        
    }
    
    public static void binarySearch_test()
    {
        //测试9999万个数据的排序
        int[] arrTest = new int[99999999];
        for (int index = 0; index < 99999999; index++)
        {
            arrTest[index] = (int) (Math.random() * 99999999);
        }
        System.out.println(binarySearch_1(arrTest, 0, arrTest.length - 1, arrTest[10]));
    }
    
    
    /**
     * 非递归实现
     *
     * @return
     */
    public static int binarySearch_1(int[] num, int i, int j, int target)
    {
        while (i <= j)
        {
            System.out.println("二分查找被调用了！");
            int mid = (i + j) / 2;
            if (num[mid] == target)
            {
                return mid;
            } else
            {
                if (num[mid] < target)
                {
                    i = mid + 1;
                } else if (num[mid] > target)
                {
                    j = mid - 1;
                }
            }
        }
        return -1;
    }
    
    
    /**
     * 递归
     *
     * @return
     */
    public static int binarySearch_2(int[] arr, int numKey, int start, int end)
    {
        int mid = (end - start) / 2 + start;
        if (start > end)
        {
            return -1;
        }
        if (numKey < arr[mid])
        {
            return binarySearch_2(arr, numKey, start, mid - 1);
        } else if (numKey > arr[mid])
        {
            return binarySearch_2(arr, numKey, mid + 1, end);
        } else
        {
            return mid;
        }
    }
}
