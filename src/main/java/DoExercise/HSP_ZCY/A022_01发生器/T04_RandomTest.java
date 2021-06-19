package DoExercise.HSP_ZCY.A022_01发生器;

/**
 * @Author: Du
 * @Date: 2021/6/10 15:22
 * <p>
 * 题目：如果0 1两个随机数出现的情况是不等概率，如何能将其变为0 1等概率随机数
 * 思路
 * 1、01可以变为 00 11 01 10 四种可能，而00 11 概率必不等，但是10 01 必相等
 * 2、利用该属性进行操作
 */
public class T04_RandomTest
{
    
    /**
     *
     * 返回的01等概率
     *
     * @param args
     */
    public static void main(String[] args)
    {
        int testTimes = 100000;
        int count[] = new int[3];
    
        for (int i = 0; i < testTimes; i++)
        {
            count[y()]++;
        }
    
        for (int i = 0; i < 3; i++)
        {
            System.out.println(i + "数 出现了" + count[i] + "次");
        }
    }
    
    
    /**
     * x会以固定概率的0 1出现，概率不等
     * 下面0的概率是0.84，剩下是1的概率
     * @return
     */
    public static int x()
    {
        return Math.random() < 0.84 ? 0 : 1;
    }
    
    /**
     *
     * 获取 01的等概率数
     *
     * @return
     */
    public static int y()
    {
        int ans = 0;
        do
        {
            ans = x();//必须要做出第一次和第二次不同的结果
        } while (ans == x());//如果第一次 == 第二次重做，所以能满足 01 和 10即可
        
        return ans;
    }
    
}
