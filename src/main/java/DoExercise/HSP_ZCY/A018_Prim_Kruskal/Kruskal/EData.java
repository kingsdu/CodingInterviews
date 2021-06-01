package DoExercise.HSP_ZCY.A018_Prim_Kruskal.Kruskal;

public class EData
{
    char start; //边的一个点
    char end; //边的另外一个点
    int weight; //边的权值
    
    //构造器
    public EData(char start, char end, int weight)
    {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
    
    //重写toString, 便于输出边信息
    @Override
    public String toString()
    {
        return "EData [<" + start + ", " + end + ">= " + weight + "]";
    }
}
