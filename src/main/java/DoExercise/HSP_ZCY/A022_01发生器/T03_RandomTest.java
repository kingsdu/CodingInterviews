package DoExercise.HSP_ZCY.A022_01发生器;

/**
 * @Author: Du
 * @Date: 2021/6/10 15:17
 * <p>
 * 重点：
 * 已知一个可以返回1~5的等概率数字的函数f1()
 * 请问：在不操作f1()的情况下，如何计算 1~7 的等概率数字的函数g()？
 * <p>
 * 思路
 * 1、将1~5改成0 1发生器
 * 2、因为要得到的是1~7，可以用3个二进制位表示，所以 roll 3次1~5改成0 1发生器，则每个位置是0或1的概率是相等的
 * 在进行移位操作就可以得到得到000~111 等概率返回，即可以得到0~7返回
 * 3、在将0~7 roll成 0~6等概率数，就是7重roll
 * 4、将0~6等概率数 + 1得到最终结果
 */
public class T03_RandomTest
{
    public static void main(String[] args)
    {
        step_05_test();
    }
    
    //1、已知函数能返回等概率1~5的函数
    public static int step_01()
    {
        return (int) (Math.random() * 5) + 1;
    }
    
    //返回等概率1~5的函数测试
    private static void step_01_Test()
    {
        int testTimes = 100000;
        int count[] = new int[8];
        
        for (int i = 0; i < testTimes; i++)
        {
            count[step_01()]++;
        }
        
        for (int i = 0; i < 8; i++)
        {
            System.out.println(i + "数 出现了" + count[i] + "次");
        }
    }
    
    //2、1~5改成0 1发生器
    public static int step_02()
    {
        int ans = 0;
        do
        {
            ans = step_01();
        } while (ans == 3);
        return ans < 3 ? 0 : 1;
    }
    
    //1~5改成0 1发生器测试
    private static void step_02_test()
    {
        int count = 0;
        int testTimes = 100000;
        
        for (int i = 0; i < testTimes; i++)
        {
            if (step_02() == 0)
            {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);
    }
    
    //3、用二进制表示1~7的数字
    //因为要得到的是1~7，可以用3个二进制位表示,所以 roll 3次 每个位置是0或1的概率是相等的
    //在进行移位操作就可以得到得到000~111 等概率返回，即可以得到0~7返回
    public static int step_03()
    {
        return (step_02() << 2) + (step_02() << 1) + (step_02());
    }
    
    //得到0到7随机测试
    private static void step_03_test()
    {
        int testTimes = 100000;
        int count[] = new int[8];
        
        for (int i = 0; i < testTimes; i++)
        {
            count[step_03()]++;
        }
        
        for (int i = 0; i < 8; i++)
        {
            System.out.println(i + "数 出现了" + count[i] + "次");
        }
    }
    
    //4 、0~6等概率数
    public static int step_04()
    {
        int ans = 0;
        do
        {
            ans = step_03();
        } while (ans == 7);
        return ans;
    }
    
    //得到0~6等概率次数测试
    private static void step_04_test()
    {
        int testTimes = 100000;
        int count[] = new int[8];
        for (int i = 0; i < testTimes; i++)
        {
            count[step_04()]++;
        }
        for (int i = 0; i < 7; i++)
        {
            System.out.println(i + "数 出现了" + count[i] + "次");
        }
    }
    
    //0~6等概率数 + 1 得到结果 1~7 的等概率数
    public static int step_05()
    {
        return step_04() + 1;
    }
    
    //得到1~7等概率次数测试
    private static void step_05_test()
    {
        int testTimes = 100000;
        int count[] = new int[8];
        
        for (int i = 0; i < testTimes; i++)
        {
            count[step_05()]++;
        }
        
        for (int i = 0; i < 8; i++)
        {
            System.out.println(i + "数 出现了" + count[i] + "次");
        }
    }
}
