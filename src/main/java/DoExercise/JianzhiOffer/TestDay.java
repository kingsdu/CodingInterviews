package DoExercise.JianzhiOffer;

import java.util.PriorityQueue;
import java.util.Queue;

public class TestDay
{
    //今天要刷的三道题:12;20;9
    public static void main(String[] args)
    {
        Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
        pq.add(1);
        pq.add(2);
        pq.add(3);
        pq.add(4);
        
        for (int x : pq)
        {
            System.out.print(x + " ");
        }
    }
    
    
}
