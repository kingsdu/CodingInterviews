package JavaSE.BLS.Collection.A01MSB.A03_Map;

import java.util.PriorityQueue;

public class T07_PriorityQueque
{
    public static void main(String[] args)
    {
        PriorityQueue<String> q = new PriorityQueue<>();
        
        q.add("c");
        q.add("e");
        q.add("a");
        q.add("d");
        q.add("z");
        
        for (int i = 0; i < 5; i++)//这里不能用q.size()
        {
            System.out.println(q.poll());
        }
    }
}
