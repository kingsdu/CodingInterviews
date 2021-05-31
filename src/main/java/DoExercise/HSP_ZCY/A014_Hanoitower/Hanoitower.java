package DoExercise.HSP_ZCY.A014_Hanoitower;

/**
 * 汉诺塔的移动的方法
 * 使用分治算法
 *
 * 1、将移动的步骤抽象出来
 * 2、使用分治进行划分
 */
public class Hanoitower
{
    
    public static int times = 0;
    
    public static void main(String[] args)
    {
        hanoiTower(3, 'A', 'B', 'C');
    }
    
    
    public static void move(int disk, char M, char N)
    {
        System.out.println("第" + (++times) + "次移动，盘子" + disk + "  " + M + "------>" + N);
    }
    
    public static void hanoiTower(int num, char a, char b, char c)
    {
        if (num == 1)
        {
            move(num, a, c);
        } else
        {
            //如果我们有 n >= 2 情况，我们总是可以看做是两个盘 1.最下边的一个盘 2. 上面的所有盘
            //1. 先把 最上面的所有盘 A->B， 移动过程会使用到 c
            hanoiTower(num - 1, a, c, b);
            //2. 把最下边的盘 A->C
            move(num, a, c);
            //3. 把B塔的所有盘 从 B->C , 移动过程使用到 a塔
            hanoiTower(num - 1, b, a, c);
            
        }
    }
}
