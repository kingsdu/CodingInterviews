package Jianzhi_Offer;

/**
 * 矩阵覆盖
 * <p>
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * <p>
 * 题目分析：
 * n=1时，只能有横着覆盖，1种
 * n=2时，有横着和竖着覆盖，2中
 * n=3时，（1）若第3级横着覆盖，用了1级，剩下n=2，有2中覆盖方式；（2）若第3级竖着覆盖，用了2级，剩下n=1，有1中覆盖方式，共3种
 * n=4时，（1）若第4级横着覆盖，用了1级，剩下n=3，有3种覆盖方式；（2）若第4级竖着覆盖，用了2级，剩下n=2，有2中覆盖方式，共5种
 * ......
 * 在n=n时，（1）若第n级横着覆盖，用了1级，剩下n=n-1;（2）若第n级竖着覆盖，用了2级，剩下n=n-2;
 */
public class RectCover
{

    public static void main(String[] args)
    {
        RectCover rectCover = new RectCover();
        System.out.println(rectCover.rectCoverMethod(4));
    }

    public int rectCoverMethod(int target)
    {
        if(target < 1){
            return 0;
        }

        if (target <= 2)
        {
            return target;
        } else
        {
            return rectCoverMethod(target-1)+rectCoverMethod(target-2);
        }
    }


}
