package DoExercise.HSP_ZCY.A007_Find;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;


/**
 * 斐波那契(黄金分割法)查找算法:巧妙的避开了使用乘除法，是一种空间换时间的方法。
 * <p>
 * 1、0.618，黄金分割比例（所谓的）
 * 2、斐波那契数列相邻的数之比接近0.618
 * 3、构造了一个斐波那契长度的数列，通过这个数列来获取黄金分割点，每一次的mid都保证是在黄金分割点上
 * 4、用黄金分割点的数字去查找
 *
 * 算法需要根据查找数组的长度，构造fab数组的长度maxSize（重要）
 * http://training.eeworld.com.cn/TI/video/16398
 */
public class FibonacciSearch
{
    public static int maxSize;
    
    public static void main(String[] args)
    {
//        int[] arr = {1, 8, 10, 89, 1000, 1234};
//        System.out.println("index=" + fibSearch(arr, 189));
        SimpleDateFormat startTime = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        System.out.println("排序开始时间：" + startTime.format(new Date()));
        fibSearch_test();
        SimpleDateFormat endTime = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        System.out.println("排序结束时间：" + endTime.format(new Date()));
    }
    
    
    public static void fibSearch_test()
    {
        //测试9999万个数据的排序
        int[] arrTest = new int[99999999];
        maxSize = arrTest.length/999999;
        for (int index = 0; index < 99999999; index++)
        {
            arrTest[index] = (int) (Math.random() * 99999999);
        }
        System.out.println(fibSearch(arrTest, arrTest[10]));
    }
    
    /**
     * @param a   数组
     * @param key 我们需要查找的关键码(值)
     * @return 返回对应的下标，如果没有-1
     */
    public static int fibSearch(int[] a, int key)
    {
        int low = 0;
        int high = a.length - 1;
        int k = 0; //表示斐波那契分割数值的下标
        int mid = 0;
        int f[] = fib(); //获取到斐波那契数列
        //获取到斐波那契分割数值的下标
        while (high > f[k] - 1)
        {
            k++;
        }
        //因为f[k]值可能大于 a 的长度，因此我们需要使用Arrays类，构造一个新的数组，并指向temp[]，不足的部分会使用0填充
        int[] temp = Arrays.copyOf(a, f[k]);
        //实际上需求使用a数组最后的数填充 temp
        //举例: temp = {1,8, 10, 89, 1000, 1234, 0, 0}  => {1,8, 10, 89, 1000, 1234, 1234, 1234,}
        for (int i = high + 1; i < temp.length; i++)
        {
            temp[i] = a[high];
        }
        
        // 使用while来循环处理，找到我们的数 key
        while (low <= high)
        {
            mid = low + f[k - 1] - 1;//前面做的一堆操作都是为了这个地方能够使用黄金分割
            if (key < temp[mid])
            { //我们应该继续向数组的前面查找(左边)
                high = mid - 1;
                //为甚是 k--
                //说明
                //1. 全部元素 = 前面的元素 + 后边元素
                //2. f[k] = f[k-1] + f[k-2]
                //因为 前面有 f[k-1]个元素,所以可以继续拆分 f[k-1] = f[k-2] + f[k-3]
                //即 在 f[k-1] 的前面继续查找 k--
                //即下次循环 mid = f[k-1-1]-1
                k--;
            } else if (key > temp[mid])
            { // 我们应该继续向数组的后面查找(右边)
                low = mid + 1;
                //为什么是k -=2
                //说明
                //1. 全部元素 = 前面的元素 + 后边元素
                //2. f[k] = f[k-1] + f[k-2]
                //3. 因为后面我们有f[k-2] 所以可以继续拆分 f[k-1] = f[k-3] + f[k-4]
                //4. 即在f[k-2] 的前面进行查找 k -=2
                //5. 即下次循环 mid = f[k - 1 - 2] - 1
                k -= 2;
            } else
            {
                //因为数组的右边扩充过，所以需要确定，返回的是哪个下标
                if (mid <= high)
                {
                    return mid;
                } else
                {
                    return high;//右边都是相同的数
                }
            }
        }
        return -1;
    }
    
    
    /**
     *
     * 因为后面我们mid=low+F(k-1)-1，需要使用到斐波那契数列，因此我们需要先获取到一个斐波那契数列
     * 非递归方法得到一个斐波那契数列
     *
     * maxSize定位多少，对算法的时间和空间复杂度都有影响
     *
     * @return
     */
    public static int[] fib()
    {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++)
        {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }
}
