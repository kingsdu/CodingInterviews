package JianzhiOffer;

import java.util.Random;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class Test_Day
{
    public static void main(String[] args)
    {
        System.out.println(Fb(8));
    }
    
    
    public static int Fb(int n)
    {
        boolean 是否选择自律 = true;
        boolean 外界刺激诱惑挑战 = true;
        while (是否选择自律 != 外界刺激诱惑挑战){
            System.out.println("再次陷入失败轮回");
        }
       return -1;
    }
    
}
