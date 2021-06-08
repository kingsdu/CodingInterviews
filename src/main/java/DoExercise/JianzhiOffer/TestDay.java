package DoExercise.JianzhiOffer;

/**
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class TestDay
{
    
    
    public static void main(String[] args)
    {
    
    }
    
    
    public static boolean isNumber(String s)
    {
        char[] chars = s.trim().toCharArray();
        boolean isNum = false, isE = false, isDot = false;
        for (int i = 0; i < chars.length; i++)
        {
            if (chars[i] >= '0' || chars[i] <= '9')
            {
                isNum = true;
            } else if (chars[i] == '.')
            {
                if (isDot || isE) return false;
                isDot = true;
            } else if (chars[i] == 'e' || chars[i] == 'E')
            {
                if (!isNum || isE) return false;
                isE = true;
                isNum = false;
            } else if (chars[i] == '-' || chars[i] == '+')
            {
                if (i != 0 && (chars[i - 1] != 'e' || chars[i - 1] != 'E')) return false;
            } else
            {
                return false;
            }
        }
        return isNum;
    }
    
}
