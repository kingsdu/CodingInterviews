package DoExercise.JianzhiOffer;

import java.util.Random;

/***
 *
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 *   [1, 4, 7, 11, 15],
 *   [2, 5, 8, 12, 19],
 *   [3, 6, 9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 *
 * target = 5，返回 true。
 * target = 20，返回 false。
 */

public class Offer001_二维数组中的查找
{
    
    public static void main(String[] args)
    {
        Offer001_二维数组中的查找 sl = new Offer001_二维数组中的查找();
        //遍历法
        int target = 11;
        int[][] arrayTar = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(sl.Find_3(target, arrayTar));
    }
    
    
    /**
     * 数组遍历法则
     * <p>
     * 这个方法循环从次数太多，肯定不是有效的方法
     *
     * @param target
     * @param array
     * @return
     */
    public boolean Find_1(int target, int[][] array)
    {
        boolean flag = false;
        
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array[i].length; j++)
            {
                if (array[i][j] == target)
                {
                    flag = true;
                    break;
                }
            }
        }
        
        return flag;
    }
    
    
    /**
     * 位置判断法
     * 观察数组数字规律可知：
     * 1、对于左下角的数字，其右边都是比它大，其上面都比其小。可以利用此属性解决问题。
     * 2、输入一个数，当该数字 < 左下角的数字时，下标上移；该数字 > 左下角的数字时，下标下移。
     * 3、
     *
     * @param target
     * @param array
     * @return
     */
    public boolean Find_2(int target, int[][] array)
    {
        int rows = array.length;
        int cols = array[0].length;
        int i = rows - 1, j = 0;
        
        while (i >= 0 && j < cols)
        {
            if (array[i][j] > target)
                i--;
            else if (array[i][j] < target)
                j++;
            else
                return true;
        }
        return false;
    }
    
    
    /**
     * 自己再写一遍
     *
     * i < array.length 这个写错了。
     * i是从array.length - 1开始的，所以判断的条件是 >= 0
     *
     * @param target
     * @param array
     * @return
     */
    public boolean Find_3(int target, int[][] array)
    {
        if (array.length == 0)
        {
            return false;
        }
        
        int i = array.length - 1, j = 0;
        while (i >= 0 && j < array[0].length)
        {
            if (target < array[i][j])
            {
                i--;
            } else if (target > array[i][j])
            {
                j++;
            } else if (target == array[i][j])
            {
                return true;
            }
        }
        
        return false;
    }
    
    
    /**
     * 生成指定行列的数组
     *
     * @param cols
     * @param rows
     * @return
     */
    public int[][] ArrayList_get(int rows, int cols)
    {
        int[][] array_a = new int[rows][cols];
        Random ran = new Random();
        
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                array_a[i][j] = ran.nextInt(100);
            }
        }
        
        return array_a;
    }
    
    
    public boolean getNumber(int target, int[][] arrayTar)
    {
        int i, j;
        i = arrayTar.length - 1;
        j = 0;
        
        while (i >= 0 && j < arrayTar[0].length)
        {
            if (arrayTar[i][j] < target)
            {
                j++;
            } else if (arrayTar[i][j] > target)
            {
                i--;
            } else
            {
                return true;
            }
        }
        return false;
    }
    
    
 
}


/**
 * 结论：
 * （1）遍历法是根据数组左下角和右上角的数字间的规律进行比较的，要注意循环的条件控制以及数组的边界控制。
 * （2）遍历法和位置法都是逐个在比较，两者的效率相差不大。
 * （3）Random随机函数里填充的数字100，生成的结果是0~99的数字。
 */
