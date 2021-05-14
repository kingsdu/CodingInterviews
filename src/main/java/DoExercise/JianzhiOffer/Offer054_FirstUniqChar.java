package DoExercise.JianzhiOffer;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 后台会用以下方式调用Insert 和 FirstAppearingOnce 函数
 *
 * 这个题目不难，也已经出现很多次了。
 * 该题的重点应该是：如何在现有的代码结构中实现功能。
 *
 */
public class Offer054_FirstUniqChar
{
    static int[] hashArray = new int[256];
    static StringBuffer sb = new StringBuffer();
    
    
    public static void main(String[] args)
    {
        String str = "google";
        char[] chars = str.toCharArray();
        //循环调用方法，不推荐
        for (int i = 0; i < chars.length; i++)
        {
            Insert(chars[i]);
        }
    
        System.out.println(FirstAppearingOnce());
    }
    
    public static void Insert(char ch)
    {
        sb.append(ch);
        if (hashArray[ch] == 0)
        {
            hashArray[ch] = 1;
        } else
        {
            hashArray[ch] += 1;
        }
    }
    
    public static char FirstAppearingOnce()
    {
        char[] strS = sb.toString().toCharArray();
        for (char c : strS)
        {
            if (hashArray[c] == 1)
            {
                return c;
            }
        }
        return '#';
    }
}
