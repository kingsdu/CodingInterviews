package JianzhiOffer;


/**
 *
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 *
 */
public class Offer044_ReverseSentence
{
    
    public static void main(String[] args)
    {
        String s = "a good,   example.";
        System.out.println(ReverseSentence_1(s));
    }
    
    
    /**
     *
     * 正则表达式
     *
     * @param str
     * @return
     */
    public static String ReverseSentence_1(String str) {
        if(null == str || str.length() == 0){return "";}
        String strRes = "";
        
        String[] split = str.split("\\s+");
        for (int i = split.length-1; i >= 0; i--)
        {
            strRes += split[i]+" ";
        }
    
        return strRes.substring(0,strRes.length()-1);
    }

}
