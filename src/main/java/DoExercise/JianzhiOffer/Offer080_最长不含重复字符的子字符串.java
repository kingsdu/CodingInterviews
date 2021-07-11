package DoExercise.JianzhiOffer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Author: Du
 * @Date: 2021/7/11 11:14
 */
public class Offer080_最长不含重复字符的子字符串
{
    
    public static void main(String[] args)
    {
        String s = "abcacbb";
        lengthOfLongestSubstring_动态规划(s);
    }
    
    
    public static int lengthOfLongestSubstring_滑动窗口(String s)
    {
        HashSet<Character> set = new HashSet<>();
        int i = 0, maxLen = 0;
        for (int j = 0; j < s.length(); j++)
        {
            while (set.contains(s.charAt(j)))
            {
                set.remove(s.charAt(i));
                i++;
            }
            maxLen = Math.max(maxLen, j - i + 1);
            set.add(s.charAt(j));
        }
        if (maxLen == 0) return 0;
        else return maxLen;
    }
    
    
    public static int lengthOfLongestSubstring_动态规划(String s)
    {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for (int j = 0; j < s.length(); j++)
        {
            int i = dic.getOrDefault(s.charAt(j), -1); // 获取索引 i
            dic.put(s.charAt(j), j); // 更新哈希表
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
        }
        return res;
    }
}
