package JianzhiOffer;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 * <p>
 * 输入：2,3
 * 输出：8.00000
 * <p>
 * 思路
 * 1、负数：一个数的负次方即为这个数的正次方的倒数。
 */
public class Test_Day
{
    
    public static void main(String[] args)
    {
        t1();
    }
    
    public static void outPutNumber(int x,int y)
    {
        byte b1=1,b2=2,b3,b6;
        final byte b4=4,b5=6;
        b6=b4+b5;
       // b3=b1+b2;
       // System.out.println(b3+b6);
    }
    
    public static void t1(){
        int num = 2;
        switch (num) {
            case 1:
                ++num;
            case 2:
                ++num;
            case 3:
                ++num;
            default:
                ++num;
                break;
        }
        System.out.println(num);
    }
    
    public static void t2(){
        final int x = 1;
    }

}
