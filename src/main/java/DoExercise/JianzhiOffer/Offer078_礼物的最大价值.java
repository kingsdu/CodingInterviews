package DoExercise.JianzhiOffer;

/**
 * @Author: Du
 * @Date: 2021/7/10 8:15
 * <p>
 * https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 */
public class Offer078_礼物的最大价值
{
    
    public static void main(String[] args)
    {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(maxValue1(grid));
    }
    
    public static int maxValue1(int[][] grid)
    {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (i == 0 && j == 0) continue;
                if (i == 0) grid[i][j] += grid[i][j - 1];
                else if (j == 0) grid[i][j] += grid[i - 1][j];
                else grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[m - 1][n - 1];
    }
    
    /**
     *
     * 逻辑更清晰，但是需要一个额外的dp空间
     *
     * @param grid
     * @return
     */
    public static int maxValue2(int[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[m][n];
    }
    
    
    /**
     * 自己本能的想到的边界探寻法，在做的时候就发现有问题了，因为这种方法只能确定i+1 j+1位置的大小
     * 如果存在想到的情况，就无法判断了
     *
     * @param grid
     * @return
     */
    public static int error_maxValue(int[][] grid)
    {
        int sum = grid[0][0], i = 0, j = 0;
        int row = grid.length;
        int col = grid[0].length;
        while (i < row && j < col)
        {
            if (i + 1 < row && j + 1 < col)
            {
                if (grid[i + 1][j] < grid[i][j + 1])
                {
                    sum += grid[i][j + 1];
                    j++;
                } else if (grid[i + 1][j] > grid[i][j + 1])
                {
                    sum += grid[i + 1][j];
                    i++;
                }
            } else if (i + 1 < row)
            {
                sum += grid[i + 1][j];
                i++;
            } else if (j + 1 < col)
            {
                sum += grid[i][j + 1];
                j++;
            } else
            {
                break;
            }
        }
        return sum;
    }
}
