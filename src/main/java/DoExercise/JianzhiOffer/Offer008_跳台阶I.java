package DoExercise.JianzhiOffer;


/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class Offer008_跳台阶I
{
    
    
    public static void main(String[] args)
    {
        int n = 0;
        System.out.println(jumpWOW1(n));
        System.out.println(jumpWOW2(n));
        
    }
    
    
    /**
     * 思路：青蛙每一次向上跳跃只有2种选择，跳1格 或者跳2格
     * 若是跳1格，则青蛙此时处于n-1级台阶，若是跳2格，则青蛙此时处于n-2级台阶
     * 所以，对于第n个台阶的跳法总是依赖于 n-1 和  n-2的跳法总数之和
     * 递推公式f(n)=f(n-1)+f(n-2):就是斐波那契数列求和
     *
     * @param target
     * @return
     */
    public static int jumpWOW1(int target)
    {
    
        if (target < 1)
        {
            return 1;
        }
        
        if (target == 1)
        {
            return 1;
        }
        if (target == 2)
        {
            return 2;
        }
        
        return jumpWOW1(target - 1) + jumpWOW1(target - 2);
    }
    
    
    public static int jumpWOW2(int n)
    {
        if (n < 1)
        {
            return 1;
        }
        if (n == 1 || n == 2)
        {
            return n;
        }
        
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++)
        {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }
}
