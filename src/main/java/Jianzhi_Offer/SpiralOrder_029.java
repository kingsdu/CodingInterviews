package Jianzhi_Offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralOrder_029
{
    
    
    public static void main(String[] args)
    {
        //[[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]]
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        spiralOrder_2(matrix);
        int[][] matrix = {{1,2,3,4,5}, {6,7,8,9,10}, {11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        ArrayList<Integer> integers = spiralOrder_12(matrix);
        for (int i :
                integers)
        {
            System.out.print(i+" ");
        }
        
//        int[] ints = spiralOrder_13(matrix);
//        for (int i :
//                ints)
//        {
//            System.out.println(i);
//        }
    }
    
    
    /**
     * 第一版，没想清楚，写的太复杂，也不对。
     * 这个方法肯定不行，拼出来的，没意义
     *
     * @param matrix
     * @return
     */
    public static int[] spiralOrder_1(int[][] matrix)
    {
        int rowMax = matrix.length, colMax = matrix[0].length;
        int row = 0, col = 0, index = 0;
        int[] result = new int[rowMax * colMax];
        //第一行 行不变，列递增
        while (col < colMax
        )
        {
            result[index] = matrix[row][col];
            col++;
            index++;
        }
        col = colMax - 1;
        ++row;
        while (row < rowMax)
        {
            result[index] = matrix[row][col];
            row++;
            index++;
        }
        row = rowMax - 1;
        --col;
        while (col >= 0)
        {
            result[index] = matrix[row][col];
            col--;
            index++;
        }
        ++col;
        --row;
        while (row > 0)
        {
            result[index] = matrix[row][col];
            row--;
            index++;
        }
        result[result.length - 1] = matrix[rowMax / 2][colMax / 2];
        return result;
    }
    
    
    /**
     * 稍微看了下解析，有详细的花了下图，清晰些了，但是有些用例错误
     *
     * @param matrix
     * @return
     */
    public static int[] spiralOrder_2(int[][] matrix)
    {
        if (matrix.length == 0) return new int[0];
        if (matrix.length == 1)
        {
            int[] number = new int[1];
            number[0] = matrix[0][0];
            return number;
        }
        int rowMax = matrix.length, colMax = matrix[0].length;
        int row, col, index = 0, rowStart = 0, colStart = 0, maxSize = rowMax * colMax;
        int[] result = new int[maxSize];
        
        while (index < maxSize)
        {
            row = rowStart;
            col = colStart;
            
            //转圈
            if (colMax <= 1)
            {
                while (row < rowMax && index < maxSize)
                {
                    result[index] = matrix[row][col];
                    row++;
                    index++;
                }
                return result;
            } else if (rowMax <= 1)
            {
                while (col < colMax && index < maxSize)
                {
                    result[index] = matrix[row][col];
                    col++;
                    index++;
                }
                return result;
            }
            
            while (col < colMax - 1 && index < maxSize)
            {
                result[index] = matrix[row][col];
                col++;
                index++;
            }
            
            while (row < rowMax - 1 && index < maxSize)
            {
                result[index] = matrix[row][col];
                row++;
                index++;
            }
            
            while (col > 0 && index < maxSize)
            {
                result[index] = matrix[row][col];
                col--;
                index++;
            }
            
            while (row > 0 && index < maxSize)
            {
                result[index] = matrix[row][col];
                row--;
                index++;
            }
            rowStart++;
            colStart++;
            
        }
        return result;
    }
    
    
    public static ArrayList<Integer> spiralOrder_11(int[][] matrix)
    {
        int rowMax = matrix.length, colMax = matrix[0].length;
        int row, col, index = 0, rowStart = 0, colStart = 0, maxSize = rowMax * colMax;
        ArrayList<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return result;
        }
        
        while (index < maxSize)
        {
            row = rowStart;
            col = colStart;
            //转圈
            
            if (colMax <= 1)
            {
                while (row < rowMax && index < maxSize)
                {
                    result.add(matrix[row][col]);
                    row++;
                    index++;
                }
                return result;
            } else if (rowMax <= 1)
            {
                while (col < colMax && index < maxSize)
                {
                    result.add(matrix[row][col]);
                    col++;
                    index++;
                }
                return result;
            }
            
            while (col < colMax - 1 && index < maxSize)
            {
                result.add(matrix[row][col]);
                col++;
                index++;
            }
            
            while (row < rowMax - 1 && index < maxSize)
            {
                result.add(matrix[row][col]);
                row++;
                index++;
            }
            
            while (col > colStart && index < maxSize)
            {
                result.add(matrix[row][col]);
                col--;
                index++;
            }
            
            while (row > rowStart && index < maxSize)
            {
                result.add(matrix[row][col]);
                row--;
                index++;
            }
            rowStart++;
            colStart++;
            colMax--;
            rowMax--;
        }
        
        return result;
    }
    
    
    /**
     *
     * 参考答案，我的思路是对的，但是细节控制有问题
     *
     * @param matrix
     * @return
     */
    public static ArrayList<Integer> spiralOrder_12(int[][] matrix){
        ArrayList<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return result;
        }
        int up = 0;
        int down = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
    
        while(true){
            // 最上面一行
            for(int col=left;col<=right;col++){
                result.add(matrix[up][col]);
            }
            // 向下逼近
            up++;
            // 判断是否越界
            if(up > down){
                break;
            }
            // 最右边一行
            for(int row=up;row<=down;row++){
                result.add(matrix[row][right]);
            }
            // 向左逼近
            right--;
            // 判断是否越界
            if(left > right){
                break;
            }
            // 最下面一行
            for(int col=right;col>=left;col--){
                result.add(matrix[down][col]);
            }
            // 向上逼近
            down--;
            // 判断是否越界
            if(up > down){
                break;
            }
            // 最左边一行
            for(int row=down;row>=up;row--){
                result.add(matrix[row][left]);
            }
            // 向右逼近
            left++;
            // 判断是否越界
            if(left > right){
                break;
            }
        }
        
        return result;
    }
}
