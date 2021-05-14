package DoExercise.JianzhiOffer;


/**
 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * <p>
 * 输入 [3,4,5,1,2]
 * 输出 1
 *
 * 旋转数组的特性
 *
 * 1.包含两个有序序列
 * 2.最小数一定位于第二个序列的开头
 * 3.前序列的值都>=后序列的值（重点）
 * {123456}旋转后{456123}
 *
 */
public class Offer006_RotateArray
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
            } else if (array[mid] < array[high])
            {
                high = mid;
            }
        }
        return array[low];
    }


    public static void main(String[] args)
    {
        Offer006_RotateArray rotateArray = new Offer006_RotateArray();
//        int[] arrays = {3, 4, 5, 1, 2};
        int[] arrays = {1, 2, 0, 1, 2};
//        System.out.println(rotateArray.findMinNum_1(arrays));
        System.out.println(rotateArray.findNum_2(arrays));
    }


}
