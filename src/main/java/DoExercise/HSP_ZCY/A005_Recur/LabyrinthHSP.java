package DoExercise.HSP_ZCY.A005_Recur;


/**
 * 递归算法学习案例：迷宫
 * <p>
 * 1111111111
 * 1X00000001
 * 1000000001
 * 1110000001
 * 1000000001
 * 10000000Y1
 * 1111111111
 * <p>
 * 如上图所示表示迷宫，1表示墙，0表示通路，小球从X开始走到Y，问最短的路径是怎样的？
 */
public class LabyrinthHSP
{
    public static int[][] arr = new int[8][7];
    
    {
        for (int i = 0; i < 7; i++)
        {
            arr[0][i] = 1;
            arr[arr.length - 1][i] = 1;
        }
        
        for (int i = 0; i < 8; i++)
        {
            arr[i][0] = 1;
            arr[i][arr[0].length - 1] = 1;
        }
        
        arr[2][1] = 1;
        arr[2][2] = 1;
    }
    
    public static void main(String[] args)
    {
        LabyrinthHSP la = new LabyrinthHSP();
        la.printMatrixArr();
        la.setWay2(1, 1);
        System.out.println("---------------------------------------");
        la.printMatrixArr();
    }
    
    
    /**
     * 小球走迷宫
     * 确定一个策略(方法) 下->右->上->左 , 如果该点走不通，再回溯
     *
     * @param i 起始位
     * @param j 起始位
     * @return
     */
    public boolean setWay2(int i, int j)
    {
        if (arr[6][5] == 2)
        {
            return true;
        } else
        {
            if (arr[i][j] == 0)
            {
                arr[i][j] = 2;
                if (setWay2(i + 1, j) || setWay2(i, j + 1) || setWay2(i - 1, j) || setWay2(i, j - 1))
                {
                    return true;
                } else
                {
                    arr[i][j] = 3;
                    return false;
                }
            } else
            {
                return false;
            }
        }
    }
    
    
    
    public void printMatrixArr()
    {
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr[i].length; j++)
            {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}
