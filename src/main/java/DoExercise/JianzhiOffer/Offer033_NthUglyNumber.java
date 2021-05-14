package DoExercise.JianzhiOffer;


/**
 *
 * 中等：动态规划
 *
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * <p>
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * <p>
 * 1 是丑数。
 * n 不超过1690。
 */
public class Offer033_NthUglyNumber
{
    
    
    public static void main(String[] args)
    {
        Offer033_NthUglyNumber of = new Offer033_NthUglyNumber();
        int i = of.nthUglyNumber_1(2);
        System.out.println(i);
    }
    
    /**
     * 动态规划：
     * <p>
     * 丑数 = 某较小丑数 * 某因子（2 3 5）
     * 丑数 = min(某较小丑数 * 某因子（2 3 5）)
     *
     * @param n
     * @return
     */
    public int nthUglyNumber_1(int n)
    {
        if (n <= 0) return 0;
        if (n == 2) return 2;
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++)
        {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (dp[i] == n2) a++;
            if (dp[i] == n3) b++;
            if (dp[i] == n5) c++;
        }
        return dp[n - 1];
    }
}
