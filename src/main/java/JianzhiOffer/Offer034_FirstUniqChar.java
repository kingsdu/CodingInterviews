package JianzhiOffer;


import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 简单：哈希排序
 *
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 剑指Offer 中的要求：不是找出元素，是找出对应下标
 *
 * <p>
 * <p>
 * s = "abaccdeff"
 * 返回 "b"
 * <p>
 * s = ""
 * 返回 " "
 * <p>
 * 难度：简单但是我没想出来
 */
public class Offer034_FirstUniqChar
{
    
    
    public static void main(String[] args)
    {
        String s = "abaccdeffab";
        Offer034_FirstUniqChar of = new Offer034_FirstUniqChar();
        char c1 = of.firstUniqChar_1(s);
        System.out.println(c1);
        char c2 = of.firstUniqChar_2(s);
        System.out.println(c2);
        char c3 = of.firstUniqChar_3(s);
        System.out.println(c3);
        char c4 = of.firstUniqChar_4(s);
        System.out.println(c4);
        char c5 = of.firstUniqChar_5(s);
        System.out.println(c5);
    }
    
    /**
     * 方法1，数组映射
     * <p>
     * 因为题目告诉输入都是小写字母，所以可以通过-a，将其映射到数组中
     * <p>
     * 也可以改成求位置的题
     *
     * @param s
     * @return
     */
    public char firstUniqChar_1(String s)
    {
        if (s == null || s.length() == 0) return ' ';
        char[] charArr = new char[26];
        char[] chars = s.toCharArray();
        
        for (char c :
                chars)
        {
            charArr[c - 'a']++;
        }
        
        for (int i = 0; i < chars.length; i++)
        {
            if (charArr[chars[i] - 'a'] == 1)
            {
                return chars[i];
            }
        }
        
        return ' ';
    }
    
    
    /**
     * 使用无序哈希表
     * <p>
     * 需要遍历2次
     *
     * @param s
     * @return
     */
    public char firstUniqChar_2(String s)
    {
        if (s == null || s.length() == 0) return ' ';
        
        HashMap<Character, Boolean> map = new HashMap<>();
        char[] chars = s.toCharArray();
        
        for (char c :
                chars)
        {
            //只要出现2次及以上，则value为false
            map.put(c, !map.containsKey(c));
        }
        
        for (char c :
                chars)
        {
            if (map.get(c))
            {
                return c;
            }
        }
        
        return ' ';
    }
    
    
    /**
     * 使用有序哈希表
     * <p>
     * 循环遍历1次
     *
     * @param s
     * @return
     */
    public char firstUniqChar_3(String s)
    {
        if (s == null || s.length() == 0) return ' ';
        
        HashMap<Character, Boolean> dic = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for (char c :
                sc)
        {
            dic.put(c, !dic.containsKey(c));
        }
        
        for (Map.Entry<Character, Boolean> entry :
                dic.entrySet())
        {
            if (entry.getValue())
            {
                return entry.getKey();
            }
        }
        
        return ' ';
    }
    
    
    /**
     * 通过hashset解决该问题
     * <p>
     * 思路：循环遍历，判断是否存在，当存在，将存在的字符置为''
     * 返回第一个字母即可
     *
     * @param s
     * @return
     */
    public char firstUniqChar_4(String s)
    {
        if (s == null || s.length() == 0) return ' ';
        
        HashSet<Character> set = new HashSet<>();
        
        for (char c :
                s.toCharArray())
        {
            if (set.contains(c))
            {
                s = s.replace(String.valueOf(c), "");
            } else
            {
                set.add(c);
            }
        }
        
        return s.isEmpty() ? ' ' : s.charAt(0);
    }
    
    
    /**
     *
     *
     * 没找到都返回-1
     *
     * 赖皮方法。。。
     *
     * 知识：indexOf 、 lastIndexOf
     * 当没找到时都会返回-1；
     * @param str
     * @return
     */
    public char firstUniqChar_5(String str)
    {
        int m = -1;
        for (int i = 0; i < str.length(); i++)
        {
            //没找到都返回-1
            if (str.indexOf(str.charAt(i)) == str.lastIndexOf(str.charAt(i)))
            {
                m = i;
                break;//可能有多组，只取第一个
            }
        }
        return str.charAt(m);
    }
    
}
