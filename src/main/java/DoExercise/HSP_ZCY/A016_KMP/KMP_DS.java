package DoExercise.HSP_ZCY.A016_KMP;

/**
 * 学习灯神的KMP算法
 *
 * https://www.bilibili.com/video/BV1Px411z7Yo?from=search&seid=18198245159123147889
 */
public class KMP_DS
{
    
    public static void main(String[] args)
    {
//        char pattern[] = {'A', 'B', 'A', 'B', 'C', 'A', 'B', 'A', 'A'};
//        int prefix[] = new int[9];
//        int n = 9;
        String pattern = "ABABCABAA";
        String text = "ABABABABCABAABABABAB";
        kmp_search(pattern, text);
    }
    
    /**
     * 搜索字符串中每个位置上的公共子串
     *
     * @param pattern
     * @param n
     */
    public static int[] prefix_table(char pattern[], int n)
    {
        int prefix[] = new int[n];
        prefix[0] = 0;
        int len = 0, i = 1;
        while (i < n)
        {
            //System.out.println(i + "   " + len);
            //匹配，则继续向后
            if (pattern[i] == pattern[len])
            {
                len++;
                prefix[i] = len;
                i++;
            } else
            {
                if (len > 0)
                {
                    len = prefix[len - 1];
                } else
                {
                    //到达最左侧的没有匹配
                    prefix[i] = len;
                    i++;
                }
            }
        }
        return move(prefix,n);
    }
    
    /**
     * 为了写代码的方便，我们直接让 prefix[] 后移一位。第一位设为-1，
     * 当成是前一个子串的所有前后缀也都匹配不上的情况。
     * 而 prefix[] 最后一个值可以不用移动，让他被前一个覆盖掉，因为他是无需用到的.
     *
     * @param prefix
     * @param n
     */
    public static int[] move(int prefix[], int n)
    {
        for (int i = n - 1; i > 0; i--)
        {
            prefix[i] = prefix[i - 1];
        }
        prefix[0] = -1;
        return prefix;
    }
    
    
    /**
     *
     * 实现的算法思路是KMP1视频讲解中的思路
     *
     * @param pattern
     * @param text
     */
    public static void kmp_search(String pattern, String text)
    {
        char patternChar[] = pattern.toCharArray();
        char textChar[] = text.toCharArray();
        int n = patternChar.length;
        int m = textChar.length;
        int[] prefix = prefix_table(patternChar, n);
        
        int i = 0, j = 0, ci = 0;
        while (i < m && j < n)
        {
            // j==n-1 对应 j 移动到 pattern 的最后一位，如果这一位仍然相等的成功匹配了
            if (j == n - 1 && textChar[i] == patternChar[j])
            {
                System.out.printf("找到了第 %d 个 ,起始位置在 %d 位置\n", ++ci, i - j);
                j = prefix[j];
                i++;
                continue;
            }
            
            if (textChar[i] == patternChar[j])
            {
                i++;
                j++;
            } else
            {
                j = prefix[j];
                if (j == -1)
                {
                    i++;
                    j++;
                }
            }
        }
    }
}
