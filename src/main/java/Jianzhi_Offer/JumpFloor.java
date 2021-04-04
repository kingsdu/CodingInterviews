package Jianzhi_Offer;


/**
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 */
public class JumpFloor
{


    public static void main(String[] args)
    {
        JumpFloor jumpFloor = new JumpFloor();
        System.out.println(jumpFloor.jumpWOW(4));
    }


    /**
     *
     *
     * 思路：青蛙每一次向上跳跃只有2种选择，跳1格 或者跳2格
     * 若是跳1格，则青蛙此时处于n-1级台阶，若是跳2格，则青蛙此时处于n-2级台阶
     * 所以，对于第n个台阶的跳法总是依赖于 n-1 和  n-2的跳法总数之和
     * 递推公式f(n)=f(n-1)+f(n-2):就是斐波那契数列求和
     *
     * @param target
     * @return
     */
    public int  jumpWOW(int target){

        assert (target <= 0);

        if(target == 1){
            return 1;
        }
        if(target == 2){
            return 2;
        }

        return jumpWOW(target-1) + jumpWOW(target-2);
    }
}
