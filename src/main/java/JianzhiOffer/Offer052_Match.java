package JianzhiOffer;

/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * <p>
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Offer052_Match
{
    public static void main(String[] args)
    {
        String str = "aaa";
        String pattern = "ab*ac*a";
        System.out.println(match_1(str, pattern));
    }
    
    public static boolean match(String str, String pattern)
    {
        if (str == null || pattern == null)
        {
            return false;
        }
        
        char[] chars = str.toCharArray();
        char[] patternChar = pattern.toCharArray();
        int i = 0;
        while (i < chars.length)
        {
            if (chars[i] != patternChar[i])
            {
                if (patternChar[i] == '.')
                {
                    i++;
                    continue;
                } else if (patternChar[i] == '*')
                {
                    char pre = ' ', next = ' ';
                    if (i + 1 < patternChar.length)
                    {
                        next = patternChar[i + 1];
                    }
                    
                    if (i - 1 >= 0)
                    {
                        pre = patternChar[i - 1];
                    }
                    
                    if (pre == chars[i])
                    {
                        continue;
                    } else if (chars[i] == next)
                    {
                        i++;
                        continue;
                    } else
                    {
                        return false;
                    }
                } else if (i < patternChar.length - 1 && patternChar[i + 1] == '*')
                {
                    char next = ' ';
                    if (i + 2 < patternChar.length - 1)
                    {
                        next = patternChar[i + 2];
                    }
                    
                    if (next == chars[i])
                    {
                        i++;
                        continue;
                    } else
                    {
                        return false;
                    }
                } else
                {
                    return false;
                }
            }
            i++;
        }
        
        return i == chars.length;
    }
    
    
    public static boolean match_1(String str, String pattern)
    {
        int s = str.length();
        int p = pattern.length();
        boolean[][] dp = new boolean[s + 1][p + 1];//00 用于存放两个空字符串的结果 dp[i][j] 表示模式串前j个是否与字符串前i个匹配
        for (int i = 0; i <= s; i++)
        {//实际上模式串和字符串的起点为1(所以后面的下标都是i-1 j-1)
            for (int j = 0; j <= p; j++)
            {
                if (j == 0)
                {
                    dp[i][j] = (i == 0);//只有字符串和模式串都为空的时候才匹配，当模式串为空，字符串不为空则返回false
                } else
                {
                    if (pattern.charAt(j - 1) != '*')
                    {   //如果第j-1个字符不是*
                        if (i > 0 && (str.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '.'))
                        {
                            //正常匹配
                            dp[i][j] = dp[i - 1][j - 1];
                        }
                    } else
                    {   //如果第j个是* 那么分两种情况，有一种成立即可
                        //case 1 可以直接忽略*前模式的那个元素（*代表出现0次 比如a* 这两个元素做空字符串）
                        //那么dp[i][j]==true 只需满足 dp[i][j-2]==true即可
                        if (j >= 2)
                        {
                            dp[i][j] = dp[i][j - 2];
                        }
                        //case 2 如果dp[i][j-2]不等于true那么要满足第j-1个字符(这个字符也可以为‘.’)与第i个字符匹配即可
                        //下标多减1是因为dp是从1开始记录的
                        if (i > 0 && j >= 2 && (str.charAt(i - 1) == pattern.charAt(j - 2) || pattern.charAt(j - 2) == '.'))
                        {
                            dp[i][j] |= dp[i - 1][j];//使用或等于 两种情况有一种符合就行
                        }
                    }
                }
            }
        }
        return dp[str.length()][pattern.length()];
    }
}
