package DoExercise.JianzhiOffer;

/***
 *
 *
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 *
 */

public class Offer001_二维数组中的查找
{
    
    public static void main(String[] args)
    {
        int target = 11;
        int[][] arrayTar = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(findNumberIn2DArray(arrayTar, target));
    }
    
    
    public static boolean findNumberIn2DArray(int[][] matrix, int target)
    {
        if (matrix.length == 0) return false;
        int row = matrix[0].length - 1;
        int col = matrix.length - 1;
        int i = 0, j = col;
        while (i <= row && j >= 0)
        {
            if (matrix[j][i] < target)
            {
                i++;
            } else if (matrix[j][i] > target)
            {
                j--;
            } else
            {
                return true;
            }
        }
        return false;
    }
}
