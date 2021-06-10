package DoExercise.HSP_ZCY.A022_01发生器;

/**
 * @Author: Du
 * @Date: 2021/6/10 15:17
 *
 * 重点：
 * 已知一个可以返回1~5的等概率数字的函数f1()
 * 在不操作f1()的情况下，如何计算 1~7的等概率数字的函数g()？
 *
 * 思路
 * 1、将1~5改成0 1发生器
 * 2、因为要得到的是1~7，可以用3个二进制位表示，所以 roll 3次1~5改成0 1发生器，则每个位置是0或1的概率是相等的
 *    在进行移位操作就可以得到得到000~111 等概率返回，即可以得到0~7返回
 * 3、在将0~7转换成 0~6等概率数
 * 4、将0~6等概率数 + 1得到最终结果
 *
 * */
public class T03_RandomTest
{
    
    /**
     * 如何得到
     * 得到1~7等概率次数
     */
    private static void test09()
    {
        int testTimes = 100000;
        int count[] = new int[8];
        
        for (int i = 0; i < testTimes; i++)
        {
            count[g()]++;
        }
        
        for (int i = 0; i < 8; i++)
        {
            System.out.println(i + "数 出现了" + count[i] + "次");
        }
    }
    
    /**
     * 得到0~6等概率次数
     */
    private static void test08()
    {
        int testTimes = 100000;
        int count[] = new int[8];
        
        for (int i = 0; i < testTimes; i++)
        {
            count[f4()]++;
        }
        
        for (int i = 0; i < 7; i++)
        {
            System.out.println(i + "数 出现了" + count[i] + "次");
        }
    }
    
    
    /**
     * 得到0到7随机
     */
    private static void test07()
    {
        int testTimes = 100000;
        int count[] = new int[8];
        
        for (int i = 0; i < testTimes; i++)
        {
            count[f3()]++;
        }
        
        for (int i = 0; i < 8; i++)
        {
            System.out.println(i + "数 出现了" + count[i] + "次");
        }
    }
    
    
    /**
     * 0~5等概率返回
     */
    private static void test06()
    {
        int count = 0;
        int testTimes = 100000;
        
        for (int i = 0; i < testTimes; i++)
        {
            if (f2() == 0)
            {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);
    }
    
    
    /**
     * 已知函数
     */
    private static void test061()
    {
        int testTimes = 100000;
        int count[] = new int[8];
        
        for (int i = 0; i < testTimes; i++)
        {
            count[f1()]++;
        }
        
        for (int i = 0; i < 8; i++)
        {
            System.out.println(i + "数 出现了" + count[i] + "次");
        }
    }
    
    /**
     * 已知函数能返回等概率1~5的函数
     * 如何得到
     *
     * @return
     */
    public static int f1()
    {
        return (int) (Math.random() * 5) + 1;//Math.random() [0,1) * 5 -> [0,4) +1 ->[1,5)
    }
    
    
    /**
     * 1~5改成0 1发生器
     * <p>
     * 如果 1~2 返回0
     * 3 重做
     * 4~5 返回 1
     *
     * @return
     */
    public static int f2()
    {
        int ans = 0;
        do
        {
            ans = f1();
        } while (ans == 3);
        return ans < 3 ? 0 : 1;
    }
    
    /**
     * 因为要得到的是1~7，可以用3个二进制位表示
     * 所以 roll 3次 每个位置是0或1的概率是相等的
     * 在进行移位操作就可以得到得到000~111 等概率返回，
     * 即可以得到0~7返回
     *
     * @return
     */
    public static int f3()
    {
        return (f2() << 2) + (f2() << 1) + (f2());
    }
    
    /**
     * 0~6等概率数
     *
     * @return
     */
    public static int f4()
    {
        int ans = 0;
        do
        {
            ans = f3();
        } while (ans == 7);
        return ans;
    }
    
    
    /**
     * 0~6等概率数 + 1 得到结果 1~7 的等概率数
     *
     * @return
     */
    public static int g()
    {
        return f4() + 1;
    }
    
}
