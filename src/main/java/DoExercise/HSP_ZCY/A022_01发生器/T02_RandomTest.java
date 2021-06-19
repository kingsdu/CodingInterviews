package DoExercise.HSP_ZCY.A022_01发生器;

/**
 * @Author: Du
 * @Date: 2021/6/10 15:12
 *
 *  问题：如何将Math.Random()的 [0,1) 的等概率返回x，变为等概率返回 x²，X³？
 *
 */
public class T02_RandomTest
{
    
    
    public static void main(String[] args)
    {
        test04();
    }
    
    
    private static void test06()
    {
        int testTimes = 100000;
        double x = 0.17;
        int count = 0;
        for (int i = 0; i < testTimes; i++)
        {
            if (xToxPower3() < x)//3次都命中x的范围，才会小于x，之和自然是x³
            {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);
        System.out.println(Math.pow(x, 3));
    }
    
    
    /**
     * 测试
     */
    private static void test04()
    {
        int testTimes = 100000;
        double x = 0.17;
        int count = 0;
        for (int i = 0; i < testTimes; i++)
        {
            if (xToxPower2() < x)//2次都命中x的范围，才会小于x，之和自然是x²
            {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);
        System.out.println(Math.pow(x, 2));
    }
    
    /**
     * X²
     *
     * @return
     */
    public static double xToxPower2()
    {
        return Math.max(Math.random(), Math.random());
    }
    
    /**
     * X³
     *
     * @return
     */
    public static double xToxPower3()
    {
        return Math.max(Math.random(), Math.max(Math.random(), Math.random()));
    }
    
    
    private static void test05()
    {
        int testTimes = 100000;
        double x = 0.17;
        int count = 0;
        for (int i = 0; i < testTimes; i++)
        {
            if (xToxPower2Min() < x)// 1-x表示1个数没命中的概率，
            {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);
        System.out.println((double) 1 - Math.pow((double) 1 - x, 2));//表示命中的概率
    }
    
    
    /**
     * Math.min表示的含义
     * 1-(1-x)²
     *
     * @return
     */
    public static double xToxPower2Min()
    {
        return Math.min(Math.random(), Math.random());
    }
    
    
}
