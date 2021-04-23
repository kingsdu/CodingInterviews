package JianzhiOffer;

import java.util.*;

/**
 * 困难
 *
 * 输入一个字符串(长度不超过9(可能有字符重复),字符只包括大小写字母),按字典序打印出该字符串中字符的所有排列。
 * <p>
 * 例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * b c
 * a
 * c b
 * a c
 * b
 * c a
 * a b
 * c
 * b a
 * <p>
 * 思路
 * <p>
 * <p>
 * 1、从第一位开始需要找到所有可能的字符串，对于abc，就需要用a和a，a和b，a和c相互交换。
 * 2、当第一位a，确定后，对于后面只有bc两种，再对bc相互交换。
 * 3、每次当数组的长度达到满足字符长度后，存入该数组，返回递归。
 * 4、每次交换后需要将交换回位，在进行下次交换
 * 5、需要对重复元素减枝。
 */
public class Offer027_Permutation
{
    List<String> res = new LinkedList<>();
    char[] c;
    
    public static void main(String[] args)
    {
        String str = "abc";
        Offer027_Permutation of = new Offer027_Permutation();
        String[] permutation = of.permutation(str);
        for (String s:
                permutation)
        {
            System.out.print(s+" ");
        }
    }
    
    public String[] permutation(String s)
    {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }
    
    void dfs(int x)
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
    
    void swap(int a, int b)
    {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }
    
    
    /***
     *
     * ----------------------------------------------------------------------------------------------------
     * 和上面方法类似
     * -----------------------------------------------------------------------------------------------------
     *
     */
    
    private List<String> result = new LinkedList<String>();
    private StringBuilder curPath = new StringBuilder();
    private boolean[] used;
    
    public String[] permutation_2(String s)
    {
        if (s == null)
        {
            return null;
        }
        
        used = new boolean[s.length()];
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray); // 排序，方便后续的“剪枝”操作
        
        dfs_2(charArray, s.length(), 0);
        return result.toArray(new String[result.size()]);
    }
    
    
    private void dfs_2(char[] charArray, int targetLength, int curLength)
    {
        if (targetLength == curLength)
        {
            result.add(curPath.toString());
            return;
        }
        
        for (int i = 0; i < targetLength; i++)
        {
            if (!used[i])
            {
                if (i > 0 && charArray[i] == charArray[i - 1] && !used[i - 1])
                {    // 剪枝：元素相同
                    continue;
                }
                used[i] = true;
                curPath.append(charArray[i]);
                dfs_2(charArray, targetLength, curLength + 1);
                curPath.deleteCharAt(curPath.length() - 1);
                used[i] = false;
            }
        }
    }
    
    
    /**
     *
     * 下面思路没理解
     *
     * @param str
     * @return
     */
    public ArrayList<String> Permutation_3(String str)
    {
        ArrayList<String> res = new ArrayList<String>();
        if (str.length() == 0) return res;
        char[] array = str.toCharArray();
        Arrays.sort(array);
        String s = new String(array);
        res.add(str);
        while (true)
        {
            s = nextString_3(s);
            if (!s.equals("finish"))
            {
                res.add(s);
            } else
            {
                break;
            }
        }
        return res;
    }
    
    public String nextString_3(String str)
    {
        char[] array = str.toCharArray();
        int length = str.length();
        int i = length - 2;
        for (; i >= 0 && array[i] >= array[i + 1]; i--) ;
        if (i == -1) return "finish";
        int j = length - 1;
        for (; j >= 0 && array[j] <= array[i]; j--) ;
        //swap i,j
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
        //swap i,j
        for (int a = i + 1, b = length - 1; a < b; a++, b--)
        {
            tmp = array[a];
            array[a] = array[b];
            array[b] = tmp;
        }
        return new String(array);
    }
    
}
