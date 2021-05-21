package DoExercise.HSP.A007_Find;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 插值查找：二分查找的另一种实现，特点情况比二分查找好用。
 * 主要是改变了mid的取值：int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
 *
 * 特点：
 * 1 对于数据量较大，关键字分布比较均匀的查找表来说，采用插值查找, 速度较快
 * 2 关键字分布不均匀的情况下，该方法不一定比折半查找要好
 */
public class InsertSearch
{
    
    public static void main(String[] args)
    {
//        int arr[] = new int[]{1, 8, 10, 89, 1000, 1234};
//        System.out.println(insertValueSearch(arr, 0, arr.length - 1, 89));
    
        SimpleDateFormat startTime = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        System.out.println("排序开始时间：" + startTime.format(new Date()));
        insertValueSearch_test();
        SimpleDateFormat endTime = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        System.out.println("排序结束时间：" + endTime.format(new Date()));
    }
    
    
    public static void insertValueSearch_test()
    {
        //测试9999万个数据的排序
        int[] arrTest = new int[99999999];
        for (int index = 0; index < 99999999; index++)
        {
            arrTest[index] = (int) (Math.random() * 99999999);
        }
        System.out.println(insertValueSearch(arrTest, 0, arrTest.length - 1, arrTest[10]));
    }
    
    
    public static int insertValueSearch(int[] arr, int left, int right, int findVal)
    {
        System.out.println("插值查找被调用了！");
        if (left > right || findVal < arr[left] || findVal > arr[right])
        {
            return -1;
        }
        
        // 求出mid, 自适应
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findVal > midVal)
        {
            return insertValueSearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal)
        {
            return insertValueSearch(arr, left, mid - 1, findVal);
        } else
        {
            return mid;
        }
    }
}
