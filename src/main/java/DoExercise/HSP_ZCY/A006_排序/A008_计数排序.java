package DoExercise.HSP_ZCY.A006_排序;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * 计数排序：时间复杂度：o(n+k)；空间复杂度：o(k)；排序方式out-place；稳定排序；
 * https://www.cnblogs.com/xiaochuan94/p/11198610.html
 *
 * 1 排序的元素必须是整数，
 * 2 排序元素的取值要在一定范围内，并且比较集中。
 * 只有这两个条件都满足，才能最大程度发挥计数排序的优势。
 *
 *
 */
public class A008_计数排序
{
    
    public static void main(String[] args)
    {
        SimpleDateFormat startTime = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        System.out.println("排序开始时间：" + startTime.format(new Date()));
        countSort_1_test();
        SimpleDateFormat endTime = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        System.out.println("排序结束时间：" + endTime.format(new Date()));
    }
    
    
    public static void countSort_1_test()
    {
        //测试999万个数据的排序
        int[] treeTest = new int[9999999];
        for (int index = 0; index < 9999999; index++)
        {
            treeTest[index] = (int) (Math.random() * 9999999);
        }
        countSort_1(treeTest);
    }
    
    
    public static int[] countSort_1(int[] A)
    {
        // 找出数组A中的最大值
        int max = Integer.MIN_VALUE;
        for (int num : A)
        {
            max = Math.max(max, num);
        }
        // 初始化计数数组count
        int[] count = new int[max + 1];
        // 对计数数组各元素赋值
        for (int num : A)
        {
            count[num]++;
        }
        // 创建结果数组
        int[] result = new int[A.length];
        // 创建结果数组的起始索引
        int index = 0;
        // 遍历计数数组，将计数数组的索引填充到结果数组中
        for (int i = 0; i < count.length; i++)
        {
            while (count[i] > 0)
            {
                result[index++] = i;
                count[i]--;
            }
        }
        // 返回结果数组
        return result;
    }
}
