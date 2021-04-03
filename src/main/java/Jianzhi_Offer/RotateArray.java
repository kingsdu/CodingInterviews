package Jianzhi_Offer;


/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * <p>
 * 输入 [3,4,5,1,2]
 * 输出 1
 */
public class RotateArray
{

    /**
     * 使用最基础的遍历查找算法找出最小元素
     *
     * @param arraysNum
     * @return
     */
    public int findMinNum_1(int[] arraysNum)
    {
        if (arraysNum.length == 0)
        {
            return 0;
        }
        int minNum = arraysNum[0];

        for (int i = 0; i < arraysNum.length; i++)
        {
            if (arraysNum[i] < minNum)
            {
                minNum = arraysNum[i];
            }
        }

        return minNum;
    }


    /**
     * 传进去旋转数组，注意旋转数组的特性：
     * 1.包含两个有序序列
     * 2.最小数一定位于第二个序列的开头
     * 3.前序列的值都>=后序列的值
     * 定义把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 旋转数组实例：
     * {123456}旋转后{456123}
     * <p>
     * 定义首尾下标，因为是非递减数组旋转，所以旋转最后可以看做成两部分，前半部分整体非递减，后半部分 整体非递减，前半部分整体大于后半部分
     * 因为是非递减排序的数组的一个旋转并且是把最开始的若干个元素搬到数组的末尾,所以white判定条件是array[left] >= array[right]
     * 所以，我们假设如下定义，left指向最左侧，right指向最右侧，mid为二分之后的中间位置。
     * 则，a[mid] > a[left],说明mid位置在原数组前半部分，进一步说明，目标最小值，在mid的右侧，让 left=mid
     * a[mid] < a[left], 说明mid位置在原数组后半部分，进一步说明，目标最小值，在mid的左侧，让 right=mid
     * 这个过程，会让[left, right]区间缩小
     * 这个过程中，left永远在原数组前半部分，right永远在原数组的后半部分，而范围会一直缩小
     * 当left和right相邻时，right指向的位置，就是最小元素的位置
     * 但是，因为题目说的是非递减，也就意味着数据允许重复，因为有重复发，就可能会有a[left] == a[mid] == a[right]的情况，我们就无法判定数据在mid左侧还是右侧。（注意，只要有两者不相等，我 们就能判定应该如何缩小范围）
     */
    public int findNum_2(int[] array)
    {
        int low = 0, high = array.length - 1, mid;

        while (low < high)
        {
            mid = low + (high - low) / 2;//防止(low+high)溢出,也可写成mid = low + ((high-low) >> 1)
            if (array[mid] > array[high])//说明最小的数据一定在mid右边
            {
                low = mid + 1;
            } else if (array[mid] == array[high])//说明存在重复数据
            {
                high = high - 1;
            } else
            {
                /***
                 * 注意这里有个坑：如果待查询的范围最后只剩两个数，那么mid 一定会指向下标靠前的数字
                 * 比如 array = [4,6] array[low] = 4 ;array[mid] = 4 ; array[high] = 6 ;
                 * 如果high = mid - 1，就会产生错误， 因此high = mid
                 */
                high = mid;
            }
        }
        return array[low];
    }


    public static void main(String[] args)
    {
        RotateArray rotateArray = new RotateArray();
//        int[] arrays = {3, 4, 5, 1, 2};
        int[] arrays = {1, 2, 0, 1, 2};
//        System.out.println(rotateArray.findMinNum_1(arrays));
        System.out.println(rotateArray.findNum_2(arrays));
    }


}
