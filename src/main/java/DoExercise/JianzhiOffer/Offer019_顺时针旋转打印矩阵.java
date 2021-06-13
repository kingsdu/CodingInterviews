package DoExercise.JianzhiOffer;

import java.util.Arrays;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class Offer019_顺时针旋转打印矩阵
{
    
    
    public static void main(String[] args)
    {
        int[][] matrix = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        Arrays.stream(spiralOrder(matrix)).forEach(e -> System.out.print(e + " "));
    }
    
    
    public static int[] spiralOrder(int[][] matrix)
    {
        if (matrix.length == 0) return new int[0];
        int l = 0, r = matrix[0].length - 1, t = 0, d = matrix.length - 1;
        int x = 0;
        int[] res = new int[(r + 1) * (d + 1)];
        
        for (; ; )
        {
            for (int i = l; i <= r; i++) res[x++] = matrix[t][i];
            if (++t > d) break;
            for (int i = t; i <= d; i++) res[x++] = matrix[i][r];
            if (l > --r) break;
            for (int i = r; i >= l; i--) res[x++] = matrix[d][i];
            if (t > --d) break;
            for (int i = d; i >= t; i--) res[x++] = matrix[i][l];
            if (++l > r) break;//1 为什么要先存数，再判断？
        }
        return res;
    }
    
}
