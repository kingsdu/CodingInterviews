package Offer_Interview;


/**
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 */

public class Solution {

    public static void main(String[] args) {
        Integer[][] array = {{1,2,3},{4,5,6},{7,8,9}};
        if(Solution.Find(array,-1)!=null){
            System.out.println("true");
        }else {
            System.out.println("flase");
        }
    }

    /***
     * 1 发现可使用的规律  -- 左上 右下
     * 2 确定变化的是什么  -- Col Row
     * 3 循环的方式  -- 1 范围；2 怎么变化；3 如何实现
     */
    public static Integer Find(Integer[][] array,Integer target){
        Integer col = array.length-1;
        Integer row = 0;

        while(col >=0 && row<=array[0].length-1){
            if(target == array[col][row]){
                return target;
            }else if(target < array[col][row]){
                col--;
            }else if(target > array[col][row]){
                row++;
            }
        }

        return null;
    }


















}
