package JianzhiOffer;

/**
 *
 * 题目：不用库函数，字符串转整数
 *
 * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
 * 1、字符串开头可能会存在空格 和 +-符号
 * 2、如果传入的不是数字则，返回为0
 * 3、假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 *
 *
 * 考点：
 * 1、str到int的转换方式：str.charAt(j) - '0'
 * 2、数字存在超限情况的处理
 */
public class Offer049_StrToInt
{
    
    public static void main(String[] args)
    {
        System.out.println(strToInt("-123"));
    }
    
    public static int strToInt(String str)
    {
        if (str.length() == 0 || str == null)
        {
            return 0;
        }
        
        int res = 0, sign = 1, i = 0, length = str.length();
        while (str.charAt(i) == ' ')
        {
            if (++i == length)
            {
                return 0;
            }
        }
        
        if (str.charAt(i) == '-' || str.charAt(i) == '+')
        {
            if (str.charAt(i) == '-')
            {
                sign = -1;
            }
            i++;
        }
        
        for (int j = i; j < length; j++)
        {
            if (str.charAt(j) < '0' || str.charAt(j) > '9')
            {
                return 0;
            }
            int tmp = res * 10 + (str.charAt(j) - '0');
            if (tmp / 10 != res) return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = tmp;
        }
        return sign * res;
    }
    
    
}
