package Jianzhi_Offer;

import java.util.Random;

/***
 *
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 */

public class Solution {

    /**
     * 数组遍历法则
     * @param target
     * @param array
     * @return
     */
    public boolean Find_1(int target,int [][] array){
        boolean flag = false;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(array[i][j] == target){
                    flag = true;
                    break;
                }
            }
        }

        return flag;
    }


    /**
     *
     * 位置判断法
     *
     * @param target
     * @param array
     * @return
     */
    public boolean Find_2(int target,int [][] array){
        int rows = array.length;
        int cols = array[0].length;
        int i=rows-1,j=0;

        while(i>=0 && j<cols){
            if(array[i][j]>target)
                i--;
            else if(array[i][j]<target)
                j++;
            else
                return true;
        }
        return false;
    }


    /**
     * 生成指定行列的数组
     * @param cols
     * @param rows
     * @return
     */
    public int [][] ArrayList_get(int rows,int cols){
        int [][] array_a = new int[rows][cols];
        Random ran = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array_a[i][j] = ran.nextInt(100);
            }
        }

//        for (int i = 0; i < array_a.length; i++) {
//            for (int j = 0; j < array_a[i].length; j++) {
//                System.out.print(array_a[i][j]+"--");
//            }
//            System.out.println();
//        }

        return array_a;
    }

}


/**
 *
 * 结论：
 * （1）遍历法是根据数组左下角和右上角的数字间的规律进行比较的，要注意循环的条件控制以及数组的边界控制。
 * （2）遍历法和位置法都是逐个在比较，两者的效率相差不大。
 * （3）Random随机函数里填充的数字100，生成的结果是0~99的数字。
 */
