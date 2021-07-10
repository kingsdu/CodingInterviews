package DoExercise.JianzhiOffer;


/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 * <p>
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * <p>
 * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 */
public class Offer043_左旋转字符串
{
    
    public static void main(String[] args)
    {
        String str = "abcdefg";
        int n = 2;
        System.out.println(reverseLeftWords2(str, n));
    }
    
    /**
     * 如果不允许用切片函数
     * 可以用求余算法
     *
     * @return
     */
    public static String reverseLeftWords2(String str, int n)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < n + str.length(); i++) sb.append(str.charAt(i % str.length()));
        return sb.toString();
    }
    
    /**
     * 切片拼接效率最高
     *
     * @param str
     * @param n
     * @return
     */
    public static String reverseLeftWords1(String str, int n)
    {
        if (null == str || str.length() == 0 || n > str.length())
        {
            return "";
        }
        String str1 = str.substring(0, n);
        String str2 = str.substring(n);
        return str2 + str1;
    }
    
}
