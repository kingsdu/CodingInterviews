package DoExercise.JianzhiOffer;

/**
 * 题目：不用各类循环、判断条件的累加1~n
 *
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * <p>
 * 输入: n = 3
 * 输出: 6
 * <p>
 * 输入: n = 9
 * 输出: 45
 * <p>
 * 考点：递归，不用if的方式
 */
public class Offer047_SumSolution
{
    
    public static void main(String[] args)
    {
        System.out.println(sumNums_1(3));
    }
    
    /**
     *
     * n > 1 && sumNums(n - 1) // 当 n = 1 时 n > 1 不成立 ，此时 “短路” ，终止后续递归
     *
     */
    static int res = 0;
    public static int sumNums_1(int n)
    {
        boolean x = n > 1 && sumNums_1(n - 1) > 0;
        res += n;
        return res;
    }
    
    
    public static int sumNums_2(int n)
    {
        boolean x = n > 1 && (n += sumNums_2(n - 1)) > 0;
        return n;
    }
    
}
