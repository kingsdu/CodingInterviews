package Jianzhi_Offer;

/**
 *
 * <p>
 * 题目：
 * 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 * <p>
 * 输入：10，输出：2
 * <p>
 * 1、该数32位二进制是什么意思？怎么转化？
 * 答案：其实没意思，就是表示一个二进制数，前面用0表示，一共32位
 */
public class Offer011_NumberOf1
{
    /**
     * 大神巧妙的思路：
     * 如果一个整数不为0，那么该整数至少有是1。
     * 如果我们将这个整数-1，则原来处在该数最右边的1就会变为0，而原来1后面的0都会变成1(如果1后边还有0的话)。其余位数将不受影响。
     * 例如：
     * 二进制：1100，-1，1011，-1，1010，-1，1001，-1，1000
     * 这时如果我们如果在将原来的整数1100和减一后的整数1011做&运算，即 1100 & 1011，则从原来整数最右边一个1开始的所有位都会变成0。
     * 1100 & 1011 = 1000
     * 也就是说，把一个整数-1，在于这个整数本身做&操作，会将该整数右边的1变为0。
     * 这个整数有多少个1，就能进行多少次这样的操作。
     *
     * 所以上面的思路可以用代码表示。
     *
     * @param number
     * @return
     */
    public int numberOf1_1(int number)
    {
        int count = 0;
        while (number != 0)
        {
            count++;
            number &= (number - 1);
        }
        return count;
    }

    /**
     *
     * 其他方法详细描述答案
     * https://blog.nowcoder.net/n/82793d9724ff4f07bb07ba5cdf19b261?f=comment
     *
     */


    /**
     * 按照正常的思维编写的代码
     * <p>
     * 正数负数分开考虑
     * 对于正数：
     * 1、通过取模，余数为1，count++;
     * <p>
     * 对于负数
     * 1、求出原码
     * 2、求出反码
     * 3、求出补码
     *
     * @param number
     * @return
     */
    public int numberOf1_2(int number)
    {
        int count = 0;
        if (number > 0)
        {
            while (number > 0)
            {
                if (number % 2 == 1) count++;
                number /= 2;
            }
        } else
        {
            if (number == (-2147483648)) return 1;

            StringBuilder sbr = new StringBuilder();
            number = -number;
            while (number > 0)
            {
                sbr.append(number % 2);
                number /= 2;
            }
            sbr = sbr.reverse();

            //设置反码
            StringBuilder sb1 = new StringBuilder();
            sb1.append("1");
            for (int i = 0; i < 31 - sbr.length(); i++)
            {
                sb1.append("0");
            }
            sb1.append(sbr);

            //原码取反 = 反码
            for (int i = 1; i < sb1.length(); i++)
            {
                if (sb1.charAt(i) == '0')
                {
                    sb1.setCharAt(i, '1');
                } else
                {
                    sb1.setCharAt(i, '0');
                }
            }
            //反码+1 = 补码
            for (int i = sb1.length() - 1; i > 0; i--)
            {
                if (sb1.charAt(i) == '0')
                {
                    sb1.setCharAt(i, '1');
                    break;
                } else
                {
                    sb1.setCharAt(i, '0');
                }
            }
            //统计补码中1的个数
            for (int i = 0; i < sb1.length(); i++)
            {
                if(sb1.charAt(i) == '1'){
                    count++;
                }
            }

        }
        return count;
    }


    public static void main(String[] args)
    {
        Offer011_NumberOf1 numberOf1 = new Offer011_NumberOf1();
        System.out.println(numberOf1.numberOf1_1(-100));
        System.out.println(numberOf1.numberOf1_2(-100));
    }

}
