package DoExercise.HSP_ZCY.A019_Floyd_Dijkstra.Dijkstra;

public class DijkstraAlgorithm
{
    public static void main(String[] args)
    {
//        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
//        //邻接矩阵
//        int[][] matrix = new int[vertex.length][vertex.length];
//        final int N = 65535;// 表示不可以连接
//        matrix[0] = new int[]{N, 5, 7, N, N, N, 2};
//        matrix[1] = new int[]{5, N, N, 9, N, N, 3};
//        matrix[2] = new int[]{7, N, N, N, 8, N, N};
//        matrix[3] = new int[]{N, 9, N, N, N, 4, N};
//        matrix[4] = new int[]{N, N, 8, N, N, 5, 4};
//        matrix[5] = new int[]{N, N, N, 4, 5, N, 6};
//        matrix[6] = new int[]{2, 3, N, N, 4, 6, N};
//        //创建 Graph对象
//        Graph graph = new Graph(vertex, matrix);
//        //测试, 看看图的邻接矩阵是否ok
//        graph.showGraph();
//        //测试迪杰斯特拉算法
//        graph.dsj(2);//C
//        graph.showDijkstra();
        
        
        char[] vertex = {'0', '1', '2', '3', '4', '5', '6', '7', '8'};
        //邻接矩阵
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;// 表示不可以连接
        matrix[0] = new int[]{N, 4, N, N, N, N, N, 8, N};
        matrix[1] = new int[]{4, N, 8, N, N, N, N, 3, N};
        matrix[2] = new int[]{N, 8, N, 7, N, 4, N, N, 2};
        matrix[3] = new int[]{N, N, 7, N, 9, 14, N, N, N};
        matrix[4] = new int[]{N, N, N, 9, N, 10, N, N, N};
        matrix[5] = new int[]{N, N, 4, 14, 10, N, 2, N, N};
        matrix[6] = new int[]{N, N, N, N, N, 2, N, 6, 6};
        matrix[7] = new int[]{8, 3, N, N, N, N, 6, N, 1};
        matrix[8] = new int[]{N, N, 2, N, N, N, 6, 1, N};
        //创建 Graph对象
        Graph graph = new Graph(vertex, matrix);
        //测试, 看看图的邻接矩阵是否ok
        graph.showGraph();
        //测试迪杰斯特拉算法
        graph.dsj(0);//C
        graph.showDijkstra();
        
    }
}
