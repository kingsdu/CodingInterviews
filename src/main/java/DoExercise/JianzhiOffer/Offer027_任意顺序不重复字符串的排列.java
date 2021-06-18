package DoExercise.JianzhiOffer;

import java.util.*;

/**
 * 困难
 * <p>
 * 输入一个字符串(长度不超过9(可能有字符重复),字符只包括大小写字母),按字典序打印出该字符串中字符的所有排列。
 * <p>
 * 例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * <p>
 * 思路
 * <p>
 * 1、从第一位开始需要找到所有可能的字符串，对于abc，就需要用a和a，a和b，a和c相互交换。
 * 2、当第一位a，确定后，对于后面只有bc两种，再对bc相互交换。
 * 3、每次当数组的长度达到满足字符长度后，存入该数组，返回递归。
 * 4、每次交换后需要将交换回位，在进行下次交换
 * 5、需要对重复元素减枝。
 */
public class Offer027_任意顺序不重复字符串的排列
{
    static List<String> res = new LinkedList<>();
    static char[] c;
    
    public static void main(String[] args)
    {
        String str = "abcd";
        String[] permutation = permutation(str);
        for (String s :
                permutation)
        {
            System.out.print(s + " ");
        }
    }
    
    public static String[] permutation(String s)
    {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }
    
    static void dfs(int x)
    {
        if (x == c.length - 1)
        {
            res.add(String.valueOf(c));      // 添加排列方案
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++)
        {
            if (set.contains(c[i])) continue; // 重复，因此剪枝
            set.add(c[i]);
            swap(i, x);                      // 交换，将 c[i] 固定在第 x 位
            dfs(x + 1);                      // 开启固定第 x + 1 位字符
            swap(i, x);                      // 恢复交换
        }
    }
    
    static void swap(int a, int b)
    {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }
    
    
}
