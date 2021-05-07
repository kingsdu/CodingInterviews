package JianzhiOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 约瑟夫问题
 * <p>
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
 * <p>
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * <p>
 * 输入: n = 5, m = 3
 * 输出: 3
 * <p>
 * 输入: n = 10, m = 17
 * 输出: 2
 */
public class Offer046_LastRemaining
{
    
    
    public static void main(String[] args)
    {
        int n = 7, m = 3;
        System.out.println(LastRemaining_Solution_3(n, m));
    }
    
    
    /**
     * 我的第一个思路想的是用System.arraycopy方法
     * 思路虽然不对，但是也是研究了这个方法的使用
     */
    public static int LastRemaining_Solution_1()
    {
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        int i = 3;
        int idx = 0;
        int size = arr.length;
        while (size > 1)
        {
            System.arraycopy(arr, 0, arr, 0, i - 1);
            System.arraycopy(arr, i, arr, i - 1, arr.length - i - idx++);
            size--;
        }
        return arr[0];
    }
    
    /**
     * 这个思路就是我最初的思路，但是我卡在数组中没出来
     * 这个问题，我卡住了，想了很久被绕进入了，没出来，其实我大概知道怎么做，也找出了正确的答案，但是没完成自己的推理
     *
     * 看了大神的解析后明白，自己的思路是正确的
     *
     * 大神的解释：
     * 假设当前删除的位置是 idx，下一个删除的数字的位置是 idx + m。但是，由于把当前位置的数字删除了，后面的数字会前移一位，
     * 所以实际的下一个位置是 idx+m−1。
     * 由于数到末尾会从头继续数，所以最后取模一下，就是 (idx + m - 1) \ (modn)。
     *
     * 每次求出会被移出的数字下标
     * @param n
     * @param m
     * @return
     */
    public static int LastRemaining_Solution_2(int n, int m)
    {
        if (n <= 0 || m <= 0)
        {
            return -1;
        }
        
        List<Integer> list = new ArrayList<>();
        
        int size = n;
        for (int i = 0; i < n; i++)
        {
            list.add(i);
        }
        
        int idx = 0;
        while (size > 1)
        {
            idx = (idx + m - 1) % size;
            System.out.println(idx);
            list.remove(idx);
            size--;
        }
        
        return list.get(0);
    }
    
    /**
     *
     * 还有一种方法是递归的逆推法，从后向前
     * 假设 0 1 2 3 4 5 6 7
     * 每轮移动3位
     * 如果我们一轮一轮的推演，最后一个剩下来的数字是6
     * 现在我们逆推，
     * 在最后一轮，剩下1个数字，它的下标一定是0
     * 倒数第二轮，剩下2个数字，下标为 (0+3)%2=1
     * 第六轮，剩下3个数字，下标为 (1+3)%3=1
     * 第五轮，剩下4个数字，下标为 (1+3)%4=0
     * 第四轮，剩下5个数字，下标为 (0+3)%5=3
     * 第三轮，剩下5个数字，下标为 (3+3)%6=0
     * 第二轮，剩下5个数字，下标为 (0+3)%7=3
     * 第一轮，剩下5个数字，下标为 (0+3)%8=3
     * @param n
     * @param m
     * @return
     */
    public static int LastRemaining_Solution_3(int n, int m){
        int pos = 0;
        for (int i = 2; i <= n; i++)
        {
            pos = (pos + m) % i;
            System.out.println(pos);
        }
        return pos;
    }
    
    
    /**
     *
     * 还有一种方法是用循环链表
     * D:\Project\IDEA\CodingInterviews\src\main\java\DataStruct\HSP\Day04\Josephu.java
     *
     *
     */
    
}
