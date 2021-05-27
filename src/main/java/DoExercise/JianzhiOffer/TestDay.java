package DoExercise.JianzhiOffer;

/**
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class TestDay
{
    public static void main(String[] args)
    {
        String abc = "   ";
        System.out.println(replaceSpace(abc));
    }
    
    public static boolean findNumberIn2DArray(int[][] matrix, int target)
    {
        if (null == matrix || matrix.length == 0)
        {
            return false;
        }
        
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix[0].length)
        {
            if (matrix[i][j] < target)
            {
                j++;
            } else if (matrix[i][j] > target)
            {
                i--;
            } else
            {
                return true;
            }
        }
        return false;
    }
    
    public static String replaceSpace(String s)
    {
        StringBuilder ss = new StringBuilder();
        for (Character c : s.toCharArray())
        {
            if(c == ' '){
                ss.append("%20");
            }else {
                ss.append(c);
            }
        }
        return ss.toString();
    }
    
    
}
