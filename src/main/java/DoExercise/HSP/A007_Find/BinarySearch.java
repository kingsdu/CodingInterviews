package DoExercise.HSP.A007_Find;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 二分查找
 *
 *
 * 测试9999万个数据的排序:2s
 *
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
     * 递归实现
     * 二分查找算法默认一般返回数组下标索引
     * 没找到返回-1
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
                if (num[mid] < target)//target在mid右边
                {
                    i = mid + 1;//下限增加
                } else if (num[mid] > target)//target在mid左边
                {
                    j = mid - 1;//上限减少
                }
            }
        }
        return -1;
    }
    
    
 
    
}
