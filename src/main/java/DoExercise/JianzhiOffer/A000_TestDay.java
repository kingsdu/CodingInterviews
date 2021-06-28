package DoExercise.JianzhiOffer;

//0620:要刷的三道题:12;20;9
//0621:要刷的三道题:13;11;22
//0622:要刷的三道题:7;13;6
//0624:要刷的三道题:6;57;1
//0628:要刷的三道题:7;8;3
public class A000_TestDay
{
    
    public static void main(String[] args)
    {
        Offer000_Common.randomTM(31);
    }
    
    public int fib(int n)
    {
        if (n == 1 || n == 2) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 1; i <= n; i++)
        {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }
    
}
