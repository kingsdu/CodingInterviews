package DoExercise.JianzhiOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 考察点：多种情况分类综合统计
 *
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 *
 * 方式：
 * 1 搜索
 * 2 有限状态自动机
 *
 */
public class Offer053_IsNumeric
{
    
    public static void main(String[] args)
    {
        String str = "-1E-16";
        System.out.println(isNumber_1(str));
    }
    
    
    /**
     *
     * 1、小数点之前可以没有整数，但是不能重复出现小数点、或出现'e'、'E'
     * 2、'e'或'E'前面必须有整数，且前面不能重复出现'e'或'E'
     * 3、'e'或'E'之后也必须接上整数，防止出现 123e或者123e+的非法情况
     * 4、正负号只可能出现在第一个位置，或者出现在‘e’或'E'的后面第一个位置
     *
     * 难在情况的分类：各种字符负责各种字符的统计
     *
     * @param s
     * @return
     */
    public static boolean isNumber_1(String s)
    {
        if (s == null || s.length() == 0) return false;
        boolean isNum = false, isDot = false, ise_or_E = false;
        char[] str = s.trim().toCharArray();
        for (int i = 0; i < str.length; i++)
        {
            if (str[i] >= '0' && str[i] <= '9') isNum = true;
            else if (str[i] == '.')
            {
                if (isDot || ise_or_E) return false;
                isDot = true;
            } else if (str[i] == 'e' || str[i] == 'E')
            {
                if (!isNum || ise_or_E) return false;
                ise_or_E = true;
                isNum = false;
            } else if (str[i] == '-' || str[i] == '+')
            {
                if (i != 0 && str[i - 1] != 'e' && str[i - 1] != 'E')//这个地方是&&，就是3个满足一个就符合规定，如果三个都不满足就不行
                    return false;
            } else return false;
        }
        return isNum;
    }
    
    /**
     * 有限状态自动机
     * 这个思维是真滴厉害
     * <p>
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