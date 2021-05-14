package DoExercise.JianzhiOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * <p>
 * 输入 [1,2,3,4]
 * 输出 [1,3,2,4]
 */
public class Offer013_ReOrderArray
{
    
    /**
     * 思路：
     * 1、找到array中的奇数存入array1，找到array中的偶数存入array2，
     * 2、合并array1、array2
     * <p>
     * 循环1次找出数据，第2次合并数据
     * 但是使用的内存空间过多
     *
     * @param array
     * @return
     */
    public static int[] reOrderArray_1(int[] array)
    {
        List<Integer> list0 = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] % 2 == 0)
            {
                list0.add(array[i]);
            } else if (array[i] % 2 == 1)
            {
                list1.add(array[i]);
            }
        }
        
        list1.addAll(list0);
        int[] resInt = new int[list1.size()];
        
        for (int i = 0; i < list1.size(); i++)
        {
            resInt[i] = list1.get(i);
        }
        
        return resInt;
    }
    
    
    /**
     * 学习别人的方法。
     * <p>
     * 思路：1、遍历数组，计算数组中偶树的个数，记录作为偶树的下标开始
     * 2、遍历数组，判断，奇数从0开始存，偶树从上一步获取的下标开始存
     *
     * @param array
     * @return
     */
    public static int[] reOrderArray_findIndex(int[] array)
    {
        int i = 0, j = 0;
        int[] arr = new int[array.length];
        for (int l = 0; l < array.length; l++)
        {
            if (array[l] % 2 != 0)
            {
                i++;
            }
        }
        
        for (int num :
                array)
        {
            if (num % 2 == 1)
            {
                arr[j++] = num;
            } else if (num % 2 == 0)
            {
                arr[i++] = num;
            }
        }
        return arr;
    }
    
    /**
     *
     *
     * 采用冒泡排序做
     * 思路：1、遍历数组，将左边是偶树，右边是奇数的组合交换位置即可。
     *
     * @param array
     * @return
     */
    public static int[] reOrderArray_bubbleSort(int[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array.length-1-i; j++)//-1是 j要和j+1比较；-i是循环一次就会确定一个数字的位置，-i可以减少循环比较的次数
            {
                //只有当左边是偶数, 右边是奇数时，冒泡交换
                if((array[j] & 1) == 0 && (array[j+1] & 1) == 1){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
        return array;
    }
    
    
    public static void main(String[] args)
    {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int[] ints = reOrderArray_1(array);
        for (int i = 0; i < ints.length; i++)
        {
            System.out.print(ints[i] + " ");
        }
        
        System.out.println();
        int[] ints1 = reOrderArray_findIndex(array);
        for (int i = 0; i < ints1.length; i++)
        {
            System.out.print(ints1[i] + " ");
        }
    
        System.out.println();
        int[] ints2 = reOrderArray_bubbleSort(array);
        for (int i = 0; i < ints2.length; i++)
        {
            System.out.print(ints2[i] + " ");
        }
    }
    
    
}
