package DoExercise.JianzhiOffer;


/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * <p>
 * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 * <p>
 * 这个题考虑动态规划，但是要明白方法1的意思
 */
public class Offer009_跳台阶II
{
    
    
    public static void main(String[] args)
    {
        System.out.println(numWays1(10));
        System.out.println(numWays2(10));
    }
    
    //该方法比后面的方法节省空间
    //注意这种 a b sum相互串联的方式
    public static int numWays1(int n)
    {
        int a = 1, b = 1;
        for (int i = 1; i < n; i++)
        {
            int sum = (a + b) % 1000000007;//n = (n-2 + n-1) % 1000_000_007
            a = b;//n-2
            b = sum;//n-1
        }
        return b;
    }
    
    public static int numWays2(int n)
    {
        if (n == 0 || n == 1 || n == 2) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++)
        {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000_000_007;
        }
        return dp[n];
    }
    
}
