package DoExercise.JianzhiOffer;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
 * n≤39
 * 0 1 1 2 3 5 8 13 21
 * 输入 4，输出 3
 * <p>
 * <p>
 * 斐波那契数列：这个数列从第3项开始，每一项都等于前两项之和。
 * An = An-1 + An-2
 * <p>
 * <p>
 * 为什么很多程序竞赛题目都要求答案对 1e9+7（1000000007） 取模？
 * https://www.zhihu.com/question/49374703
 * <p>
 * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 */
public class Offer007_斐波拉契数列
{
    
    
    public static void main(String[] args)
    {
        System.out.println(FibonaciiNum_1(5));
    }
    
    /**
     * 动态规划，这个是最合适处理这个问题的算法
     *
     * @param n
     * @return
     */
    public static int FibonaciiNum_1(int n)
    {
        if (n == 0 || n == 1) return n;
        int[] dp = new int[n + 1];
//        dp[0] = 0;//可以不写，因为初始化就是0
        dp[1] = 1;
        for (int i = 2; i <= n; i++)
        {
            dp[i] = dp[i - 1] + dp[i - 2];
            //1e9+7这个数，满足[0,1e9+7)内所有数，两个数相加不爆int，两个数相乘不爆long long；1e9+7是质数，所以在[1,1e9+7)内所有数都存在关于1e9+7的逆元
            dp[i] %= 1000000007;
        }
        return dp[n];
    }
    
    
    /**
     * 动态规划一般可以改成下面的模式
     *
     * @param n
     * @return
     */
    public static int FibonaciiNum_3(int n)
    {
        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++)
        {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
    
    
    /**
     * 递归
     * 在乐扣网上超时了
     *
     * @param num
     * @return
     */
    public static int FibonaciiNum_2(int num)
    {
        if (num == 0 || num == 1)
        {
            return num;
        }
        return FibonaciiNum_2(num - 1) + FibonaciiNum_2(num - 2);
    }
    
    
}
