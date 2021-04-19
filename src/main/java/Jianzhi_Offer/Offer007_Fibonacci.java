package Jianzhi_Offer;

import java.util.ArrayList;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
 * n≤39
 * 0 1 1 2 3 5 8 13 21
 * 输入 4，输出 3
 * <p>
 * <p>
 * 斐波那契数列：这个数列从第3项开始，每一项都等于前两项之和。
 * An = An-1 + An-2
 */
public class Offer007_Fibonacci
{


    public static void main(String[] args)
    {
        Offer007_Fibonacci fibonacci = new Offer007_Fibonacci();
        System.out.println(fibonacci.FibonaciiNum_3(-4));
    }


    public int FibonaciiNum_3(int num)
    {
        assert (num >= 0);//断言

        if (num == 0 || num == 1)
        {
            return num;
        }
        return FibonaciiNum_3(num - 1) + FibonaciiNum_3(num - 2);
    }


    public int FibonaciiNum_2(int num)
    {
        if (num == 0)
        {
            return 0;
        } else if (num == 1)
        {
            return 1;
        }
        return FibonaciiNum_2(num - 1) + FibonaciiNum_2(num - 2);
    }


    /**
     * 第一次写的错误的思路的程序，写不下去了
     * <p>
     * 本身希望生成一个FAB数列，后存在list中，在根据输入的数字映射至对应的list中
     * 但是问题是不知道如何生成一个FAB数列
     *
     * @param num
     * @return
     */
    public int FibonaciiNum_1(int num)
    {

        int n = 39, fab, fab_1 = 0, fab_2 = 0;
        ArrayList<Integer> fList = new ArrayList<>();
        for (int i = 0; i <= n; i++)
        {
            fab = fab_1 + fab_2;
        }

        return 0;
    }
}
