package DoExercise.JianzhiOffer;

/**
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class TestDay
{
    
    
    public static void main(String[] args)
    {
    
    }
    
    
    public int cuttingRope(int n)
    {
        int dp[] = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i < n + 1; i++)
        {
            for (int j = 2; j < i; j++)
            {
                dp[i] = Math.max(dp[i], j * Math.max(dp[i - j], i - j));
            }
        }
        return dp[n];
    }
    
    
}
