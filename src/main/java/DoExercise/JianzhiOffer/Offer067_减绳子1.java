package DoExercise.JianzhiOffer;

/**
 * 数学问题：如何切的结果更大？
 *
 * 给你一根长度为 n 的绳子，
 * 请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1]。
 * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 *
 * 2 <= n <= 58
 *
 * <p>
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class Offer067_减绳子1
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
     * i 代表绳子的长度
     * j 代表每次剪断的绳子的长度
     * @return
     */
    public static int cuttingRope1(int n)
    {
        int[] dp = new int[n + 1];
        dp[2] = 1;//初始化dp[2] = 1 表示如果一个绳子长度为2必然只能分成两段长度为1的绳子，两者的乘积为1。
        for (int i = 3; i < n + 1; i++)//从3开始，因为2减一刀后就变成1了，对结果没影响
        {
            for (int j = 2; j < i; j++)//如果只剪掉长度为1，对最后的乘积无任何增益，所以从长度为2开始剪
            {   // 剪了第一段后，剩下(i - j)长度可以剪也可以不剪。
                // 不剪则得到的长度乘积为 j * (i - j)
                // 如果剪得到的长度为 j * dp[i - j]两者取最大值
                dp[i] = Math.max(dp[i], j * Math.max((i - j), dp[i - j]));//dp[i - j]是之前剪掉后最大的长度。
            }
        }
        return dp[n];
    }
    
    
    /**
     * 下面方法基于这样的推论
     *
     * 1 将绳子以相等的长度等分为多段 ，得到的乘积最大。
     * 2 尽可能把绳子分成长度为3的小段 ，这样乘积最大
     *
     * @param n
     * @return
     */
    public static int cuttingRope2(int n)
    {
        //如果 n == 2，返回1，如果 n == 3，返回2，两个可以合并成n小于4的时候返回n - 1
        if (n < 4)
        {
            return n - 1;
        }
        int res = 1;//如果 n == 4，返回4
        //如果 n > 4，分成尽可能多的长度为3的小段，每次循环长度n减去3，乘积res乘以3；最后返回时乘以小于等于4的最后一小段
        while (n > 4)
        {
            res *= 3;
            n -= 3;
        }
        return res * n;
    }
}
