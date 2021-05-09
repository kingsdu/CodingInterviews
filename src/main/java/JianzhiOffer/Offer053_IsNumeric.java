package JianzhiOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * <p>
 * 规律：
 * 无E
 * 1、必须是数字或符号或小数点，且符号和小数点不能出现超过1次；
 * 有E
 * 1、E后面必须是可以带最多一个符号的整数，不能是小数、不能为空
 * <p>
 * 方式：
 * 1 搜索
 */
public class Offer053_IsNumeric
{
    
    public static void main(String[] args)
    {
        String str = "12e";
        System.out.println(isNumeric_1(str));
    }
    
    
    /**
     * 一个个情况思考，程序的时间复杂度很高
     * 自己写的思路
     *
     * @param str
     * @return
     */
    public static boolean isNumeric_1(String str)
    {
        if (str == null || str.length() == 0)
        {
            return false;
        }
        
        char[] chars = str.toCharArray();
        int size = chars.length;
        boolean hasE = false, hasEOP = false, hasNum = false;
        int opCount = 0, pointCount = 0;
        for (int i = 0; i < size; i++)
        {
            if ((chars[i] >= '0' && chars[i] <= '9') || (chars[i] == 'E') ||
                    (chars[i] == 'e') || (chars[i] == '.') || (chars[i] == '+') || (chars[i] == '-'))
            {
                if ((chars[i] >= '0' && chars[i] <= '9' && !hasNum))
                {
                    hasNum = true;
                } else if ((chars[i] == '.'))
                {
                    if (i == size - 1)
                    {
                        return false;
                    }
                    
                    if (hasE)
                    {
                        return false;
                    } else
                    {
                        if (pointCount > 0)
                        {
                            return false;
                        } else
                        {
                            pointCount++;
                        }
                    }
                } else if ((chars[i] == '+') || (chars[i] == '-'))
                {   //数字后，e前面出现
                    if (hasNum && !hasE)
                    {
                        return false;
                    } else if (i == size - 1)//最后一位出现
                    {
                        return false;
                    } else
                    {
                        if (opCount == 0)
                        {
                            opCount++;
                        } else if (opCount == 1 && hasEOP)
                        {
                            opCount++;
                        } else
                        {
                            return false;
                        }
                    }
                } else if ((chars[i] == 'E') || (chars[i] == 'e'))
                {   //防止e后面连续+-和e前面后面各有一个+-混淆
                    if (!hasEOP && opCount > 0)
                    {
                        hasEOP = true;
                    }
                    
                    if (!hasNum)
                    {
                        return false;
                    }
                    
                    if (i == size - 1)
                    {
                        return false;
                    }
                    
                    hasE = true;
                }
            } else
            {
                return false;
            }
        }
        return true;
    }
    
    public boolean isNumber_2(String s)
    {
        if (s == null || s.length() == 0) return false; // s为空对象或 s长度为0(空字符串)时, 不能表示数值
        boolean isNum = false, isDot = false, ise_or_E = false; // 标记是否遇到数位、小数点、‘e’或'E'
        char[] str = s.trim().toCharArray();  // 删除字符串头尾的空格，转为字符数组，方便遍历判断每个字符
        for (int i = 0; i < str.length; i++)
        {
            if (str[i] >= '0' && str[i] <= '9') isNum = true; // 判断当前字符是否为 0~9 的数位
            else if (str[i] == '.')
            { // 遇到小数点
                if (isDot || ise_or_E) return false; // 小数点之前可以没有整数，但是不能重复出现小数点、或出现‘e’、'E'
                isDot = true; // 标记已经遇到小数点
            } else if (str[i] == 'e' || str[i] == 'E')
            { // 遇到‘e’或'E'
                if (!isNum || ise_or_E) return false; // ‘e’或'E'前面必须有整数，且前面不能重复出现‘e’或'E'
                ise_or_E = true; // 标记已经遇到‘e’或'E'
                isNum = false; // 重置isNum，因为‘e’或'E'之后也必须接上整数，防止出现 123e或者123e+的非法情况
            } else if (str[i] == '-' || str[i] == '+')
            {
                if (i != 0 && str[i - 1] != 'e' && str[i - 1] != 'E')
                    return false; // 正负号只可能出现在第一个位置，或者出现在‘e’或'E'的后面一个位置
            } else return false; // 其它情况均为不合法字符
        }
        return isNum;
    }
    
    /**
     * 有限状态自动机
     * 这个思维是真滴厉害
     *
     * 定义了所有状态的可能性，查找每个状态时，继续向后判断当下状态的下一个状态是否符合要求
     * 难点在状态的定义
     *
     * @param s
     * @return
     */
    public boolean isNumber_3(String s)
    {
        Map[] states = {
                new HashMap<Character, Integer>()
                {{
                    put(' ', 0);
                    put('s', 1);
                    put('d', 2);
                    put('.', 4);
                }}, // 0.
                new HashMap<Character, Integer>()
                {{
                    put('d', 2);
                    put('.', 4);
                }},                           // 1.
                new HashMap<Character, Integer>()
                {{
                    put('d', 2);
                    put('.', 3);
                    put('e', 5);
                    put(' ', 8);
                }}, // 2.
                new HashMap<Character, Integer>()
                {{
                    put('d', 3);
                    put('e', 5);
                    put(' ', 8);
                }},              // 3.
                new HashMap<Character, Integer>()
                {{
                    put('d', 3);
                }},                                        // 4.
                new HashMap<Character, Integer>()
                {{
                    put('s', 6);
                    put('d', 7);
                }},                           // 5.
                new HashMap<Character, Integer>()
                {{
                    put('d', 7);
                }},                                        // 6.
                new HashMap<Character, Integer>()
                {{
                    put('d', 7);
                    put(' ', 8);
                }},                           // 7.
                new HashMap<Character, Integer>()
                {{
                    put(' ', 8);
                }}};
        int p = 0;
        char t;
        for (char c : s.toCharArray())
        {
            if (c >= '0' && c <= '9') t = 'd';
            else if (c == '+' || c == '-') t = 's';
            else if (c == 'e' || c == 'E') t = 'e';
            else if (c == '.' || c == ' ') t = c;
            else t = '?';
            if (!states[p].containsKey(t)) return false;
            p = (int) states[p].get(t);
        }
        return p == 2 || p == 3 || p == 7 || p == 8;
    }
    
    
}