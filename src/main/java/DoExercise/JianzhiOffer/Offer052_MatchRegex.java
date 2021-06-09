package DoExercise.JianzhiOffer;

/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * <p>
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Offer052_MatchRegex
{
    public static void main(String[] args)
    {
        String str = "aaa";
        String pattern = "a*a*c*a";
        System.out.println(match_2(str, pattern));
    }
    
    
    /**
     *
     * 当 p[j - 1] = '*' 时， dp[i][j] 在当以下任一情况为true 时等于true ：
     *      dp[i][j - 2]： 即将字符组合 p[j - 2] * 看作出现 0 次时，能否匹配；
     *      dp[i - 1][j] 且 s[i - 1] = p[j - 2]: 即让字符 p[j - 2] 多出现 1 次时，能否匹配；
     *      dp[i - 1][j] 且 p[j - 2] = '.': 即让字符 '.' 多出现 1 次时，能否匹配；
     * 当 p[j - 1] != '*' 时， dp[i][j] 在当以下任一情况为 true 时等于 true：
     *      dp[i - 1][j - 1] 且 s[i - 1] = p[j - 1]： 即让字符 p[j - 1] 多出现一次时，能否匹配；
     *      dp[i - 1][j - 1] 且 p[j - 1] = '.'： 即将字符 . 看作字符 s[i - 1] 时，能否匹配；
     */
    public static boolean match_2(String s, String p)
    {
        int m = s.length() + 1, n = p.length() + 1;
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = true;
        for (int j = 2; j < n; j += 2)
            dp[0][j] = dp[0][j - 2] && p.charAt(j - 1) == '*';//当p[j - 1] = '*' 且存在dp[i][j - 2]为 true，时为 true
        for (int i = 1; i < m; i++)
        {
            for (int j = 1; j < n; j++)
            {
                dp[i][j] = p.charAt(j - 1) == '*' ?
                        dp[i][j - 2] || dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') :
                        dp[i - 1][j - 1] && (p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1));//p前面是. OR p前一个位置值 == s前一个位置值
            }
        }
        return dp[m - 1][n - 1];
    }
    
    /**
     *
     * https://www.bilibili.com/video/BV13g4y1a7JV?from=search&seid=2803592586279083066
     *
     * 这个解法牛客网没通过
     *
     * @param str
     * @param pattern
     * @return
     */
    public static boolean match_1(String str, String pattern)
    {
        int s = str.length();
        int p = pattern.length();
        char[] chars = str.toCharArray();
        char[] patternChar = pattern.toCharArray();
        boolean[][] dp = new boolean[s + 1][p + 1];//00 用于存放两个空字符串的结果 dp[i][j] 表示模式串前j个是否与字符串前i个匹配
        dp[0][0] = true;
        for (int i = 1; i < p + 1; i++)
        {
            if (patternChar[i - 1] == '*')
            {
                dp[0][i] = dp[0][i - 2];
            } else
            {
                dp[0][i] = false;
            }
        }
        
        for (int i = 1; i < s + 1; i++)
        {
            for (int j = 1; j < p + 1; j++)
            {
                int ii = i - 1, jj = j - 1;
                if (patternChar[jj] == '.' || patternChar[jj] == chars[ii])
                {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (patternChar[jj] == '*') // 这个地方没理解
                {
                    if (chars[ii] == patternChar[jj - 1] || patternChar[jj - 1] == '*')
                    {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                    } else
                    {
                        dp[i][j] = dp[i][j - 2];
                    }
                } else
                {
                    dp[i][j] = false;
                }
            }
        }
        return dp[str.length()][pattern.length()];
    }
  
    
    
    public static boolean match(char[] str, char[] pattern)
    {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
    
        for (char x : str)
        {
            s1.append(x);
        }
        for (char x : pattern)
        {
            s2.append(x);
        }
        return solve(s1.toString(), s2.toString(), 0, 0);
    }
    
    
    /**
     *
     * 搜索的方法
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p)
    {
        return solve(s, p, 0, 0);
    }
    
    /**
     * 字符串匹配
     *
     * @param s      字符串1
     * @param p      字符串2
     * @param index1 字符串1的下标
     * @param index2 字符串2的下标
     * @return 当前s和p的匹配结果
     */
    private static boolean solve(String s, String p, int index1, int index2)
    {
        
        // 递归终止条件1
        if (index1 == s.length() && (index2 == p.length() || (index2 + 1 == p.length() - 1 && p.charAt(index2 + 1) == '*')))
        {
            return true;
        }
        
        // 递归终止条件2
        if (index1 == s.length() || p.length() == index2)
        {
            if (index1 == s.length())
            {
                return change(p, index2);
            } else
            {
                return false;
            }
        }
        
        // p当前字符的下一个位置的字符时*
        if (index2 + 1 < p.length() && p.charAt(index2 + 1) == '*')
        {
            if (judge(s.charAt(index1), p.charAt(index2)))
            {
                return solve(s, p, index1, index2 + 2) || solve(s, p, index1 + 1, index2);
            } else
            {
                return solve(s, p, index1, index2 + 2);
            }
        }
        
        // 当前两个下标所指的字符匹配
        if (judge(s.charAt(index1), p.charAt(index2)))
        {
            return solve(s, p, index1 + 1, index2 + 1);
        }
        
        return false; // 当前的index1所指的字符与index2所指的字符不一致
    }
    
    private static boolean change(String p, int index2)
    {
        while (index2 < p.length())
        {
            if (index2 + 1 < p.length() && p.charAt(index2 + 1) == '*')
            {
                index2 += 2;
            } else
            {
                return false;
            }
        }
        return true;
    }
    
    /**
     * @param s1 字符1
     * @param s2 字符2
     * @return 两个字符是否匹配的结果
     */
    private static boolean judge(char s1, char s2)
    {
        if (s1 == s2 || s2 == '.')
        {
            return true;
        }
        return false;
    }
    

}
