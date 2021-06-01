package DoExercise.HSP_ZCY.A018_Prim_Kruskal.Prim;

public class MGraph
{
    int verxs; //表示图的节点个数
    char[] data;//存放结点数据
    int[][] weight; //存放边，就是我们的邻接矩阵
    
    public MGraph(int verxs)
    {
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}
