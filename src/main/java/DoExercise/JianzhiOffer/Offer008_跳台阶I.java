package DoExercise.JianzhiOffer;


/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 *
 */
public class Offer008_跳台阶I
{
    
    
    public static void main(String[] args)
    {
        int n = 0;
        System.out.println(jumpWOW(n));
        System.out.println(jumpWOW1(n));
        System.out.println(jumpWOW2(n));
    }
    
    //该方法比后面的方法节省空间
    //注意这种 a b sum相互串联的方式
    public static int jumpWOW(int n)
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
    
    /**
     * 思路：青蛙每一次向上跳跃只有2种选择，跳1格 或者跳2格
     * 若是跳1格，则青蛙此时处于n-1级台阶，若是跳2格，则青蛙此时处于n-2级台阶
     * 所以，对于第n个台阶的跳法总是依赖于 n-1 和  n-2  的跳法总数之和
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
