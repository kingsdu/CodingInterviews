package DoExercise.JianzhiOffer;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，
 * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * <p>
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 */
public class Offer066_MovingCount
{
    
    public static void main(String[] args)
    {
        System.out.println(movingCount1(0, 1, 3));
    }
    
    public static int movingCount1(int threshold, int rows, int cols)
    {
        boolean[][] visited = new boolean[rows][cols];
        return dfs(0, 0, threshold, rows, cols, visited);
    }
    
    public static int dfs(int i, int j, int threshold, int rows, int cols, boolean[][] visited)
    {
        if (i >= rows || j >= cols || calSum(i, j) > threshold || visited[i][j])
        {
            return 0;
        }
        visited[i][j] = true;
        //难点是此处调用下面方法的写法
        return 1 + dfs(i, j + 1, threshold, rows, cols, visited) + dfs(i + 1, j, threshold, rows, cols, visited);
    }
    
    
    public static int calSum(int i, int j)
    {
        int sum = 0;
        while (i > 0)
        {
            sum += i % 10;
            i /= 10;
        }
        
        while (j > 0)
        {
            sum += j % 10;
            j /= 10;
        }
        
        return sum;
    }
    
    
    /**
     *
     * 动态规划解决问题
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public static int movingCount2(int m, int n, int k)
    {
        //状态：dp[i][j]代表第i,j个格子能否走到
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = isValid(0, 0, k);
        //转移方程
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (i == 0 && j == 0) continue;
                else if (i == 0) dp[i][j] = isValid(i, j, k) && dp[i][j - 1];
                else if (j == 0) dp[i][j] = isValid(i, j, k) && dp[i - 1][j];
                else dp[i][j] = isValid(i, j, k) && (dp[i - 1][j] || dp[i][j - 1]);
            }
        }
        int count = 0;
        for (boolean[] row : dp)
        {
            for (boolean ele : row)
            {
                if (ele)
                {
                    count++;
                }
            }
        }
        return count;
    }
    
    
    
    public static boolean isValid(int i, int j, int k)
    {
        int sum = 0;
        while (i != 0)
        {
            sum += i % 10;
            i /= 10;
        }
        while (j != 0)
        {
            sum += j % 10;
            j /= 10;
        }
        return sum <= k;
    }
}
