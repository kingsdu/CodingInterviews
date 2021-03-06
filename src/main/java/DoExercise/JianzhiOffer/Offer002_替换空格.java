package DoExercise.JianzhiOffer;

/***
 *
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * "We Are Happy"
 * "We%20Are%20Happy"
 *
 * 考点：1、String 到 char的转换
 *
 * Stringbuffer和StringBuilder的区别
 */
public class Offer002_替换空格
{
    
    
    public static void main(String[] args)
    {
        String str = "We Are Happy";
        Offer002_替换空格 rse = new Offer002_替换空格();
        System.out.println(rse.replace_2(str));
    }
    
    /**
     * 判断字符存在，找到对应位置截取
     *
     * @param str
     * @return
     */
    public String replace_1(String str)
    {
        if (str == null || str.length() == 0)
        {
            return "";
        }
        
        StringBuffer sbf = new StringBuffer();
        int index = 0;
        for (int i = 0; i < str.length(); i++)
        {
            char c = str.charAt(i);
            //char[] chars = str.toCharArray();
            if (c == ' ')
            {
                sbf.append(str.substring(index, i));
                sbf.append("%20");
                index = i + 1;
            }
        }
        if (index < str.length())
        {
            sbf.append(str.substring(index));
        }
        return sbf.toString();
    }
    
    /**
     * 通过字符串函数转换
     *
     * @param str
     * @return
     */
    public String replace_2(String str)
    {
        
        if (str.length() == 0 || str == "")
        {
            return "";
        }
        
        StringBuffer sbf = new StringBuffer();
        for (char c :
                str.toCharArray())
        {
            sbf.append(c == ' ' ? "%20" : c);
        }
        return sbf.toString();
    }
    
    /**
     * 正则表达式匹配
     *
     * @return
     */
    public String replace_3(String str)
    {
        if (str.length() == 0 || str == "")
        {
            return "";
        }
        return str.replaceAll("\\s", "%20");
    }
    
    
    /****
     *
     * 复习区
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     * "We Are Happy"
     * "We%20Are%20Happy"
     *
     * */
    
    
    public String getString_1(String inputStr)
    {
        StringBuilder sbr = new StringBuilder();
        int index = 0;
        for (int i = 0; i < inputStr.length(); i++)
        {
            if (inputStr.charAt(i) == ' ')
            {
                sbr.append(inputStr.substring(index, i));
                sbr.append("%20");
                index = i + 1;
            }
        }
        
        if (index < inputStr.length())
        {
            sbr.append(inputStr.substring(index));
        }
        
        return "";
        
    }
    
    
}


