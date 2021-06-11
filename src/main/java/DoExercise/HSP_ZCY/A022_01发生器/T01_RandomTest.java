package DoExercise.HSP_ZCY.A022_01发生器;

/**
 * @Author: Du
 * @Date: 2021/6/10 15:06
 *
 *
 * Math.Random()函数学习
 *
 * 1  Math.Random()默认会返回一个[0,1)间的等概率的数，很牛叉
 * 2 利用Math.Random()如何返回一个[0,8)等概率分布数字 ？
 * 3 利用Math.Random()如何返回一个0~9等概率数字 ？
 */
public class T01_RandomTest
{
    
    public static void main(String[] args)
    {
        test02();
    }
    
    /**
     *
     * 返回0~9等概率数字
     *
     *
     */
    private static void test03()
    {
        int K = 9;
        int testTimes = 100000;
        int[] count = new int[9];//count[0]表示0出现的次数......
        
        for (int i = 0; i < testTimes; i++)
        {
            int ans = (int) (Math.random() * K);
            count[ans]++;
        }
        //等概率
        for (int i = 0; i < K; i++)
        {
            System.out.println(i + "这个数 出现了" + count[i] + "次数");
        }
    }
    
    /**
     * 返回  [0,8)等概率分布数字
     */
    private static void test02()
    {
        int testTimes = 100000;
        int count = 0;
        //Math.random(); -> double -> [0，1) * 8 -> [0,8)依旧等概率分布
        for (int i = 0; i < testTimes; i++)
        {
            if (Math.random() * 8 < 4)//<4 ,0~8各占50%
            {
                count++;
            }
        }
        
        System.out.println((double) count / (double) testTimes);
    }
    
    
    /**
     *
     *
     * 测试 Math.random() 是否返回的是[0,1)等概率的数字
     *
     */
    private static void test01()
    {
        //Math.random(); -> double -> [0，1)
        int testTimes = 100000;
        int count = 0;
        
        for (int i = 0; i < testTimes; i++)
        {
            if (Math.random() < 0.6)
            {
                count++;
            }
        }
        
        System.out.println((double) count / (double) testTimes);
    }
    
    
}
