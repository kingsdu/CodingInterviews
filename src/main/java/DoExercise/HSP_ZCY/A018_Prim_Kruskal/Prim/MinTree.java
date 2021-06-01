package DoExercise.HSP_ZCY.A018_Prim_Kruskal.Prim;

import java.util.Arrays;

public class MinTree
{
    
    /**
     * @param graph  图对象
     * @param verxs  图对应的顶点个数
     * @param data   图的各个顶点的值
     * @param weight 图的邻接矩阵
     */
    public void createGraph(MGraph graph, int verxs, char data[], int[][] weight)
    {
        int i, j;
        for (i = 0; i < verxs; i++)
        {
            graph.data[i] = data[i];
            for (j = 0; j < verxs; j++)
            {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }
    
    //显示图的邻接矩阵
    public void showGraph(MGraph graph)
    {
        for (int[] link : graph.weight)
        {
            System.out.println(Arrays.toString(link));
        }
    }
    
    /**
     * @param graph 图
     * @param v     表示从图的第几个顶点开始生成'A'->0 'B'->1...
     */
    public void prim(MGraph graph, int v)
    {
        //visited[] 标记结点(顶点)是否被访问过
        int visited[] = new int[graph.verxs];

        //把当前这个结点标记为已访问
        visited[v] = 1;
        //h1 和 h2 记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;
        int minWeight = 10000; //将 minWeight 初始成一个大数，后面在遍历过程中，会被替换
        for (int k = 1; k < graph.verxs; k++) //因为有 graph.verxs顶点，普利姆算法结束后，有 graph.verxs-1边
        {
            //这个是确定每一次生成的子图 ，和哪个结点的距离最近
            for (int i = 0; i < graph.verxs; i++)
            {// i结点表示被访问过的结点
                for (int j = 0; j < graph.verxs; j++)
                {//j结点表示还没有访问过的结点
                    //寻找已经访问过的结点和未访问过的结点间的权值最小的边
                    if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight)
                    {
                        //替换minWeight
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            //找到一条边是最小
            System.out.println("边<" + graph.data[h1] + "," + graph.data[h2] + "> 权值:" + minWeight);
            //将当前这个结点标记为已经访问
            visited[h2] = 1;
            //minWeight 重新设置为最大值 10000
            minWeight = 10000;
        }
        
    }
}
