package JianzhiOffer;

import java.util.ArrayList;

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
        outPutNumber();
    }
    
    public static void outPutNumber()
    {
        ArrayList<ArrayList<Integer>> lia = new ArrayList<>();
        ArrayList<Integer> li = null;
        for (int i = 0; i < 3; i++)
        {
            li = new ArrayList<>();
            for (int j = 0; j <= i; j++)
            {
                li.add(j);
            }
            lia.add(li);
        }
        System.out.println(lia);
    }
}
