package DoExercise.HSP_ZCY.A006_排序;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 * 桶排序：时间复杂度：o(n+k)；空间复杂度：o(k)；排序方式 out-place；稳定排序；
 * 时间复杂度：O(N + C)
 * 额外空间复杂度：O(N + M)
 * 桶排序的稳定性取决于桶内排序使用的算法。
 * <p>
 * https://blog.csdn.net/qq_27124771/article/details/87651495
 * https://www.cnblogs.com/bqwzx/p/11029264.html
 * <p>
 * 划分多个范围相同的区间，每个子区间自排序，最后合并。
 * 桶排序是计数排序的扩展版本，计数排序可以看成每个桶只存储相同元素，而桶排序每个桶存储一定范围的元素，
 * 通过映射函数，将待排序数组中的元素映射到各个对应的桶中，对每个桶中的元素进行排序，最后将非空桶中的元素逐个放入原序列中。
 * <p>
 * 桶排序需要尽量保证元素分散均匀，否则当所有数据集中在同一个桶中时，桶排序失效。
 * <p>
 *
 * 999万个数据，5s
 * 排序开始时间：2021:05:20:11:48:01
 * 排序结束时间：2021:05:20:11:48:06
 */
public class A009_BucketSort
{
    
    public static void main(String[] args)
    {
        SimpleDateFormat startTime = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        System.out.println("排序开始时间：" + startTime.format(new Date()));
        bucketSort_1_test();
        SimpleDateFormat endTime = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        System.out.println("排序结束时间：" + endTime.format(new Date()));
    }
    
    public static void bucketSort_1_test()
    {
        //测试999万个数据的排序
        int[] arrTest = new int[9999999];
        for (int index = 0; index < 9999999; index++)
        {
            arrTest[index] = (int) (Math.random() * 9999999);
        }
        bucketSort_1(arrTest);
    }
    
    public static void bucketSort_1(int[] arr)
    {
        // 计算最大值与最小值
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++)
        {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        
        // 计算桶的数量
        int bucketNum = (max - min) / arr.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++)
        {
            bucketArr.add(new ArrayList<Integer>());
        }
        
        // 将每个元素放入桶
        for (int i = 0; i < arr.length; i++)
        {
            int num = (arr[i] - min) / (arr.length);
            bucketArr.get(num).add(arr[i]);
        }
        
        // 对每个桶进行排序
        for (int i = 0; i < bucketArr.size(); i++)
        {
            Collections.sort(bucketArr.get(i));
        }
        
        // 将桶中的元素赋值到原序列
        int index = 0;
        for (int i = 0; i < bucketArr.size(); i++)
        {
            for (int j = 0; j < bucketArr.get(i).size(); j++)
            {
                arr[index++] = bucketArr.get(i).get(j);
            }
        }
    }
    
}
