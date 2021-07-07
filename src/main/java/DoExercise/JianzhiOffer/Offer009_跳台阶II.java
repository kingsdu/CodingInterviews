package DoExercise.JianzhiOffer;


/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * <p>
 * https://www.nowcoder.com/practice/22243d016f6b47f2a6928b4313c85387?tpId=13&tags=&title=&difficulty=0&judgeStatus=0&rp=1
 * <p>
 */
public class Offer009_跳台阶II
{
    
    
    public static void main(String[] args)
    {
        System.out.println(jumpFloorII(3));
    }
    
    
    public static int jumpFloorII(int target)
    {
        int[] dp = new int[target + 1];
        dp[1] = 1;
        for (int i = 2; i <= target; i++)
        {
            dp[i] = 2 * dp[i - 1];
        }
        return dp[target];
    }
    
    public static int jumpFloorII1(int target)
    {
        int ans = 1;
        for (int i = 2; i <= target; i++)
        {
            ans = 2 * ans;
        }
        return ans;
    }
}
