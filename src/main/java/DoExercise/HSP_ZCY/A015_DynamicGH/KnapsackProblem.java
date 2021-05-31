package DoExercise.HSP_ZCY.A015_DynamicGH;

/**
 * 背包问题：
 * 有一个背包，容量为4磅
 * 吉他(G) 1 1500
 * 音响(S) 4 3000
 * 电脑(L) 3 2000
 * <p>
 * （1）要求达到的目标为装入的背包的总价值最大，并且重量不超出容量
 * （2）要求装入的物品不能重复
 */
public class KnapsackProblem
{
    
    public static void main(String[] args)
    {
        int[] w = {1, 4, 3};
        int[] val = {1500, 3000, 2000};
        int m = 4; //背包的容量
        int n = val.length; //物品的个数
        
        //v[i][j] 表示在前i个物品中能够装入容量为j的背包中的最大价值
        int[][] v = new int[n + 1][m + 1];
        //为了记录放入商品的情况，我们定一个二维数组
        int[][] path = new int[n + 1][m + 1];
        
        //初始化第一行和第一列, 这里在本程序中，可以不去处理，因为默认就是0
        for (int i = 0; i < v.length; i++)
        {
            v[i][0] = 0;
        }
        for (int i = 0; i < v[0].length; i++)
        {
            v[0][i] = 0;
        }
        
        
        for (int i = 1; i < v.length; i++)
        {
            for (int j = 1; j < v[0].length; j++)
            {
                if (w[i - 1] > j)
                {
                    v[i][j] = v[i - 1][j];
                } else
                {
                    //v[i - 1][j]:  上一个单元格的装入的最大值
                    //v[i] : 表示当前商品的价值
                    //v[i-1][j-w[i]] : 装入i-1商品，到剩余空间j-w[i]的最大值
                    if (v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]])
                    {
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        path[i][j] = 1;
                    } else
                    {
                        v[i][j] = v[i - 1][j];
                    }
                    
                }
            }
        }
        
        for (int i = 0; i < v.length; i++)
        {
            for (int j = 0; j < v[i].length; j++)
            {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println("============================");
        
        int i = path.length - 1;
        int j = path[0].length - 1;
        while (i > 0 && j > 0)
        {
            if (path[i][j] == 1)
            {
                System.out.printf("第%d个商品放入到背包\n", i);
                j -= w[i - 1];
            }
            i--;
        }
        
    }
}
