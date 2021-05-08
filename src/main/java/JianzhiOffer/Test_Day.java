package JianzhiOffer;

/**
 * <p>
 * 题目：
 * 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 * <p>
 * 输入：10，输出：2
 * <p>
 */
public class Test_Day
{
    
    public static void main(String[] args)
    {
        System.out.println(outPutNumber(-10));
    }
    
    public static int outPutNumber(int x){
        int count = 0;
        while (x != 0){
            x &= (x-1);
            count++;
        }
        return count;
    }
}
