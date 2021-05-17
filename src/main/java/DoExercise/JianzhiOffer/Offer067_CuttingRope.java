package DoExercise.JianzhiOffer;

/**
 * 给你一根长度为 n 的绳子，
 * 请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1]。
 * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * <p>
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class Offer067_CuttingRope
{
    
    public static void main(String[] args)
    {
        System.out.println(cuttingRope1(10));
    }
    
    
    /**
     * 动态规划
     * <p>
     * 长度为n的绳子，至少减一刀
     * 一共有n-1中剪法
     * 假设剪下的长度是j，剩下长度是n-j
     * f(n) = max(j*max(f(n-j),n-j));
     *
     * @param n
     * @return
     */
    public static int cuttingRope1(int n)
    {
        int[] dp = new int[n + 1];
        dp[2] = 1;//初始化dp[2] = 1 表示如果一个绳子长度为2必然只能分成两段长度为1的绳子，两者的乘积为1。
        for (int i = 3; i <= n; ++i)
        {
            for (int j = 1; j <= i - 2; ++j)//默认绳子长度 > 3开始
            {
                // 不剪则得到的长度乘积为 j * (i - j)
                // 如果剪得到的长度为 j * dp[i - j]两者取最大值
                dp[i] = Math.max(dp[i], j * Math.max((i - j), dp[i - j]));//dp[i - j]是之前剪掉后最大的长度。
            }
        }
        return dp[n];
    }
}
