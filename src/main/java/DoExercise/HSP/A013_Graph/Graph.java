package DoExercise.HSP.A013_Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph
{
    public static void main(String[] args)
    {
        int n = 8;  //结点的个数
        String vertex[] = {"A", "B", "C", "D", "E", "F", "G", "H"};
        Graph graph = new Graph(n);
        for (String v : vertex)
        {
            graph.insertVertex(v);
        }
        
        //更新边的关系
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);
        
        graph.showGraph();
        graph.dfs();
    
        graph.bfs();
    }
    
    private ArrayList<String> vertexList;//存储顶点集合
    private int[][] edges; //存储图对应的邻结矩阵
    private int numOfEdges; //表示边的数目
    private boolean[] isVisited;//记录某个结点是否被访问
    
    public Graph(int n)
    {
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;
    }
    
    public int getNumOfVertex()
    {
        return vertexList.size();
    }
    
    public int getNumOfEdges()
    {
        return numOfEdges;
    }
    
    public void showGraph()
    {
        for (int[] link : edges)
        {
            System.out.println(Arrays.toString(link));
        }
    }
    
    public int getFirstNeighbor(int index)
    {
        for (int j = 0; j < vertexList.size(); j++)
        {
            if (edges[index][j] > 0)
            {
                return j;
            }
        }
        return -1;
    }
    
    public int getNextNeighbor(int v1, int v2)
    {
        for (int j = v2 + 1; j < vertexList.size(); j++)
        {
            if (edges[v1][j] > 0)
            {
                return j;
            }
        }
        return -1;
    }
    
    public String getValueByIndex(int i)
    {
        return vertexList.get(i);
    }
    
    public int getWeight(int v1, int v2)
    {
        return edges[v1][v2];
    }
    
    public void insertVertex(String vertex)
    {
        vertexList.add(vertex);
    }
    
    /**
     * @param v1     表示点的下标即使第几个顶点  "A"-"B" "A"->0 "B"->1
     * @param v2     第二个顶点对应的下标
     * @param weight 表示
     */
    public void insertEdge(int v1, int v2, int weight)
    {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
    
    
    public void dfs()
    {
        isVisited = new boolean[vertexList.size()];
        //遍历所有的结点，进行dfs[回溯]
        for (int i = 0; i < getNumOfVertex(); i++)
        {
            if (!isVisited[i])
            {
                dfs(isVisited, i);
            }
        }
    }
    
    
    private void dfs(boolean[] isVisited, int i)
    {
        System.out.print(getValueByIndex(i) + "->");
        isVisited[i] = true;
        int w = getFirstNeighbor(i);
        while (w != -1)
        {
            if (!isVisited[w])
            {
                dfs(isVisited, w);
            }
            w = getNextNeighbor(i, w);
        }
    }
    
    public void bfs()
    {
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < getNumOfVertex(); i++)
        {
            if (!isVisited[i])
            {
                bfs(isVisited, i);
            }
        }
    }
    
    private void bfs(boolean[] isVisited, int i)
    {
        int u;
        int w;
        LinkedList queue = new LinkedList();
        System.out.print(getValueByIndex(i) + "=>");
        isVisited[i] = true;
        queue.addLast(i);
        
        while (!queue.isEmpty())
        {
            u = (Integer) queue.removeFirst();
            w = getFirstNeighbor(u);
            while (w != -1)
            {
                if (!isVisited[w])
                {
                    System.out.print(getValueByIndex(w) + "=>");
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                w = getNextNeighbor(u, w);
            }
        }
    }
}
