package DoExercise.JianzhiOffer;


/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * <p>
 * 输入 [3,4,5,1,2]
 * 输出 1
 * <p>
 * 旋转数组的特性
 * <p>
 * 1.包含两个有序序列
 * 2.最小数一定位于第二个序列的开头
 * 3.前序列的值都>=后序列的值（重点）
 * {123456}旋转后{456123}
 * <p>
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 */
public class Offer006_旋转数组的最小数字
{
    public static void main(String[] args)
    {
        int[] arrays = {2, 2, 2, 0, 1};
        System.out.println(findNum_1(arrays));
    }
    
    public static int findNum_1(int[] numbers)
    {
        int l = 0, r = numbers.length - 1;
        while (l < r)
        {
            int m = l + ((r - l) >> 1);
            if (numbers[m] < numbers[r])//表明mid位置处于
            {
                r = m;
            } else if (numbers[m] > numbers[r])
            {
                l = m + 1;
            } else
            {
                r--;
            }
        }
        return numbers[l];
    }
    
    
    public static int findNum_2(int[] numbers)
    {
        int i = 0, j = numbers.length - 1;
        while (i < j)
        {
            int m = (i + j) / 2;
            if (numbers[m] > numbers[j]) i = m + 1;
            else if (numbers[m] < numbers[j]) j = m;
            else
            {
                int x = i;
                for (int k = i + 1; k < j; k++)
                {
                    if (numbers[k] < numbers[x]) x = k;
                }
                return numbers[x];
            }
        }
        return numbers[i];
    }
}
