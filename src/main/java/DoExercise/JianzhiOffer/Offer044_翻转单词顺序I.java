package DoExercise.JianzhiOffer;


/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 * <p>
 * https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 */
public class Offer044_翻转单词顺序I
{
    
    public static void main(String[] args)
    {
        String s = "  a good,   example.  ";
        System.out.println(reverseWords(s));
    }
    
    /**
     *
     * 大小指针
     *
     * @param s
     * @return
     */
    public static String reverseWords(String s)
    {
        s = s.trim();
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while (i >= 0)
        {
            while (i >= 0 && s.charAt(i) != ' ') i--;
            res.append(s.substring(i + 1, j + 1) + " ");
            while (i >= 0 && s.charAt(i) == ' ') i--;
            j = i;
        }
        return res.toString().trim();
    }
    
    /**
     * 正则表达式
     *
     * @param str
     * @return
     */
    public static String ReverseSentence_1(String str)
    {
        if (null == str || str.length() == 0)
        {
            return "";
        }
        String strRes = "";
        
        String[] split = str.split("\\s+");
        for (int i = split.length - 1; i >= 0; i--)
        {
            strRes += split[i] + " ";
        }
        
        return strRes.substring(0, strRes.length() - 1);
    }
    
}
