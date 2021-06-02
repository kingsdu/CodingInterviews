package DoExercise.HSP_ZCY.A019_Floyd_Dijkstra.Dijkstra;

import java.util.Arrays;

public class Graph
{
    private char[] vertex; // 顶点数组
    private int[][] matrix; // 邻接矩阵
    private VisitedVertex vv; //已经访问的顶点的集合
    
    // 构造器
    public Graph(char[] vertex, int[][] matrix)
    {
        this.vertex = vertex;
        this.matrix = matrix;
    }
    
    //显示结果
    public void showDijkstra()
    {
        vv.show();
    }
    
    // 显示图
    public void showGraph()
    {
        for (int[] link : matrix)
        {
            System.out.println(Arrays.toString(link));
        }
    }
    
    //迪杰斯特拉算法实现
    
    /**
     * @param index 表示出发顶点对应的下标
     */
    public void dsj(int index)
    {
        vv = new VisitedVertex(vertex.length, index);
        update(index);//更新index顶点到周围顶点的距离和前驱顶点
        for (int j = 1; j < vertex.length; j++)
        {
            index = vv.updateArr();// 选择并返回新的访问顶点
            update(index); // 更新index顶点到周围顶点的距离和前驱顶点
        }
    }
    
    
    /**
     *
     * 更新index下标顶点到周围顶点的距离和周围顶点的前驱顶点
     * @param index
     */
    private void update(int index)
    {
        int len = 0;
        //根据遍历我们的邻接矩阵的  matrix[index]行
        for (int j = 0; j < matrix[index].length; j++)
        {
            // len 含义是 : 出发顶点到index顶点的距离 + 从index顶点到j顶点的距离的和
            len = vv.getDis(index) + matrix[index][j];
            // 如果j顶点没有被访问过，并且 len 小于出发顶点到j顶点的距离，就需要更新
            if (!vv.in(j) && len < vv.getDis(j))
            {
                vv.updatePre(j, index); //更新j顶点的前驱为index顶点
                vv.updateDis(j, len); //更新出发顶点到j顶点的距离
            }
        }
    }
}
