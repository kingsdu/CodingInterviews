package DoExercise.JianzhiOffer;

/**
 * @Author: Du
 * @Date: 2021/7/8 7:21
 * <p>
 * <p>
 * https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 */
public class Offer077_把数字翻译成字符串
{
    
    public static void main(String[] args)
    {
        System.out.println(translateNum1(25));
    }
    
    
    public static int translateNum(int num)
    {
        String s = String.valueOf(num);
        int a = 1, b = 1;
        for (int i = 2; i <= s.length(); i++)
        {
            String tmp = s.substring(i - 2, i);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }
    
    
    /**
     * 上面方法还是占用的s的空间，其实可以对num进行操作，从最后一位开始，每次取2位判断，这样可以省去s的空间
     *
     * @param num
     * @return
     */
    public static int translateNum1(int num)
    {
        int a = 1, b = 1, x, y = num % 10;
        while (num != 0)
        {
            num /= 10;
            x = num % 10;
            int tmp = 10 * x + y;
            int c = (tmp >= 10 && tmp <= 25) ? a + b : a;
            b = a;
            a = c;
            y = x;
        }
        return a;
    }
    
    
    public static char tans2Char(char c)
    {
        return (char) (c + '0');
    }
    
}
