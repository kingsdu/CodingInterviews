package DoExercise.JianzhiOffer;

/**
 * 数学问题：如何切的结果更大？
 *
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 2 <= n <= 1000（和上一题比较，范围变大了）
 *
 * 推论一： 将绳子 以相等的长度等分为多段 ，得到的乘积最大。
 * 推论二： 尽可能将绳子以长度 3 等分为多段时，乘积最大。
 *
 * 递推过程如下
 * https://www.bilibili.com/video/BV19a411A7ku?from=search&seid=13274648377156939323
 * https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/solution/mian-shi-ti-14-ii-jian-sheng-zi-iitan-xin-er-fen-f/
 */
public class Offer068_CuttingRope2
{
    public static void main(String[] args)
    {
        System.out.println(cuttingRope(125));
    }
    
    /**
     *
     * 推论一： 将绳子 以相等的长度等分为多段 ，得到的乘积最大。
     * 推论二： 尽可能将绳子以长度 3 等分为多段时，乘积最大。
     *
     *
     * @param n
     * @return
     */
    public static int cuttingRope(int n)
    {
        if (n < 4) return n - 1;
        long res = 1L;
        int p = (int) 1e9 + 7;
        //贪心算法，优先切三，其次切二
        //分成尽可能多的长度为3的小段，每次循环长度n减去3，乘积res乘以3；最后返回时乘以小于等于4的最后一小段；每次乘法操作后记得取余就行
        //n大于4时，就要切割成长度为3的小段，只要n还大于4，每切除一段3，就累乘起来，然后取模。
        while (n > 4)
        {
            res = res * 3 % p;
            n -= 3;
        }
        //出来循环只有三种情况，分别是n=2、3、4, 还需要将最后一个 因数 计算在内
        return (int) (res * n % p);
        //int 的最大值Integer.MAX_VALUE 是2,147,483,647，虽然在每一次循环都会去对p取模，
        //但是在res*3小于等于p的时候，res还是会等于res*3。假设某种情况下循环结束时res的值为1,000,000,000，
        //乘上3就会大于int的最大值，因此最后需要加上括号，取模后才不会溢出
    }
}
